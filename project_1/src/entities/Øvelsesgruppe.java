package entities;

import java.sql.*;

public class �velsesgruppe extends ActiveDomainObject {

	private int �velsesgruppe_id;
	private String navn;
	
	public �velsesgruppe(String navn) {
		this.navn = navn;
	}

	@Override
	public void initialize(Connection conn) {
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
						"select navn from �velsesgruppe where �velsesgruppe_id = " + �velsesgruppe_id + " ;"
					);
			while (rs.next()) {
				rs.getString("navn");
			}
		} catch(Exception e) {
			System.out.println("db error during select of �velsesgruppe: " + e);
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
					"insert into �velsesgruppe (navn) values ('" +
					navn + "');"
					);
		} catch(Exception e) {
			System.out.println("db error during insertion of �velsesgruppe: " + e);
		}	
	}
}
