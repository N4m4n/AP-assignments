import java.io.*;
public class StudentPortal{
    
    static Student currUser;    
    public static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        displayStudents();
        int stuNo = Integer.parseInt(br.readLine());
        if(stuNo>=Data.getStudents().size()){
            System.out.println("Index entered is too large!");
            return;
        }
        currUser = Data.getStudents().get(stuNo);
        while(true){
            printStuMenu();
            //TODO: Start working here FOR INSTRUCTOR METHOD
        }
 
    }

    public static void displayStudents(){
        for(int i = 0; i <Data.getStudents().size(); i++){
            System.out.print(i);
            System.out.println(" "+Data.getStudents().get(i).getName());
        }
    }

    public static void printStuMenu(){
        System.out.println("1. View lecture materials");
        System.out.println("2. View assessments");
        System.out.println("3. Submit assessment");
        System.out.println("4. View grades");
        System.out.println("5. View comments");
        System.out.println("6. Add comments");
        System.out.println("7. Logout");
    }
    
    
}
