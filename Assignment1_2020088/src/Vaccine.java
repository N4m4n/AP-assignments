import java.util.ArrayList;
public class Vaccine {
    private static ArrayList<Vaccine> allVaccines = new ArrayList<Vaccine>();
    private String vname;
    private int noOfDoses;
    private int gapBetweenDose;

    public Vaccine(String name, int noOfDoses, int gapBetweenDose){
        this.vname = name;
        this.noOfDoses = noOfDoses;
        this.gapBetweenDose = gapBetweenDose;
        allVaccines.add(this);
        
    }

    public static Vaccine getVaccfromName(String s){
        for(int i = 0; i < allVaccines.size(); i++){
            if(allVaccines.get(i).getName().equals(s)){
                return allVaccines.get(i);
            }
        }
        return null;
    }

    public static void addVac(Vaccine v){
        allVaccines.add(v);
    }

    public static void showVacc(){
        System.out.println();
        for(int i = 0; i < allVaccines.size();i++){
            Vaccine temp = allVaccines.get(i);
            
            System.out.println("Vaccine Name: "+temp.getName());
            System.out.println("No of doses: "+temp.getDoses());
            System.out.println("Gap between dose: "+temp.getGap());
            System.out.println();
        }
    }

    public static void showVaccNames(){
        System.out.println();
        for(int i = 0; i < allVaccines.size();i++){
            Vaccine temp = allVaccines.get(i);
            System.out.println(i+": "+temp.getName());
        }
    }


    public String getName(){
        return this.vname;
    }
    public int getDoses(){
        return this.noOfDoses;
    }
    public int getGap(){
        return this.gapBetweenDose;
    }
    
    public static ArrayList<Vaccine> getList(){
        return allVaccines;
    }

}
