package entityConstructors;

import java.sql.*;

import application.DBConn;
import entities.Øvelse;

public class LagØvelseCtrl extends DBConn {

	private Øvelse øvelse;
	
	public LagØvelseCtrl() {
		connect();
		try {
			conn.setAutoCommit(false);
		} catch(SQLException e) {
			System.out.println("db error during setAutoCommit of LagØvelseCtrl= " + e);
			return;
		}
	}
	
	public void lagØvelse(String navn, String beskrivelse, int antall_kilo, int antall_sett, int apparat_id) {
		øvelse = new Øvelse(navn, beskrivelse, antall_kilo, antall_sett, apparat_id);
	}
	
	public void lagØvelse(String navn, String beskrivelse, int antall_kilo, int antall_sett) {
		øvelse = new Øvelse(navn, beskrivelse, antall_kilo, antall_sett);
	}
	
	public void fullførØvelse() {
		øvelse.save(conn);
		try {
			conn.commit();
		} catch(SQLException e) {
			System.out.println("db error during save of Øvelse= " + e);
		}
	}
	
}
