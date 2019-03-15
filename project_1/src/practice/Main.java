package practice;

public class Main {
	
	public static void main(String[] args) {
//		LagTreningsøktCtrl lagTreningsøktCtrl = new LagTreningsøktCtrl();
//		lagTreningsøktCtrl.lagTreningsøkt(10, 10);
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
		
		QuerriesCtrl eiLitaQ = new QuerriesCtrl();
		eiLitaQ.getTreningsøkter(2);
		System.out.println(eiLitaQ.printær());
		
		
		
	}

}
