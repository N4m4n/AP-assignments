import java.util.ArrayList;
public class Citizen {
   private int age;
   private String UID;
   private String vaccStatus;
   private String cname;
   private Vaccine vaccineAdministered;
   private int dosesTaken;
   private int dueDate;


   private static ArrayList<Citizen> allCitizens = new ArrayList<Citizen>();
   public Citizen(String name, int age, String id){
       this.cname = name;
       this.UID = id;
       this.age = age;
       this.vaccStatus = "REGISTERED";
       if(age<18){
           System.out.println("Did not add this citizen as only above 18 citizens are allowed ");
       }else if(id.length()!=12){
        System.out.println("Did not this citizen as the id was not 12 characters long");
       }else{
            allCitizens.add(this);
       }

   }



   public static void showCitizens(){
    System.out.println();
    for(int i=0; i<allCitizens.size(); i++){
        Citizen temp = allCitizens.get(i);
        System.out.println("Citizen Name: "+temp.getName());
        System.out.println("Age: "+temp.getAge());
        System.out.println("Unique ID: "+temp.getId());
        System.out.println();
    }
    
}

   public String getName(){
       return this.cname;
   }
   public String getId(){
       return this.UID;
   }
   public int getAge(){
       return this.age;
   }
   public String getVaccStatus(){
       return this.vaccStatus;
   }
    
}
