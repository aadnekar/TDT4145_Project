package entityConstructors;

import java.sql.*;

import entities.�velseIGruppe;
import treningsdagbokApp.DBConn;

public class Lag�velseIGruppeCtrl extends DBConn {

	private �velseIGruppe �velseIGruppe;
	
	public Lag�velseIGruppeCtrl() {
		connect();
		try {
			conn.setAutoCommit(false);
		} catch(SQLException e) {
			System.out.println("db error during setAutoCommit in Lag�velseIGruppeCtrl: " + e);
			return;
		}
	}
	
	public void lag�velseIGruppe(int �velsesgruppe_id, int �velse_id) {
		�velseIGruppe = new �velseIGruppe(�velsesgruppe_id, �velse_id);
	}
	
	public void fullf�r�velseIGruppe() {
        �velseIGruppe.save(conn);
        try{
            conn.commit();
        }
        catch(SQLException e){
            System.out.println("db error during commit of Lag�velseIGruppeCtrl= " + e);
            return;
        }
	}
	
}
