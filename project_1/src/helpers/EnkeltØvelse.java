package helpers;

public class Enkelt�velse {

	private String navn;
	
	public Enkelt�velse() {
		
	}
	
	public Enkelt�velse(String navn) {
		this.navn = navn;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}
	
	
	public String toString() {
		String text = "";
		text += "Navn: " + this.getNavn() + " | \n";
		return text;
	}
	
}
