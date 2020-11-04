package vehicle;

public final class Course {
	private String nom;
	private int km;
	
	Course(String n, int k){
		this.nom = n;
		this.km = Math.abs(k);
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getKm() {
		return km;
	}
	
	
	
}
