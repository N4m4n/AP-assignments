import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class App {
    static void printSearchMenu(){
        System.out.println("1. Search by area");
        System.out.println("2. Search by Vaccine");
        System.out.println("3. Exit");
        
    }
    static void printMenu(){
        System.out.println("-------------------------------------------");
        System.out.println("Choose an option :");
        System.out.println("1. Add vaccine");
        System.out.println("2. Register Hospital");
        System.out.println("3. Register Citizen");
        System.out.println("4. Add slot for Vaccination.");
        System.out.println("5. Book slot for Vaccinaton");
        System.out.println("6. List all slots for a hospital");
        System.out.println("7. Check Vaccination Status");
        System.out.println("8. Exit");
        System.out.println("-------------------------------------------");
    }
  
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Covin portal initialising...");
        while(true){
            printMenu();     
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
