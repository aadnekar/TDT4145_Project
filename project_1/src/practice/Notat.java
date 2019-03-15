package practice;

import java.sql.*;

public class Notat extends ActiveDomainObject {
	
	private int notat_id, trening_id;
	private String tekst;
	
	
	public Notat(String tekst, int tid) {
		this.tekst = tekst;
		this.trening_id = tid;
	}


	@Override
	public void initialize(Connection conn) {
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
					"select tekst, trening_id" +
					"from Notat where notat_id=" + notat_id + ");"					
					);
		} catch(Exception e) {
			System.out.println("db error during select of Notat= " + e);
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
					"insert into Notat (tekst, trening_id)" +
					"values (" + tekst + ", " + trening_id + ");"
					);
		} catch(Exception e) {
			System.out.println("db error during insert of Notat= " + e);
			return;
		}
	}
	
	
	

}
