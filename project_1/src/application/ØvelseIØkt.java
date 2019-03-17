package application;

import java.sql.*;

public class �velseI�kt extends ActiveDomainObject {
    
	private int trening_id, �velse_id;
    
	public �velseI�kt(int trening_id, int �velse_id) {
		this.trening_id = trening_id;
		this.�velse_id = �velse_id;
	}
	
	@Override
	public void initialize(Connection conn) {
	try {
	    Statement stmt = conn.createStatement();
	    ResultSet rs = stmt.executeQuery(
	            "select trening_id, �velse_id " +
	            "from �velse_i_�kt where trening_id=" + trening_id +
	            " and �velse_id=" + �velse_id);
	    while (rs.next()) {
	        trening_id = rs.getInt("trening_id");
	        �velse_id = rs.getInt("�velse_id");
	    }
	} catch (Exception e) {
	    System.out.println("db error during select of �velsei�kt= " + e);
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
		            "insert into �velse_i_�kt " +
		            "values ('" + trening_id + "', '" + �velse_id + "');");
		} catch (Exception e) {
		    System.out.println("db error during insert of �velse_i_�kt" + e);
		    return;
		}
	}
}
