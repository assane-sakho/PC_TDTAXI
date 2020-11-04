package vehicle;

import java.util.ArrayList;


public final class Plateforme {
    ArrayList<Course> listCourses;

    Plateforme() {
        listCourses = new ArrayList<Course>();
    }

    public synchronized ArrayList<Course> getListCourses() {
        return listCourses;
    }

    public synchronized Course lireCourse() {
        try {
            wait();
        } catch (InterruptedException e) {
        }
        if (listCourses.size() == 0) return null;
        Course c;
        c = listCourses.get(0);
        listCourses.remove(0);
        return c;
    }

    public synchronized void addCourse(Course c) {
        listCourses.add(c);
        notify();
    }

}
