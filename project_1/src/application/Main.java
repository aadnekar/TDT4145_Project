package application;

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
		
		QueriesCtrl eiLitaQ = new QueriesCtrl();
		
//		eiLitaQ.getTreningsøkter(2);
//		System.out.println(eiLitaQ.getTreningsøkterResultat());
		
		eiLitaQ.getResultatlogg("Knebøy med stang", "2019-01-01", "2019-01-01");
		System.out.println(eiLitaQ.getResultatlogg());
		
		
//		LagØvelseIØktCtrl lagØvelseIØktCtrl = new LagØvelseIØktCtrl();
//		lagØvelseIØktCtrl.lagØvelseiØkt(4, 1);
//		lagØvelseIØktCtrl.fullførØvelseiØkt();
		
		
	}

}
