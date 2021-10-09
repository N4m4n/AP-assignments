import java.util.ArrayList;
public class Citizen {
   private int age;
   private String UID;
   private String vaccStatus;
   private String cname;
   private Vaccine vaccineAdministered;
   private int dosesTaken;
   private int dueDate;
   private int dosesLeft;


   private static ArrayList<Citizen> allCitizens = new ArrayList<Citizen>();
   public Citizen(String name, int age, String id){
       this.cname = name;
       this.UID = id;
       this.age = age;
       this.vaccStatus = "REGISTERED";
       this.dosesTaken = 0;
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
    public static Citizen getCitizenById (String s){
     
    for(int i = 0; i < allCitizens.size(); i++){
         if(allCitizens.get(i).getId().equals(s)){
              return allCitizens.get(i);
         }
    }
    System.out.println("Could not find this ID. Pls enter again");
    return null;
  
    }


    public void updatePatient(Vaccine givenDose, Slots slotUsed){
        System.out.println(givenDose.getDoses());
        if(this.vaccStatus.equals("REGISTERED")){
            this.vaccineAdministered = givenDose;
            this.dosesTaken+=1;
            this.dosesLeft = givenDose.getDoses()-1;
            if(dosesLeft==0){
                this.vaccStatus = "FULLY VACCINATED";
            }else{
                this.vaccStatus = "PARTIALLY VACCINATED";
                this.dueDate = slotUsed.getDayNo()+givenDose.getGap();
            }
            

        }else{
            this.dosesTaken+=1;
            this.dosesLeft -=1 ;
            if(dosesLeft==0){
                this.vaccStatus = "FULLY VACCINATED";
            }else{
                this.vaccStatus = "PARTIALLY VACCINATED";
                this.dueDate = slotUsed.getDayNo()+givenDose.getGap();
            }

        }
    }

    public int getDueDate(){
        return this.dueDate;
    }
    public Vaccine getVaccAdministered(){
        return this.vaccineAdministered;
    }
    public int getDosesTaken(){
        return this.dosesTaken;
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
   public void setVaccStatus(String s){
       this.vaccStatus = s;
   }
    
}
