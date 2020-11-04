package vehicle;

public class Taxi extends Vehicule implements Runnable {

    private final Plateforme p;
    private final long dureeCourse;

    Taxi(int id, Plateforme p, long d) {
        super(id);
        this.p = p;
        dureeCourse = Math.abs(d);
    }

    public  void run() {
        while (!Thread.interrupted()) {
            Course c = p.lireCourse();
            if(c == null)
                break;
            System.out.println(this.getIdVehicule());
            System.out.println("kilometrage de course " + c.getKm() + " " + c.getNom() + " " + this.getIdVehicule());
            System.out.println("taxi no" + this.getIdVehicule() + " effectue course " + c.getNom());

            try {
                Thread.sleep(dureeCourse);

            } catch (InterruptedException e) {
                System.out.println("/!\\    --------" + e.getMessage());
            }
            this.addKmVehicule(c.getKm());
            this.updateTotalMileage(c.getKm());
        }
        System.out.println("---------------Affichage du kilometrage" + this.getKmVehicule());

    }

}
