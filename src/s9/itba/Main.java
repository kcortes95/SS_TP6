package s9.itba;

public class Main {

	public static void main(String[] args) {
		double dt = 0.05*Math.sqrt(0.01/Math.pow(10,5));
		double dt2 = 0.01;

		Storage s = new Storage(20, 20, 1.2);
		s.generateRandomParticle(50);
		Simulation sim = new Simulation(s);
		sim.run(40,dt,dt2);
	}
}
