package practice;

import java.sql.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Treningsøkt extends ActiveDomainObject {

    private int trening_id, varighet;
    private Date dato;
    private int personlig_form, prestasjon;
    
    public static String NO_DATE = "";
    public static int NO_DURATION = 0;
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Default Date for MySQL
    
    // trening_id blir satt automagisk
    public Treningsøkt(int pf, int pres) {
    	this(NO_DATE, NO_DURATION, pf, pres);
    }
    
    public Treningsøkt(String dato, int pf, int pres) {
    	this(dato, NO_DURATION, pf, pres);
    }
    
    public Treningsøkt(String dato, int varighet, int pf, int pres) {
    	this.dato = Date.valueOf(LocalDate.parse(dato, formatter));
    	this.varighet = varighet;
    	this.personlig_form = pf;
    	this.prestasjon = pres;
    }
    
    public void setTreningsøkt(int trening_id) {
        this.trening_id = trening_id;
    }
   
    
    public int getTrenings_id (Connection conn) {
        try {
        	Statement stmt = conn.createStatement();
        	ResultSet rs = stmt.executeQuery("select trening_id from Treningsøkt where trening_id=" + trening_id);
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
            								" from Treningsøkt where trening_id=" + trening_id);
            while (rs.next()) {
                dato =  rs.getDate("dato");
                varighet = rs.getInt("varighet");
                personlig_form = rs.getInt("personlig_form");
                prestasjon = rs.getInt("prestasjon");
            }

        } catch (Exception e) {
            System.out.println("db error during select of Treningsøkt= "+e);
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
            stmt.executeUpdate("insert into Treningsøkt (dato, varighet, personlig_form, prestasjon)" + 
            					"values ('" + dato + "', " + varighet + ", " + personlig_form + ", " + prestasjon + ");");
        } catch (Exception e) {
            System.out.println("db error during update of Treningsøkt= " + e);
            return;
        }
    }
	
}