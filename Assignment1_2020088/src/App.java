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
             
            int choice = Integer.parseInt(br.readLine());

      
            if(choice == 1){
                System.out.print("Vaccine Name: ");
            
                String vacName = br.readLine();
        
                System.out.print("No of doses: ");
                int noOfDoses = Integer.parseInt(br.readLine());
                int gap = 0;
                if(noOfDoses>1){
                    System.out.print("Gap between doses: ");
                    gap = Integer.parseInt(br.readLine());
                }
                
           
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
                int age = Integer.parseInt(br.readLine());
        
                System.out.print("Unique ID: ");
         
                String uid = br.readLine();
                Citizen currCiti = new Citizen(citName, age, uid);
                currCiti.setVaccStatus("REGISTERED");
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
                int noOfSlots = Integer.parseInt(br.readLine());
       
                selectedHospital.addSlot(noOfSlots);
                


            }else if(choice == 5){
                System.out.print("Enter patient Unique ID: ");
                String enteredUID = br.readLine();
                Citizen patient = Citizen.getCitizenById(enteredUID);
                while(patient == null){
                   
                    System.out.print("Enter patient Unique ID: ");
                    enteredUID = br.readLine();
                    patient = Citizen.getCitizenById(enteredUID);

                }
                if(patient.getVaccStatus().equals("FULLY VACCINATED")){
                    System.out.println("This person is already fully vaccinated.");
                    continue;
                }
                printSearchMenu();
                System.out.print("Enter option: ");
                int searchOpt = Integer.parseInt(br.readLine());
                while(!(searchOpt>=1 && searchOpt<=3)){
                    System.out.println("Invalid input. Try again");
                    printSearchMenu();
                    System.out.print("Enter option: ");
                    searchOpt = Integer.parseInt(br.readLine());
                }
                if(searchOpt==1){
                    System.out.print("Enter pincode: ");
                    String pincode = br.readLine();
                    ArrayList<Integer> match = Hospital.getHospitalsIndexInPin(pincode);
                    if(match.size()==0){
                        System.out.println("No hospital in provided pincode");
                        continue;
                    }
                    System.out.print("Enter Hospital ID: ");
                    String enteredId = br.readLine();                    
                    Hospital selectedHospital = Hospital.getHospById(enteredId);
                    while(selectedHospital == null){
                        System.out.print("Enter Hospital ID: ");
                      
                        enteredId = br.readLine();
                        selectedHospital = Hospital.getHospById(enteredId);
                    }
                    if(selectedHospital.getSlots().size() == 0){
                        System.out.println("This hospital has no slots");
                        continue;
                    }

                    if(patient.getVaccStatus().equals("REGISTERED")){
                        selectedHospital.showSlots();
                        System.out.print("Choose slot: ");
                        int chosenSlot = Integer.parseInt(br.readLine());
                        while(!(chosenSlot>=0 && chosenSlot< selectedHospital.getSlots().size())){
                            System.out.println("Invalid slot try again");
                            System.out.print("Choose slot: ");
                            chosenSlot = Integer.parseInt(br.readLine());
                        }

                        selectedHospital.updateSlot(chosenSlot);
                        patient.updatePatient(selectedHospital.getSlots().get(chosenSlot).getVaccineGiven(), selectedHospital.getSlots().get(chosenSlot));
                        System.out.println(patient.getName()+" vaccinated with "+selectedHospital.getSlots().get(chosenSlot).getVaccineGiven().getName());
    


                    }else{
                        Vaccine prevVacc = patient.getVaccAdministered();
                        int vaccDueDate = patient.getDueDate();
                        ArrayList<Integer> validSlotIndices = selectedHospital.getNShowValidSlots(prevVacc, vaccDueDate);
                        if(validSlotIndices.size()==0){
                            System.out.println("No slots available.");
                            continue;
                        }
                        System.out.print("Choose slot: ");
                        int chosenSlotInd = Integer.parseInt(br.readLine());
                        while(!(chosenSlotInd>=0 && chosenSlotInd< validSlotIndices.size())){
                            System.out.println("Invalid option try again");
                            System.out.print("Choose slot: ");
                            chosenSlotInd = Integer.parseInt(br.readLine());
                        }
                        selectedHospital.updateSlot(validSlotIndices.get(chosenSlotInd));
                        patient.updatePatient(patient.getVaccAdministered() ,  selectedHospital.getSlots().get(validSlotIndices.get(chosenSlotInd)));
                        System.out.println(patient.getName()+" vaccinated with "+patient.getVaccAdministered().getName());
    


                    }
                    
                }else if(searchOpt==2){
                    System.out.print("Enter the vaccine: ");
                    String toSearch = br.readLine();
                    if(!(patient.getVaccStatus().equals("REGISTERED"))){
                        if(!(patient.getVaccAdministered().getName().equals(toSearch))){
                            System.out.println("This vaccine does not match your first vaccine");
                            continue;
                        }
                    }
                    Vaccine vacc = Vaccine.getVaccfromName(toSearch);
                    if(vacc==null){
                        System.out.println("This vaccine does not exist");
                        continue;
                    }
                    
                    ArrayList<Integer> matchingHospIndices = Hospital.getHospitalsByVaccInd(toSearch);
                    if(matchingHospIndices.size()==0){
                        System.out.println("No hospital with the required Vaccine");
                        continue;
                    }

                    System.out.print("Enter Hospital ID: ");
                    String enteredId = br.readLine();                    
                    Hospital selectedHospital = Hospital.getHospById(enteredId);
                    while(selectedHospital == null){
                        System.out.print("Enter Hospital ID: ");
                      
                        enteredId = br.readLine();
                        selectedHospital = Hospital.getHospById(enteredId);
                    }
                    int vaccDueDate = -1;
                    if(patient.getVaccStatus().equals("PARTIALLY VACCINATED")){
                        vaccDueDate = patient.getDueDate();
                    }
                    

                    ArrayList<Integer> validSlotIndices = selectedHospital.getNShowValidSlots(vacc, vaccDueDate);
                    if(validSlotIndices.size()==0){
                        System.out.println("No slots available.");
                        continue;
                    }
                    System.out.print("Choose slot: ");
                    int chosenSlotInd = Integer.parseInt(br.readLine());
                    while(!(chosenSlotInd>=0 && chosenSlotInd< validSlotIndices.size())){
                        System.out.println("Invalid option try again");
                        System.out.print("Choose slot: ");
                        chosenSlotInd = Integer.parseInt(br.readLine());
                    }

                    selectedHospital.updateSlot(validSlotIndices.get(chosenSlotInd));
                    patient.updatePatient(vacc,  selectedHospital.getSlots().get(validSlotIndices.get(chosenSlotInd)));
                    System.out.println(patient.getName()+" vaccinated with "+patient.getVaccAdministered().getName());
                    

                    
                }else if(searchOpt==3){
                    continue;
                }


            }else if(choice == 6){
                System.out.print("Enter Hospital ID: ");
                
                String enteredId = br.readLine();
                Hospital selectedHospital = Hospital.getHospById(enteredId);
                while(selectedHospital == null){
                    System.out.print("Enter Hospital ID: ");
                  
                    enteredId = br.readLine();
                    selectedHospital = Hospital.getHospById(enteredId);
                }
                System.out.println(selectedHospital.getName());
                selectedHospital.showSlots();
                if(selectedHospital.getSlots().size() == 0){
                    System.out.println("No more slots for this hospital");
                }

            }else if(choice == 7){
                System.out.print("Enter patient Unique ID: ");
                String enteredUID = br.readLine();
                Citizen patient = Citizen.getCitizenById(enteredUID);
                while(patient == null){
                   
                    System.out.print("Enter patient Unique ID: ");
                    enteredUID = br.readLine();
                    patient = Citizen.getCitizenById(enteredUID);

                }
                System.out.println(patient.getVaccStatus());
                if(patient.getVaccStatus().equals("PARTIALLY VACCINATED")){
                    System.out.println("Vaccine Given: "+patient.getVaccAdministered().getName());
                    System.out.println("Number of Doses given: "+patient.getDosesTaken());
                    System.out.println("Next Dose due date: "+patient.getDueDate());
                }else if (patient.getVaccStatus().equals("FULLY VACCINATED")){
                    System.out.println("Vaccine Given: "+patient.getVaccAdministered().getName());
                    System.out.println("Number of Doses given: "+patient.getDosesTaken());

                }


            }else if(choice == 8){
                break;
            }else{
                

                // Vaccine.showVacc();
                // Hospital.showHospitals();
                // Citizen.showCitizens();
                System.out.println("Invalid input. Please try again.");
                continue;
            }
            
        
        }
        System.out.println("Thank you for using Covin portal.");
        sc.close();
    }
}
