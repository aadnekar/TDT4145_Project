package model;

import java.sql.*;
import java.time.LocalDate;
import javafx.beans.property.*;

public class TreningsøktModel {

	private ObjectProperty<LocalDate> dato;
	private IntegerProperty trening_id, varighet, personlig_form, prestasjon;
	private StringProperty tekst;


	// Default constructor.
	public TreningsøktModel() {
		this(null,null,null,null,null);
	}

	public TreningsøktModel(ObjectProperty<LocalDate> dato, IntegerProperty varighet, IntegerProperty pf, IntegerProperty pres, StringProperty tekst) {
		this.trening_id = trening_id;
		this.dato = dato;
		this.varighet = varighet;
		this.personlig_form = pf;
		this.prestasjon = pres;
		this.tekst = tekst;
	}

	public int getTrening_id() {
		return trening_id.get();
	}

	public IntegerProperty trening_idProperty() {
		return trening_id;
	}

	public void setTrening_id(int trening_id) {
		this.trening_id.set(trening_id);;
	}

	public LocalDate getDato() {
		return dato.get();
	}

	public void setDato(LocalDate dato) {
		this.dato.set(dato);
	}

	public ObjectProperty<LocalDate> datoProperty() {
		return dato;
	}

	public int getVarighet() {
		return varighet.get();
	}

	public void setVarighet(int varighet) {
		this.varighet.set(varighet);
	}

	public IntegerProperty varighetProperty() {
		return varighet;
	}

	public int getPersonlig_form() {
		return personlig_form.get();
	}

	public void setPersonlig_form(int personlig_form) {
		this.personlig_form.set(personlig_form);
	}

	public IntegerProperty personlig_formProperty() {
		return personlig_form;
	}

	public int getPrestasjon() {
		return prestasjon.get();
	}

	public void setPrestasjon(int prestasjon) {
		this.prestasjon.set(prestasjon);
	}

	public IntegerProperty prestasjonProperty() {
		return prestasjon;
	}

	public String getTekst() {
		return tekst.get();
	}

	public void setTekst(String tekst) {
		this.tekst.set(tekst);;
	}

	public StringProperty tekstProperty() {
		return tekst;
	}

	public String toString() {
		String text = "";
		text += "Dato: " + this.getDato() +
				", Varighet: " + this.getVarighet() +
				", PF: " + this.getPersonlig_form() +
				", prestasjon: " + this.getPrestasjon() +
				", tekst: " + this.getTekst() + "\n";
		return text;
	}

}
