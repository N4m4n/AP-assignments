import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Covin portal initialising...");
        while(true){
            printMenu();
             
            int choice = sc.nextInt();

      
            if(choice == 1){
                System.out.print("Vaccine Name: ");
            
                String vacName = br.readLine();
        
                System.out.print("No of doses: ");
                int noOfDoses = sc.nextInt();
    

                System.out.print("Gap between doses: ");
                int gap = sc.nextInt();
           
                System.out.println();

                Vaccine currVacc = new Vaccine(vacName, noOfDoses, gap);
                System.out.println("Vaccine Name: "+currVacc.getName()+", No of Doses: "+currVacc.getDoses()+", Gap between doses: "+currVacc.getGap());
                System.out.println();
                



            }else if(choice == 2){
                System.out.print("Hospital Name: ");
         
                String hospName = br.readLine();
                System.out.print("Pincode: ");
                String pin = br.readLine();
                Hospital currHosp = new Hospital(hospName, pin);
                System.out.println("Hospital Name: "+currHosp.getName()+", PinCode: "+currHosp.getPincode()+", Unique ID: "+currHosp.getId());
                System.out.println();
                
                           



            }else if(choice == 3){
                System.out.print("Citizen Name: ");
            
                String citName = br.readLine();
                 
                System.out.print("Age: ");
                int age = sc.nextInt();
        
                System.out.print("Unique ID: ");
         
                String uid = br.readLine();
                Citizen currCiti = new Citizen(citName, age, uid);
                System.out.println("Citizen Name: "+currCiti.getName()+", Age: "+currCiti.getAge()+", Unique ID "+currCiti.getId());
                System.out.println();


            }else if(choice == 4){
                System.out.print("Enter Hospital ID: ");
                
                String enteredId = br.readLine();
                Hospital selectedHospital = Hospital.getHospById(enteredId);
                while(selectedHospital == null){
                    System.out.print("Enter Hospital ID: ");
                  
                    enteredId = br.readLine();
                    selectedHospital = Hospital.getHospById(enteredId);
                }
                System.out.print("Enter no of slots: ");
                int noOfSlots = sc.nextInt();
       
                selectedHospital.addSlot(noOfSlots);
                


            }else if(choice == 5){

            }else if(choice == 6){

            }else if(choice == 7){

            }else if(choice == 8){
                break;
            }else{
                //TODO:remove below lines (x.y() types). Only for testing.  

                // Vaccine.showVacc();
                // Hospital.showHospitals();
                // Citizen.showCitizens();
                System.out.println("Invalid input. Please try again.");
                continue;
            }
            
        
        }
        System.out.println("Thank you for using Covin portal.");

    }
}
