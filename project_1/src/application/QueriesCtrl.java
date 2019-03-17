package application;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class QueriesCtrl extends DBConn {
	
	private ArrayList<Trenings�ktInstance> trenings�kterResultat;
	private ArrayList<Resultatlogg> resultatlogg;
	public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Default Date for MySQL
	

	public QueriesCtrl() {
		connect();
	}
	
	public ArrayList<Resultatlogg> getResultatlogg(String �velse, String interval_start, String interval_end) {
		resultatlogg = new ArrayList<Resultatlogg>();
		Date start = Date.valueOf(LocalDate.parse(interval_start, formatter));
		Date end = Date.valueOf(LocalDate.parse(interval_end, formatter));
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
						"select dato, personlig_form, prestasjon, antall_kilo, antall_sett " +
						"from �velse " +
						"inner join �velse_i_�kt on �velse.�velse_id = �velse_i_�kt.�velse_id " +
						"inner join Trenings�kt on �velse_i_�kt.trening_id = Trenings�kt.trening_id " +
						"where �velse.navn = '" + �velse + "' and Trenings�kt.dato >= '" + start + 
						"' and Trenings�kt.dato <= '" + end + "';"
					);
			while (rs.next()) {
				Resultatlogg rslogg = new Resultatlogg();
				// A bit messy and I should definitely look for an alternative method.
				rslogg.setDato(rs.getDate("dato").toLocalDate());
				rslogg.setPersonlog_form(rs.getInt("personlig_form"));
				rslogg.setPrestasjon(rs.getInt("prestasjon"));
				rslogg.setAntall_kilo(rs.getInt("antall_kilo"));
				rslogg.setAntall_sett(rs.getInt("antall_sett"));
				resultatlogg.add(rslogg);
			}
		} catch(Exception e) {
			System.out.println("db error during QueriesCtrl of resultatlogg: " + e);
		}
		return resultatlogg;
	}
	
	
	
	public ArrayList<Trenings�ktInstance> getTrenings�kter(int antall�kter){
		trenings�kterResultat = new ArrayList<Trenings�ktInstance>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
						"select dato, tidspunkt, varighet, personlig_form, prestasjon, tekst " +
						"from Trenings�kt left outer join Notat " +
						"on Notat.trening_id = Trenings�kt.trening_id " +
						"order by dato asc, tidspunkt asc;"
					);
			while(rs.next()) {
				Trenings�ktInstance ins = new Trenings�ktInstance();
				ins.setDato(rs.getDate("dato"));
				ins.setTidspunkt(rs.getTime("varighet"));
				ins.setVarighet(rs.getTime("varighet"));
				ins.setPersonlig_form(rs.getInt("personlig_form"));
				ins.setPrestasjon(rs.getInt("prestasjon"));
				ins.setTekst(rs.getString("tekst"));
				trenings�kterResultat.add(ins);
			}
			return trenings�kterResultat;
		} catch(Exception e) {
			System.out.println("db error during QuerriesCtrl select: " + e);
			return trenings�kterResultat;
		}
	}
	
	public String getTrenings�kterResultat() {
		String alt = "";
		for (int i=0; i<trenings�kterResultat.size(); i++) {
			alt += trenings�kterResultat.get(i).print�r();
		}
		return alt;
	}
	
	public String getResultatlogg() {
		String text = "";
		for (int i=0; i<resultatlogg.size(); i++) {
			text += resultatlogg.get(i).toString();
		}
		return text;
	}
	
}
