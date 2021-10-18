import java.util.ArrayList;
public class Data {
    private static ArrayList<Student> allStudents = new ArrayList<>();
    private static ArrayList<Instructor> allInstructors = new ArrayList<>();
    private static ArrayList<Slides> allSlides = new ArrayList<>();
    private static ArrayList<Video> allVideos = new ArrayList<>();
    
    public static void addStudent(Student student) {
        allStudents.add(student);
    }
    public static void addInstructor(Instructor instructor) {
        allInstructors.add(instructor);
    }
    public static void addSlides(Slides slides) {
        allSlides.add(slides);
    }
    public static void addVideo(Video video) {
        allVideos.add(video);
    }

    public static  ArrayList<Instructor> getInstructors(){
        return allInstructors;
    }
    public static ArrayList<Student> getStudents(){
        return allStudents;
    }
    public static ArrayList<Slides> getSlides(){
        return allSlides;
    }
    public static ArrayList<Video> getVideos(){
        return allVideos;
    }

}
