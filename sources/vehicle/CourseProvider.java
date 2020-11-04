package vehicle;

public class CourseProvider extends Thread {
	
	private final int idProvider;
	private final int nbcourse;

	private final Plateforme p;
	
	CourseProvider(int id, int nb, Plateforme p){
		this.idProvider = id;
		this.nbcourse = Math.abs(nb);
		this.p = p;
	}
	
	public void run(){
		for(int i=0;i<nbcourse;++i){
			p.addCourse(new Course("course_"+i, (i+1)*3 ));
		}
		System.out.println("Fin du thread t" + this.idProvider);
	}
	
	
}