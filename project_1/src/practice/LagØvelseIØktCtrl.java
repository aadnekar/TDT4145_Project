package practice;

import java.sql.*;

public class Lag�velseI�ktCtrl extends DBConn {
	

    private �velseI�kt �velsei�kt;
    
    public Lag�velseI�ktCtrl(){
        connect();
        try{
            conn.setAutoCommit(false);
        }
        catch(SQLException e){
            System.out.println("db error during setAutoCommit of Lag�velsei�ktCtrl= " + e);
            return;
        }
    }
    
    public void lag�velsei�kt(int trening_id, int �velse_id){
        �velsei�kt = new �velseI�kt(trening_id, �velse_id);
    }
    
    public void fullf�r�velsei�kt(){
        �velsei�kt.save(conn);
        try{
            conn.commit();
        }
        catch(SQLException e){
            System.out.println("db error during commit if Lag�velsei�ktCtrl= " + e);
            return;
        }
    }

}
