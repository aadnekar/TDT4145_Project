package application;

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
		
		QueriesCtrl eiLitaQ = new QueriesCtrl();
		
//		eiLitaQ.getTrenings�kter(2);
//		System.out.println(eiLitaQ.getTrenings�kterResultat());
		
		eiLitaQ.getResultatlogg("Kneb�y med stang", "2019-01-01", "2019-01-01");
		System.out.println(eiLitaQ.getResultatlogg());
		
		
//		Lag�velseI�ktCtrl lag�velseI�ktCtrl = new Lag�velseI�ktCtrl();
//		lag�velseI�ktCtrl.lag�velsei�kt(4, 1);
//		lag�velseI�ktCtrl.fullf�r�velsei�kt();
		
		
	}

}
