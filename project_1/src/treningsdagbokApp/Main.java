package treningsdagbokApp;

import entityConstructors.Lag�velseCtrl;
import entityConstructors.Lag�velseIGruppeCtrl;
import entityConstructors.Lag�velsesgruppeCtrl;

public class Main {
	
	public static void main(String[] args) {
//		LagTrenings�ktCtrl lagTrenings�ktCtrl = new LagTrenings�ktCtrl();
//		lagTrenings�ktCtrl.lagTrenings�kt("2019-01-02", 20 , 5, 3);
//		lagTrenings�ktCtrl.fullf�rTrenings�kt();
//		System.out.println("Fullf�rt opprettelse av trenings�kt");
		
//		LagApparatCtrl lagApparatCtrl = new LagApparatCtrl();
//		lagApparatCtrl.lagApparat("Kneb�y");
//		lagApparatCtrl.fullf�rApparat();
//		System.out.println("Fullf�rt opprettelse av apparat - Kneb�y");
		
//		Lag�velseCtrl lag�velseCtrl = new Lag�velseCtrl();
//		lag�velseCtrl.lag�velse("Catwalk", "Vri p� hoftene og kjenn p� grooven.", 0, 50);
//		lag�velseCtrl.fullf�r�velse();
//		System.out.println("Fullf�rt opprettelse av �velse");
		
//		QueriesCtrl eiLitaQ = new QueriesCtrl();
		
//		eiLitaQ.getTrenings�kter(2);
//		System.out.println(eiLitaQ.getTrenings�kterResultat());
		
//		eiLitaQ.getResultatlogg("Kneb�y med stang", "2019-01-01", "2019-01-01");
//		System.out.println(eiLitaQ.getResultatlogg());
		
		
//		Lag�velseI�ktCtrl lag�velseI�ktCtrl = new Lag�velseI�ktCtrl();
//		lag�velseI�ktCtrl.lag�velsei�kt(4, 1);
//		lag�velseI�ktCtrl.fullf�r�velsei�kt();
		
		// Lag noen bein�velser og en beingruppe
		
//		Lag�velsesgruppeCtrl gruppeCtrl = new Lag�velsesgruppeCtrl();
//		gruppeCtrl.lag�velsesgruppe("Bein");
//		gruppeCtrl.fullf�r�velsei�kt();
//		
//		Lag�velseCtrl t�hev = new Lag�velseCtrl();
//		t�hev.lag�velse("T�hev", "St� p� kanten av en kasse og gj�r t�hev", 0, 3);
//		t�hev.fullf�r�velse();
//		Lag�velseCtrl utfall = new Lag�velseCtrl();
//		utfall.lag�velse("Utfall", "G� fremover med lange og dype steg", 20, 4);
//		utfall.fullf�r�velse();
		
//		Lag�velseIGruppeCtrl kneb�yBein = new Lag�velseIGruppeCtrl();
//		Lag�velseIGruppeCtrl kneb�yStangBein = new Lag�velseIGruppeCtrl();
//		Lag�velseIGruppeCtrl t�hevBein = new Lag�velseIGruppeCtrl();
//		Lag�velseIGruppeCtrl utfallBein = new Lag�velseIGruppeCtrl();
//		kneb�yBein.lag�velseIGruppe(1, 4);
//		kneb�yStangBein.lag�velseIGruppe(1, 1);
//		t�hevBein.lag�velseIGruppe(1, 9);
//		utfallBein.lag�velseIGruppe(1, 10);
//		kneb�yBein.fullf�r�velseIGruppe();
//		kneb�yStangBein.fullf�r�velseIGruppe();
//		t�hevBein.fullf�r�velseIGruppe();
//		utfallBein.fullf�r�velseIGruppe();
		
		// Get all exercises in DB with exercisegroup = Bein
		QueriesCtrl bein�velser = new QueriesCtrl();
		bein�velser.get�velserFraGruppe("Bein");
		System.out.println(bein�velser.get�velserFraGruppe());
		
	}

}
