package entityConstructors;

import java.sql.*;

import entities.ØvelseIGruppe;
import treningsdagbokApp.DBConn;

public class LagØvelseIGruppeCtrl extends DBConn {

	private ØvelseIGruppe øvelseIGruppe;
	
	public LagØvelseIGruppeCtrl() {
		connect();
		try {
			conn.setAutoCommit(false);
		} catch(SQLException e) {
			System.out.println("db error during setAutoCommit in LagØvelseIGruppeCtrl: " + e);
			return;
		}
	}
	
	public void lagØvelseIGruppe(int øvelsesgruppe_id, int øvelse_id) {
		øvelseIGruppe = new ØvelseIGruppe(øvelsesgruppe_id, øvelse_id);
	}
	
	public void fullførØvelseIGruppe() {
        øvelseIGruppe.save(conn);
        try{
            conn.commit();
        }
        catch(SQLException e){
            System.out.println("db error during commit of LagØvelseIGruppeCtrl= " + e);
            return;
        }
	}
	
}
