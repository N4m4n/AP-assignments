import java.util.ArrayList;
public class Data {
    private static ArrayList<Student> allStudents = new ArrayList<>();
    private static ArrayList<Instructor> allInstructors = new ArrayList<>();
    public static void addStudent(Student student) {
        allStudents.add(student);
    }
    public static void addInstructor(Instructor instructor) {
        allInstructors.add(instructor);
    }

    public static  ArrayList<Instructor> getInstructors(){
        return allInstructors;
    }
    public static ArrayList<Student> getStudents(){
        return allStudents;
    }

}
