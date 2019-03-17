package entities;

import java.sql.Connection;
import java.sql.Statement;

public class ØvelseIGruppe extends ActiveDomainObject {

	private int øvelsesgruppe_id, øvelse_id;
	
	public ØvelseIGruppe(int øg_id, int ø_id) {
		this.øvelsesgruppe_id = øg_id;
		this.øvelse_id = ø_id;
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
					"insert into Øvelse_i_gruppe values (" + øvelsesgruppe_id + ", " + øvelse_id + ");"
					);
		} catch (Exception e) {
			System.out.println("db error during insertion of Øvelse_i_gruppe: " + e);
		}
		
	}
	
	
	
}
