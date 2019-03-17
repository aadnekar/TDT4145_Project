package entityConstructors;

import application.DBConn;
import entities.Øvelsesgruppe;

import java.sql.*;

public class LagØvelsesgruppeCtrl extends DBConn {
	
	private Øvelsesgruppe øvelsesgruppe;
	
	public LagØvelsesgruppeCtrl() {
		connect();
		try {
			conn.setAutoCommit(false);
		} catch(SQLException e) {
			System.out.println("db error during setAutoCommit of LagØvelsesgruppeCtrl= " + e);
            return;
		}
	}
	
	public void lagØvelsesgruppe(String navn) {
		øvelsesgruppe = new Øvelsesgruppe(navn);
	}
	
	public void fullførØvelseiØkt(){
        øvelsesgruppe.save(conn);
        try{
            conn.commit();
        }
        catch(SQLException e){
            System.out.println("db error during commit of LagØvelsesgruppeCtrl= " + e);
            return;
        }
    }
	
}
