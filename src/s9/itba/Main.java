package s9.itba;

public class Main {

	public static void main(String[] args) {
		double dt = 0.000125;
		double dt2 = 0.1;
		for(int i=0; i<5; i++){
			System.out.println("Run number: " + (i+1));
			Storage s = new Storage(20, 20, 1.2);
			s.generateRandomParticle(100);
			Simulation sim = new Simulation(s,i+1);
			sim.run(dt,dt2);
		}
	}
}
