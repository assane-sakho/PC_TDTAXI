package vehicle;
import java.util.ArrayList;
import java.util.List;


public abstract class Vehicule{
	
	private static int kmTotal;
	private static ArrayList<Integer> listVehicule = new ArrayList<Integer>();
	
	private int idVehicule;
	private int kmVehicule;
	
	Vehicule(int id){
		this.idVehicule = id;
		this.kmVehicule = 0;
		listVehicule.add(id);
	}
	
	public int getKmVehicule() {
		return kmVehicule;
	}
	public void addKmVehicule(int kmVehicule) {
		this.kmVehicule += kmVehicule;
	}
	
	public int getIdVehicule() {
		return idVehicule;
	}
	
	public static synchronized int getKmTotal() {
		return kmTotal;
	}
	public static synchronized List<Integer> getListVehicule() {
		return listVehicule;
	}

	public final synchronized void updateTotalMileage(int increment){
		kmTotal += increment;
	}
	
	public final synchronized void addId(int id){
		listVehicule.add(id);
	}

}
