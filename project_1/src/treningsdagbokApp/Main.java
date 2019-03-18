package treningsdagbokApp;

import entityConstructors.LagØvelseCtrl;
import entityConstructors.LagØvelseIGruppeCtrl;
import entityConstructors.LagØvelsesgruppeCtrl;

public class Main {
	
	public static void main(String[] args) {
//		LagTreningsøktCtrl lagTreningsøktCtrl = new LagTreningsøktCtrl();
//		lagTreningsøktCtrl.lagTreningsøkt("2019-01-02", 20 , 5, 3);
//		lagTreningsøktCtrl.fullførTreningsøkt();
//		System.out.println("Fullført opprettelse av treningsøkt");
		
//		LagApparatCtrl lagApparatCtrl = new LagApparatCtrl();
//		lagApparatCtrl.lagApparat("Knebøy");
//		lagApparatCtrl.fullførApparat();
//		System.out.println("Fullført opprettelse av apparat - Knebøy");
		
//		LagØvelseCtrl lagØvelseCtrl = new LagØvelseCtrl();
//		lagØvelseCtrl.lagØvelse("Catwalk", "Vri på hoftene og kjenn på grooven.", 0, 50);
//		lagØvelseCtrl.fullførØvelse();
//		System.out.println("Fullført opprettelse av Øvelse");
		
//		QueriesCtrl eiLitaQ = new QueriesCtrl();
		
//		eiLitaQ.getTreningsøkter(2);
//		System.out.println(eiLitaQ.getTreningsøkterResultat());
		
//		eiLitaQ.getResultatlogg("Knebøy med stang", "2019-01-01", "2019-01-01");
//		System.out.println(eiLitaQ.getResultatlogg());
		
		
//		LagØvelseIØktCtrl lagØvelseIØktCtrl = new LagØvelseIØktCtrl();
//		lagØvelseIØktCtrl.lagØvelseiØkt(4, 1);
//		lagØvelseIØktCtrl.fullførØvelseiØkt();
		
		// Lag noen beinøvelser og en beingruppe
		
//		LagØvelsesgruppeCtrl gruppeCtrl = new LagØvelsesgruppeCtrl();
//		gruppeCtrl.lagØvelsesgruppe("Bein");
//		gruppeCtrl.fullførØvelseiØkt();
//		
//		LagØvelseCtrl tåhev = new LagØvelseCtrl();
//		tåhev.lagØvelse("Tåhev", "Stå på kanten av en kasse og gjør tåhev", 0, 3);
//		tåhev.fullførØvelse();
//		LagØvelseCtrl utfall = new LagØvelseCtrl();
//		utfall.lagØvelse("Utfall", "Gå fremover med lange og dype steg", 20, 4);
//		utfall.fullførØvelse();
		
//		LagØvelseIGruppeCtrl knebøyBein = new LagØvelseIGruppeCtrl();
//		LagØvelseIGruppeCtrl knebøyStangBein = new LagØvelseIGruppeCtrl();
//		LagØvelseIGruppeCtrl tåhevBein = new LagØvelseIGruppeCtrl();
//		LagØvelseIGruppeCtrl utfallBein = new LagØvelseIGruppeCtrl();
//		knebøyBein.lagØvelseIGruppe(1, 4);
//		knebøyStangBein.lagØvelseIGruppe(1, 1);
//		tåhevBein.lagØvelseIGruppe(1, 9);
//		utfallBein.lagØvelseIGruppe(1, 10);
//		knebøyBein.fullførØvelseIGruppe();
//		knebøyStangBein.fullførØvelseIGruppe();
//		tåhevBein.fullførØvelseIGruppe();
//		utfallBein.fullførØvelseIGruppe();
		
		// Get all exercises in DB with exercisegroup = Bein
		QueriesCtrl beinØvelser = new QueriesCtrl();
		beinØvelser.getØvelserFraGruppe("Bein");
		System.out.println(beinØvelser.getØvelserFraGruppe());
		
	}

}
