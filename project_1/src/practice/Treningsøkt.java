package practice;

import java.sql.*;

public class Trenings�kt extends ActiveDomainObject {

    private int trening_id;
    private Date dato;
    private Time tidspunkt, varighet;
    private int personlig_form, prestasjon;
    
    public static Date NO_DATE = null;
    public static Time NO_TIME = null;
    
    // trening_id blir satt automagisk
    public Trenings�kt(int pf, int pres) {
    	this.personlig_form = pf;
    	this.prestasjon = pres;
    }
    
    public void setTrenings�kt(int trening_id) {
        this.trening_id = trening_id;
    }
    
    
    public int getTrenings_id (Connection conn) {
        try {
        	Statement stmt = conn.createStatement();
        	ResultSet rs = stmt.executeQuery("select trening_id from Trenings�kt where trening_id=" + trening_id);
        	return rs.getInt("trening_id");
        } catch (Exception e) {
        	System.out.println("db error during select trening_id= " + e);
        	return -1;
        }
    }
    
    @Override
    public void initialize (Connection conn) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select trening_id, dato, tidspunkt, varighet, personlig_form, varighet" +
            								" from Trenings�kt where trening_id=" + trening_id);
            while (rs.next()) {
                dato =  rs.getDate("dato");
                tidspunkt = rs.getTime("tidspunkt");
                varighet = rs.getTime("varighet");
                personlig_form = rs.getInt("personlig_form");
                prestasjon = rs.getInt("prestasjon");
            }

        } catch (Exception e) {
            System.out.println("db error during select of Trenings�kt= "+e);
            return;
        }

    }
    
    @Override
    public void refresh (Connection conn) {
        initialize (conn);
    }
    
    @Override
    public void save(Connection conn) {
        try {
            Statement stmt = conn.createStatement(); 
            stmt.executeUpdate("insert into Trenings�kt (personlig_form, prestasjon)" + 
            					"values (" + personlig_form + ", " + prestasjon + ");");
        } catch (Exception e) {
            System.out.println("db error during update of Trenings�kt= " + e);
            return;
        }
    }
	
}