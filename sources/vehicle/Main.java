package vehicle;

public class Main {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		
		CourseProvider f1, f2;
		Taxi t1, t2, t3;
		Thread taxi1,taxi2,taxi3;
		Plateforme p;
		
		p = new Plateforme();
		
		// les threads fournisseurs
		f1 = new CourseProvider(1,5,p);
		f2 = new CourseProvider(2,4,p);

		// Les taxis
		t1 = new Taxi(1,p,150);
		t2 = new Taxi(2,p,175);
		t3 = new Taxi(3,p,240);
		
		// les threads taxis
		taxi1 = new Thread(t1);
		taxi2 = new Thread(t2);
		taxi3 = new Thread(t3);
		
		taxi1.start();
		f1.start();
		taxi2.start();
		taxi3.start();
		f2.start();

		Thread.sleep(50);
		taxi1.interrupt();
		taxi2.interrupt();
		taxi3.interrupt();

		taxi1.join();
		taxi2.join();
		taxi3.join();

		System.out.println("kilometrage total de l'ensemble de la flotte =" + Taxi.getKmTotal());
		System.out.println("kilometrage taxi 1 " + t1.getKmVehicule());
		System.out.println("kilometrage taxi 2 " + t2.getKmVehicule());
		System.out.println("kilometrage taxi 3 " + t3.getKmVehicule());
		System.out.println("kilometrage total de l'ensemble de la flotte =" + Taxi.getKmTotal());
	}

}
