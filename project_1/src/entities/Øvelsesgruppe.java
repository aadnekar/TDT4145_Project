package entities;

import java.sql.*;

public class Øvelsesgruppe extends ActiveDomainObject {

	private int øvelsesgruppe_id;
	private String navn;
	
	public Øvelsesgruppe(String navn) {
		this.navn = navn;
	}

	@Override
	public void initialize(Connection conn) {
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
						"select navn from Øvelsesgruppe where øvelsesgruppe_id = " + øvelsesgruppe_id + " ;"
					);
			while (rs.next()) {
				rs.getString("navn");
			}
		} catch(Exception e) {
			System.out.println("db error during select of Øvelsesgruppe: " + e);
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
					"insert into Øvelsesgruppe (navn) values ('" +
					navn + "');"
					);
		} catch(Exception e) {
			System.out.println("db error during insertion of Øvelsesgruppe: " + e);
		}	
	}
}
