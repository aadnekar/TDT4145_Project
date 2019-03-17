package application;

import java.sql.*;

public class ØvelseIØkt extends ActiveDomainObject {
    
	private int trening_id, øvelse_id;
    
	public ØvelseIØkt(int trening_id, int øvelse_id) {
		this.trening_id = trening_id;
		this.øvelse_id = øvelse_id;
	}
	
	@Override
	public void initialize(Connection conn) {
	try {
	    Statement stmt = conn.createStatement();
	    ResultSet rs = stmt.executeQuery(
	            "select trening_id, øvelse_id " +
	            "from Øvelse_i_økt where trening_id=" + trening_id +
	            " and øvelse_id=" + øvelse_id);
	    while (rs.next()) {
	        trening_id = rs.getInt("trening_id");
	        øvelse_id = rs.getInt("øvelse_id");
	    }
	} catch (Exception e) {
	    System.out.println("db error during select of ØvelseiØkt= " + e);
	    return;
		}
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
		            "insert into Øvelse_i_økt " +
		            "values ('" + trening_id + "', '" + øvelse_id + "');");
		} catch (Exception e) {
		    System.out.println("db error during insert of Øvelse_i_økt" + e);
		    return;
		}
	}
}
