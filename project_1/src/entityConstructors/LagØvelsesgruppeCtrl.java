package entityConstructors;

import application.DBConn;
import entities.�velsesgruppe;

import java.sql.*;

public class Lag�velsesgruppeCtrl extends DBConn {
	
	private �velsesgruppe �velsesgruppe;
	
	public Lag�velsesgruppeCtrl() {
		connect();
		try {
			conn.setAutoCommit(false);
		} catch(SQLException e) {
			System.out.println("db error during setAutoCommit of Lag�velsesgruppeCtrl= " + e);
            return;
		}
	}
	
	public void lag�velsesgruppe(String navn) {
		�velsesgruppe = new �velsesgruppe(navn);
	}
	
	public void fullf�r�velsei�kt(){
        �velsesgruppe.save(conn);
        try{
            conn.commit();
        }
        catch(SQLException e){
            System.out.println("db error during commit of Lag�velsesgruppeCtrl= " + e);
            return;
        }
    }
	
}
