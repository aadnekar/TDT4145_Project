package practice;

import java.sql.*;

public class LagTreningsøktCtrl extends DBConn {
	
	private Treningsøkt treningsøkt;
	private Notat notat;
	
	public LagTreningsøktCtrl() {
		connect();
		
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			System.out.println("db error during setAutoCommit of LagTreningsøktCtrl=" + e);
			return;
		}
	}
	
	public void lagTreningsøkt(String dato, int varighet, int pf, int pres) {
		treningsøkt = new Treningsøkt(dato, varighet, pf, pres);
	}
	
	public void lagTreningsøkt(String dato, int pf, int pres) {
		treningsøkt = new Treningsøkt(dato, pf, pres);
	}
	
	public void lagTreningsøkt(int pf, int pres) {
		treningsøkt = new Treningsøkt(pf, pres);
	}
	
//	public void lagTreningsøkt(int pf, int pres, String tekst) {
//		treningsøkt = new Treningsøkt(pf, pres);
//		notat = new Notat(tekst, trening_id)
//	}
	
	public void fullførTreningsøkt() {
		treningsøkt.save(conn);
		try {
			conn.commit();
		} catch(SQLException e) {
			System.out.println("db error during commit of LagTreningsøktCtrl=" + e);
			return;
		}
	}
	
	
	public int getTrening_id() {
		return this.treningsøkt.getTrenings_id(conn);
	}
	

}
