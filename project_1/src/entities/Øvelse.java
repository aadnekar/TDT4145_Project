package entities;

import java.sql.*;

public class Øvelse extends ActiveDomainObject {

	private int			øvelse_id,
						antall_kilo,
						antall_sett,
						apparat_id;
	
	private String 		navn,
						beskrivelse;
	
	private static int NO_ID = -1;
	
	public Øvelse(String navn, String beskrivelse, int antall_kilo, int antall_sett, int apparat_id) {
		this.navn = navn;
		this.beskrivelse = beskrivelse;
		this.antall_kilo = antall_kilo;
		this.antall_sett = antall_sett;
		this.apparat_id = apparat_id;
	}
	
	public Øvelse(String navn, String beskrivelse, int antall_kilo, int antall_sett) {
		this(navn, beskrivelse, antall_kilo, antall_sett, NO_ID);
	}

	@Override
	public void initialize(Connection conn) {
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
						"select navn, beskrivelse, antall_kilo, antall_sett, apparat_id " +
						"from Øvelse where øvelse_id=" + øvelse_id
					);
			while(rs.next()) {
				rs.getString("navn");
				rs.getString("beskrivelse");
				rs.getInt("antall_kilo");
				rs.getInt("antall_sett");
				rs.getInt("apparat_id");
			}
		} catch(Exception e) {
			System.out.println("db error during select of Øvelse= " + e);
		}
		
	}

	@Override
	public void refresh(Connection conn) {
		initialize(conn);
		
	}

	@Override
	public void save(Connection conn) {
		try {
			Statement stmt = conn.createStatement();
			if (apparat_id == -1) {
				stmt.executeUpdate(
						"insert into Øvelse (navn, beskrivelse, antall_kilo, antall_sett, apparat_id) values ('"
					+	navn + "', '"
					+	beskrivelse + "', "
					+	antall_kilo + ", "
					+	antall_sett + ", "
					+	"NULL"	+ ")"
					);
			} else {
				stmt.executeUpdate(
						"insert into Øvelse (navn, beskrivelse, antall_kilo, antall_sett, apparat_id) values ('"
					+	navn + "', '"
					+	beskrivelse + "', "
					+	antall_kilo + ", "
					+	antall_sett + ", "
					+	apparat_id	+ ")"
					);
			}
		} catch(Exception e) {
			System.out.println("db error during insert of Øvelse= " + e);
		}
		
	}
}