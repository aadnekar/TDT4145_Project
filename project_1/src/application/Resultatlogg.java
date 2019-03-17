package application;

import java.sql.Date;
import java.time.LocalDate;

public class Resultatlogg {
	
	private LocalDate dato;
	private int personlog_form, prestasjon, antall_kilo, antall_sett;
	
	
	public Resultatlogg() {
		
	}
	
	public Resultatlogg(LocalDate dato, int pf, int pres, int ak, int as) {
		this.dato = dato;
		this.personlog_form = pf;
		this.prestasjon = pres;
		this.antall_kilo = ak;
		this.antall_sett = as;
	}
	
	public LocalDate getDato() {
		return dato;
	}
	
	public void setDato(LocalDate dato) {
		this.dato = dato;
	}

	public int getPersonlog_form() {
		return personlog_form;
	}

	public void setPersonlog_form(int personlog_form) {
		this.personlog_form = personlog_form;
	}

	public int getPrestasjon() {
		return prestasjon;
	}

	public void setPrestasjon(int prestasjon) {
		this.prestasjon = prestasjon;
	}

	public int getAntall_kilo() {
		return antall_kilo;
	}

	public void setAntall_kilo(int antall_kilo) {
		this.antall_kilo = antall_kilo;
	}

	public int getAntall_sett() {
		return antall_sett;
	}

	public void setAntall_sett(int antall_sett) {
		this.antall_sett = antall_sett;
	}
	
	public String toString() {
		String text = "";
		text += "Dato: " + this.getDato() + " | " + 
				"Personlig form: " + this.getPersonlog_form() + " | " +
				"Prestasjon: " + this.getPrestasjon() + " | " +
				"Antall Kilo: " + this.getAntall_kilo() + " | " +
				"Antall Sett: " + this.getAntall_sett() + "\n";
		return text;
	}
}
