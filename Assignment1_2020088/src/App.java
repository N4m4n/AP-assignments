import java.util.Scanner;

public class App {
    static void printMenu(){
        System.out.println("Choose an option :");
        System.out.println("1. Add vaccine");
        System.out.println("2. Register Hospital");
        System.out.println("3. Register Citizen");
        System.out.println("4. Add slot for Vaccination.");
        System.out.println("5. Book slot for Vaccinaton");
        System.out.println("6. List all slots for a hospital");
        System.out.println("7. Check Vaccination Status");
        System.out.println("8. Exit");
        


    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Covin portal initialising...");
        while(true){
            printMenu();
            int choice = sc.nextInt();
            if(choice == 1){
                System.out.print("Vaccine Name: ");
                sc.nextLine();
                String vacName = sc.nextLine();
        
                System.out.print("No of doses: ");
                int noOfDoses = sc.nextInt();

                System.out.print("Gap between doses: ");
                int gap = sc.nextInt();
                System.out.println();

                System.out.println("Vaccine Name: "+vacName+", No of Doses: "+noOfDoses+", Gap between doses: "+gap);
                System.out.println();

                Vaccine currVacc = new Vaccine(vacName, noOfDoses, gap);
                Vaccine.addVac(currVacc);



            }else if(choice == 2){

            }else if(choice == 3){

            }else if(choice == 4){

            }else if(choice == 5){

            }else if(choice == 6){

            }else if(choice == 7){

            }else if(choice == 8){
                break;
            }else{
                System.out.println("Invalid input. Please try again.");
                continue;
            }
            
        
        }
        System.out.println("Thank you for using Covin portal.");

    }
}
