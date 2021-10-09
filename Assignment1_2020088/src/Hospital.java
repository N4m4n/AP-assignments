import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
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



   public void addSlot(int noOfSlots) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        for(int i = 0; i < noOfSlots; i++){
             System.out.print("Enter the day number: " );
             int day = Integer.parseInt(br.readLine());
        
             System.out.print("Enter quantity: " );
             int quantity = Integer.parseInt(br.readLine());

             Vaccine.showVaccNames();
             System.out.print("Enter index: ");
             int vaccIndex = Integer.parseInt(br.readLine());

             while(!(vaccIndex >= 0 && vaccIndex < Vaccine.getList().size())) {
                  System.out.println("Invalid index. Please try again.");
                  Vaccine.showVaccNames();
                  System.out.print("Enter index: ");
                  
                    vaccIndex = Integer.parseInt(br.readLine());
           
             }         

             Slots toAdd = new Slots(day, quantity, Vaccine.getList().get(vaccIndex));
             this.slots.add(toAdd);
             System.out.println("Slot added by Hospital "+this.getId()+" for Day "+day+", Available quantity: "+quantity+" of Vaccine "+toAdd.getVaccineGiven().getName());

        }

    
   }

   public void updateSlot(int chosenSlot){
        Slots toUpdate = this.slots.get(chosenSlot);
        int currQuantitiy = toUpdate.getQuantity();
        if (currQuantitiy <=1){
             this.slots.remove(chosenSlot);
        }else{
             toUpdate.setQuantity(currQuantitiy-1);
        }
       
   }

   public void showSlots(){
        ArrayList<Slots> temp = this.slots;
        for(int i = 0; i < temp.size(); i++){
             Slots tempSlot = temp.get(i);
             System.out.println(i+"--> Day: "+tempSlot.getDayNo()+", Vaccine: "+tempSlot.getVaccineGiven().getName()+", Available Quantity: "+tempSlot.getQuantity());
        }
   }

   public ArrayList<Integer> getNShowValidSlots(Vaccine prevVacc, int vaccDueDate){
        ArrayList<Integer> toRet = new ArrayList<Integer>();
        int ptr = 0;
        for(int i = 0; i < this.slots.size(); i++){
             Slots temp = this.slots.get(i);
             if((temp.getVaccineGiven().equals(prevVacc))&&(temp.getDayNo()>=vaccDueDate)){
                    System.out.println(ptr+"--> Day: "+temp.getDayNo()+", Vaccine: "+temp.getVaccineGiven().getName()+", Available Quantity: "+temp.getQuantity());
                    toRet.add(i);
             }
        }
        return toRet;
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
   public static ArrayList<Integer> getHospitalsIndexInPin(String s){
     ArrayList<Integer> toRet = new ArrayList<Integer>();
     for(int i = 0; i < allHospitals.size(); i++){
          Hospital temp = allHospitals.get(i);
          if(temp.getPincode().equals(s)){
               System.out.println(temp.getId()+" "+temp.getName());
               toRet.add(i);
          }
     }
     return toRet;
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
   public ArrayList<Slots> getSlots(){
        return this.slots;
   }

    
}
