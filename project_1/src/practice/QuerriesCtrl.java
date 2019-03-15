package practice;

import java.sql.*;
import java.util.ArrayList;

public class QuerriesCtrl extends DBConn {
	
	private ArrayList<Trenings�ktInstance> result;

	public QuerriesCtrl() {
		connect();
	}
	
	public ArrayList<Trenings�ktInstance> getTrenings�kter(int antall�kter){
		result = new ArrayList<Trenings�ktInstance>();
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
				result.add(ins);
			}
			return result;
		} catch(Exception e) {
			System.out.println("db error during QuerriesCtrl select: " + e);
			return result;
		} finally {
			System.out.println("Finished up the querry, yo!");
		}
	}
	
	public void getResult() {
		System.out.println("resultat size = " + result.size());
		for (int i=0; i<result.size(); i++) {
			System.out.println(result.get(i).print�r());
		}
	}
	
	public String print�r() {
		String alt = "";
		for (int i=0; i<result.size(); i++) {
			alt += result.get(i).print�r();
		}
		return alt;
	}
}
