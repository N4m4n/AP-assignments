public class Course {
    public static void initialise(){
        
        Student S0 = new Student("S0");
        Student S1 = new Student("S1");
        Student S2 = new Student("S2");
        Instructor I0 = new Instructor("I0");
        Instructor I1 = new Instructor("I1");

        Data.addStudent(S0);
        Data.addStudent(S1);
        Data.addStudent(S2);
        Data.addInstructor(I0);
        Data.addInstructor(I1);


    }

    
    
}
