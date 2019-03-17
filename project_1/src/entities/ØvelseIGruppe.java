package entities;

import java.sql.Connection;
import java.sql.Statement;

public class �velseIGruppe extends ActiveDomainObject {

	private int �velsesgruppe_id, �velse_id;
	
	public �velseIGruppe(int �g_id, int �_id) {
		this.�velsesgruppe_id = �g_id;
		this.�velse_id = �_id;
	}

	@Override
	public void initialize(Connection conn) {
		// TODO Auto-generated method stub
		
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
					"insert into �velse_i_gruppe values (" + �velsesgruppe_id + ", " + �velse_id + ");"
					);
		} catch (Exception e) {
			System.out.println("db error during insertion of �velse_i_gruppe: " + e);
		}
		
	}
	
	
	
}
