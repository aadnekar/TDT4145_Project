package application;

import java.sql.*;

public class Apparat extends ActiveDomainObject {
	
	private int apparat_id;
	private String navn, beskrivelse;
	
	public Apparat(String navn, String beskrivelse) {
		this.navn = navn;
		this.beskrivelse = beskrivelse;
	}
	
	public Apparat(String navn) {
		this(navn, "Ingen beskrivelse for dette apparatet");		
	}
	
	
	

	@Override
	public void initialize(Connection conn) {
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
					"select navn, beskrivelse" +
					"from Apparat where apparat_id=" + apparat_id
					);
			while (rs.next()) {
				navn = rs.getString("navn");
				beskrivelse = rs.getString("beskrivelse");
			}
		} catch(Exception e) {
			System.out.println("db error during select of Apparat= " + e);
			return;
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
			stmt.executeUpdate(
					"insert into Apparat (navn, beskrivelse)" + 
					"values ('" + navn + "', '" + beskrivelse + "');"
					);
		} catch(Exception e) {
			System.out.println("db error during insert of Apparat= " + e);
			return;
		}
	}
	
	
	
}
