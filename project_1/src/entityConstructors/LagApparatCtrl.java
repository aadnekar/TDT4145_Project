package entityConstructors;

import java.sql.*;

import entities.Apparat;
import treningsdagbokApp.DBConn;

public class LagApparatCtrl extends DBConn {

	private Apparat apparat;
	
	public LagApparatCtrl() {
		connect();
		try {
			conn.setAutoCommit(false);
		} catch(SQLException e) {
			System.out.println("db error during setAutoCommit of LagApparatCtrl= " + e);
			return;
		}
	}
	
	public void lagApparat(String navn, String beskrivelse) {
		apparat = new Apparat(navn, beskrivelse);
	}
	
	public void lagApparat(String navn) {
		apparat = new Apparat(navn);
	}
	
	public void fullførApparat() {
		apparat.save(conn);
		try {
			conn.commit();
		} catch(SQLException e) {
			System.out.println("db error during commit of LagApparatCtrl= " + e);
			return;
		}
	}
	
	
}
