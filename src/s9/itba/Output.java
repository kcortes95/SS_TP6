package s9.itba;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;



public class Output {
	private static Output instance = null;
	
	public static Output getInstace(){
		if(instance == null)
			instance = new Output();
		return instance;
	}

	public void write(Set<Particle> particles, double time, int runNum){
		String fileName = "output" + runNum + ".xyz";
		if(time == 0){
			try{
				PrintWriter pw = new PrintWriter(fileName);
				pw.close();
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)))) {
			out.write((particles.size()+6) + "\n");
			//comment line
			//System.out.println("Frame : " + count++);
			out.write("Comment line\n");
			out.write(100000 + "\t" + 0 + "\t" + 20 + "\t" + 0.5 + "\t0\t0\t0" + "\n");
			out.write(100001 + "\t" + 0 + "\t" + 0 + "\t" + 0.5 + "\t0\t0\t0" + "\n");
			out.write(100002 + "\t" + 20 + "\t" + 0 + "\t" + 0.5 + "\t0\t0\t0" + "\n");
			out.write(100004+ "\t" + 20 + "\t" + 20 + "\t" + 0.5 + "\t0\t0\t0" + "\n");
			out.write(100005+ "\t" + 9.15 + "\t" + 0 + "\t" + 0.25 + "\t0\t255\t0" + "\n");
			out.write(100006 + "\t" + 10.85 + "\t" + 0 + "\t" + 0.25 + "\t0\t255\t0" + "\n");
			for(Particle p: particles)
				out.write(p.ID + "\t" + p.rx + "\t" + p.ry + "\t" + p.r + "\t" + 255 + "\t" + 255 + "\t" + 255  + "\n");
			//out.write(time + "\t " + p.rx + "\n");
			out.close();
		}catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
	public void writeEnergy(Set<Particle> particles, double time){
		if(time == 0){
			try{
				PrintWriter pw = new PrintWriter("energy.txt");
				pw.close();
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("energy.txt", true)))) {
			out.write(time + "\t" +(getK(particles)) + "\n");
			out.close();
		}catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
	public void writeAmount(Set<Particle> particles, double time, int runNum){
		String fileName = "amount" + runNum + ".txt";
		if(time == 0){
			try{
				PrintWriter pw = new PrintWriter(fileName);
				pw.close();
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)))) {
			out.write(time + "\t" + particles.size() + "\n");
			out.close();
		}catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
	private double getK(Set<Particle> particles){
		double K = 0;
		for(Particle p: particles){
			K += 0.5*p.m*p.vx*p.vx*p.vy*p.vy;
		}
		return K;
	}
}
