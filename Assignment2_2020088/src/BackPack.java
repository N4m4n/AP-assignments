import java.io.*;
public class BackPack {
    public static void main(String[] args) throws Exception {
        Course.initialise();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            printMainMenu();
            int loggedInAs = Integer.parseInt(reader.readLine());
            if(loggedInAs==1){
                InstructorPortal.init();
            }else if(loggedInAs==2){
                StudentPortal.init();
            }else if(loggedInAs==3){
                break;
            }else{
                Data.displayAssessments();
                System.out.println("Invalid input. Try again.");
            }
    }     
}
    private static  void printMainMenu(){
        System.out.println("------------------------------------------------");
        System.out.println("Welcome to BackPack");
        System.out.println("1. Enter as instructor.");
        System.out.println("2. Enter as student.");
        System.out.println("3. Exit");
        System.out.println("------------------------------------------------");
    }    
}