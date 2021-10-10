import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class App {
    
    
  
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Covin portal initialising...");
        while(true){
            PortalManager.printMenu();     
            int choice = Integer.parseInt(br.readLine()); 
            if(choice == 1){
                PortalManager.option1();         

            }else if(choice == 2){
                PortalManager.option2();
            }else if(choice == 3){
               
                PortalManager.option3();

            }else if(choice == 4){               
                PortalManager.option4();

            }else if(choice == 5){
                PortalManager.option5();

            }else if(choice == 6){
                PortalManager.option6();

            }else if(choice == 7){
                PortalManager.option7();
            }else if(choice == 8){
                break;
            }else{         
                System.out.println("Invalid input. Please try again.");
                continue;
            }
            
        
        }
        System.out.println("Thank you for using Covin portal.");
        sc.close();
    }
}
