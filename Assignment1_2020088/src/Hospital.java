import java.util.ArrayList;
public class Hospital {
   private static ArrayList<Hospital> allHospitals = new ArrayList<Hospital>();
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
