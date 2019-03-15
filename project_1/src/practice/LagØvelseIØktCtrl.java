package practice;

import java.sql.*;

public class LagØvelseIØktCtrl extends DBConn {
	

    private ØvelseIØkt øvelseiøkt;
    
    public LagØvelseIØktCtrl(){
        connect();
        try{
            conn.setAutoCommit(false);
        }
        catch(SQLException e){
            System.out.println("db error during setAutoCommit of LagØvelseiØktCtrl= " + e);
            return;
        }
    }
    
    public void lagØvelseiØkt(int trening_id, int øvelse_id){
        øvelseiøkt = new ØvelseIØkt(trening_id, øvelse_id);
    }
    
    public void fullførØvelseiØkt(){
        øvelseiøkt.save(conn);
        try{
            conn.commit();
        }
        catch(SQLException e){
            System.out.println("db error during commit if LagØvelseiØktCtrl= " + e);
            return;
        }
    }

}
