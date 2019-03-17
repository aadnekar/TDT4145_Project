package application;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class QueriesCtrl extends DBConn {
	
	private ArrayList<TreningsøktInstance> treningsøkterResultat;
	private ArrayList<Resultatlogg> resultatlogg;
	public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Default Date for MySQL
	

	public QueriesCtrl() {
		connect();
	}
	
	public ArrayList<Resultatlogg> getResultatlogg(String øvelse, String interval_start, String interval_end) {
		resultatlogg = new ArrayList<Resultatlogg>();
		Date start = Date.valueOf(LocalDate.parse(interval_start, formatter));
		Date end = Date.valueOf(LocalDate.parse(interval_end, formatter));
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
						"select dato, personlig_form, prestasjon, antall_kilo, antall_sett " +
						"from Øvelse " +
						"inner join Øvelse_i_økt on Øvelse.øvelse_id = Øvelse_i_økt.øvelse_id " +
						"inner join Treningsøkt on Øvelse_i_økt.trening_id = Treningsøkt.trening_id " +
						"where Øvelse.navn = '" + øvelse + "' and Treningsøkt.dato >= '" + start + 
						"' and Treningsøkt.dato <= '" + end + "';"
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
	
	
	
	public ArrayList<TreningsøktInstance> getTreningsøkter(int antallØkter){
		treningsøkterResultat = new ArrayList<TreningsøktInstance>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
						"select dato, tidspunkt, varighet, personlig_form, prestasjon, tekst " +
						"from Treningsøkt left outer join Notat " +
						"on Notat.trening_id = Treningsøkt.trening_id " +
						"order by dato asc, tidspunkt asc;"
					);
			while(rs.next()) {
				TreningsøktInstance ins = new TreningsøktInstance();
				ins.setDato(rs.getDate("dato"));
				ins.setTidspunkt(rs.getTime("varighet"));
				ins.setVarighet(rs.getTime("varighet"));
				ins.setPersonlig_form(rs.getInt("personlig_form"));
				ins.setPrestasjon(rs.getInt("prestasjon"));
				ins.setTekst(rs.getString("tekst"));
				treningsøkterResultat.add(ins);
			}
			return treningsøkterResultat;
		} catch(Exception e) {
			System.out.println("db error during QuerriesCtrl select: " + e);
			return treningsøkterResultat;
		}
	}
	
	public String getTreningsøkterResultat() {
		String alt = "";
		for (int i=0; i<treningsøkterResultat.size(); i++) {
			alt += treningsøkterResultat.get(i).printær();
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
