package helpers;

public class EnkeltØvelse {

	private String navn;
	
	public EnkeltØvelse() {
		
	}
	
	public EnkeltØvelse(String navn) {
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
