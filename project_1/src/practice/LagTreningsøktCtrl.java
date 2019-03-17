package practice;

import java.sql.*;

public class LagTrenings�ktCtrl extends DBConn {
	
	private Trenings�kt trenings�kt;
	private Notat notat;
	
	public LagTrenings�ktCtrl() {
		connect();
		
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			System.out.println("db error during setAutoCommit of LagTrenings�ktCtrl=" + e);
			return;
		}
	}
	
	public void lagTrenings�kt(String dato, int varighet, int pf, int pres) {
		trenings�kt = new Trenings�kt(dato, varighet, pf, pres);
	}
	
	public void lagTrenings�kt(String dato, int pf, int pres) {
		trenings�kt = new Trenings�kt(dato, pf, pres);
	}
	
	public void lagTrenings�kt(int pf, int pres) {
		trenings�kt = new Trenings�kt(pf, pres);
	}
	
//	public void lagTrenings�kt(int pf, int pres, String tekst) {
//		trenings�kt = new Trenings�kt(pf, pres);
//		notat = new Notat(tekst, trening_id)
//	}
	
	public void fullf�rTrenings�kt() {
		trenings�kt.save(conn);
		try {
			conn.commit();
		} catch(SQLException e) {
			System.out.println("db error during commit of LagTrenings�ktCtrl=" + e);
			return;
		}
	}
	
	
	public int getTrening_id() {
		return this.trenings�kt.getTrenings_id(conn);
	}
	

}
