package entityConstructors;

import java.sql.*;

import application.DBConn;
import entities.�velse;

public class Lag�velseCtrl extends DBConn {

	private �velse �velse;
	
	public Lag�velseCtrl() {
		connect();
		try {
			conn.setAutoCommit(false);
		} catch(SQLException e) {
			System.out.println("db error during setAutoCommit of Lag�velseCtrl= " + e);
			return;
		}
	}
	
	public void lag�velse(String navn, String beskrivelse, int antall_kilo, int antall_sett, int apparat_id) {
		�velse = new �velse(navn, beskrivelse, antall_kilo, antall_sett, apparat_id);
	}
	
	public void lag�velse(String navn, String beskrivelse, int antall_kilo, int antall_sett) {
		�velse = new �velse(navn, beskrivelse, antall_kilo, antall_sett);
	}
	
	public void fullf�r�velse() {
		�velse.save(conn);
		try {
			conn.commit();
		} catch(SQLException e) {
			System.out.println("db error during save of �velse= " + e);
		}
	}
	
}
