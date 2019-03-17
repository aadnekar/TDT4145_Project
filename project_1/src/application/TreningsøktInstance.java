package application;

import java.sql.*;

public class TreningsøktInstance {
	
	private Date dato;
	private Time tidspunkt, varighet;
	private int personlig_form, prestasjon;
	private String tekst;
	
	public TreningsøktInstance() {
		
	}
	
	public TreningsøktInstance(Date dato, Time tidsP, Time varighet, int pf, int pres, String tekst) {
		this.dato = dato;
		this.tidspunkt = tidsP;
		this.varighet = varighet;
		this.personlig_form = pf;
		this.prestasjon = pres;
		this.tekst = tekst;
	}

	public Date getDato() {
		return dato;
	}

	public void setDato(Date dato) {
		this.dato = dato;
	}

	public Time getTidspunkt() {
		return tidspunkt;
	}

	public void setTidspunkt(Time tidspunkt) {
		this.tidspunkt = tidspunkt;
	}

	public Time getVarighet() {
		return varighet;
	}

	public void setVarighet(Time varighet) {
		this.varighet = varighet;
	}

	public int getPersonlig_form() {
		return personlig_form;
	}

	public void setPersonlig_form(int personlig_form) {
		this.personlig_form = personlig_form;
	}

	public int getPrestasjon() {
		return prestasjon;
	}

	public void setPrestasjon(int prestasjon) {
		this.prestasjon = prestasjon;
	}

	public String getTekst() {
		return tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}
	
	public String printær() {
		String alt = "";
		alt += "Dato: " + this.getDato() +
				", Tid: " + this.getTidspunkt() +
				", Varighet: " + this.getVarighet() +
				", PF: " + this.getPersonlig_form() +
				", prestasjon: " + this.getPrestasjon() +
				", tekst: " + this.getTekst() + "\n";
		return alt;
	}
	
}
