import java.io.*;

public class InstructorPortal {
    static Instructor currUser;    
    public static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        displayInstructors();
        int instNo = Integer.parseInt(br.readLine());
        if(instNo>=Data.getInstructors().size()){
            System.out.println("Index entered is too large!");
            return;
        }
        currUser = Data.getInstructors().get(instNo);
        while(true){
            printInstMenu();
            //TODO: Start working here FOR INSTRUCTOR METHOD
        }
 
    }

    public static void displayInstructors(){
        for(int i = 0; i <Data.getInstructors().size(); i++){
            System.out.print(i);
            System.out.println(" "+Data.getInstructors().get(i).getName());
        }
    }

    public static void printInstMenu(){
        System.out.println("1. Add class material");
        System.out.println("2. Add assessments");
        System.out.println("3. View lecture materials");
        System.out.println("4. View assessments");
        System.out.println("5. Grade assessments");
        System.out.println("6. Close assessment");
        System.out.println("7. View comments");
        System.out.println("8. Add comments");
        System.out.println("9. Logout");
    }
    
    
}
