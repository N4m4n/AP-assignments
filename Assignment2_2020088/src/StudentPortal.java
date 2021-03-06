import java.io.*;
public class StudentPortal{
    
    static Student currUser;    
    public static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        displayStudents();
        System.out.print("Choose id: ");
        int stuNo = Integer.parseInt(br.readLine());
        if(stuNo>=Data.getStudents().size()){
            System.out.println("Index entered is too large!");
            return;
        }
        currUser = Data.getStudents().get(stuNo);
        
        while(true){
            System.out.println("Welcome "+currUser.getName());
            printStuMenu();
            
            int job = Integer.parseInt(br.readLine());
            if(job==1){
                currUser.viewMaterials();
            }else if(job==2){
                currUser.viewAssessments();
            }else if(job==3){
                currUser.manageSubmission(0);
            }else if(job==4){
                currUser.manageSubmission(1);
            }else if(job==5){
                currUser.viewCommentSection();
            }else if(job==6){
                System.out.print("Enter comment: ");
                String s = br.readLine();
                currUser.addComment(s);
            }else if(job==7){
                return;
            }else{
                System.out.println("invalid input");
            }
        }
 
    }

    public static void displayStudents(){
        System.out.println("Students:");
        for(int i = 0; i <Data.getStudents().size(); i++){
            System.out.print(i);
            System.out.println(" "+Data.getStudents().get(i).getName());
        }
        System.out.println();
    }

    public static void printStuMenu(){
        System.out.println("------------------------------------------------");
        System.out.println("1. View lecture materials");
        System.out.println("2. View assessments");
        System.out.println("3. Submit assessment");
        System.out.println("4. View grades");
        System.out.println("5. View comments");
        System.out.println("6. Add comments");
        System.out.println("7. Logout");
        System.out.println("------------------------------------------------");
    }
    
    
}
