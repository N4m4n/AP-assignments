import java.util.ArrayList;
import java.util.Scanner;
public class Hospital {
    //Class variables 
   private static ArrayList<Hospital> allHospitals = new ArrayList<Hospital>();
   //Instance variables.
   private ArrayList<Slots> slots = new ArrayList<Slots>();
   private String Hname;
   private String pincode;
   private String id;
   static private int currId = 1;
   private String generateId(){
        String toRet = currId+"";
        while(toRet.length()<6){
            toRet = "0"+toRet;
        }
        return toRet;
   }

   public Hospital(String name, String pincode) {
       
        this.Hname = name;
        this.pincode = pincode;
        this.id = generateId();
        currId++;
        if(pincode.length()== 6){
            allHospitals.add(this);
        }else{
            this.id = "Not generated";
            System.out.println("Pincode should be 6 digits. Did not add hospital");
            currId--;
        }
       
   }



   public void addSlot(int noOfSlots){
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < noOfSlots; i++){
             System.out.print("Enter the day number: " );
             int day = sc.nextInt();
        
             System.out.print("Enter quantity: " );
             int quantity = sc.nextInt();

             Vaccine.showVaccNames();
             System.out.print("Enter index: ");
             int vaccIndex = sc.nextInt();

             while(!(vaccIndex >= 0 && vaccIndex < Vaccine.getList().size())) {
                  System.out.println("Invalid index. Please try again.");
                  Vaccine.showVaccNames();
                  System.out.print("Enter index: ");
                  
                    vaccIndex = sc.nextInt();
           
             }         

             Slots toAdd = new Slots(day, quantity, Vaccine.getList().get(vaccIndex).getName());
             this.slots.add(toAdd);
             System.out.println("Slot added by Hospital "+this.getId()+" for Day "+day+", Available quantity: "+quantity+" of Vaccine "+toAdd.getVaccineGiven());

        }
    
   }

   public static void showHospitals(){
        System.out.println();
        for(int i=0; i<allHospitals.size(); i++){
            Hospital temp = allHospitals.get(i);
            System.out.println("Hospital Name: "+temp.getName());
            System.out.println("Pincode: "+temp.getPincode());
            System.out.println("Unique ID: "+temp.getId());
            System.out.println();
        }
        
   }

   public static Hospital getHospById (String s){
     
     for(int i = 0; i < allHospitals.size(); i++){
          if(allHospitals.get(i).getId().equals(s)){
               return allHospitals.get(i);
          }
     }
     System.out.println("Could not find this ID. Pls enter again");
     return null;
   
}
   

   public String getId(){
        return this.id;
   }
   public String getName(){
        return this.Hname;
   }
   public String getPincode(){
        return this.pincode;
   }

    
}
