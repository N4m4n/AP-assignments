import java.util.ArrayList;
public class Vaccine {
    private static ArrayList<Vaccine> allVaccines = new ArrayList<Vaccine>();
    String name;
    int noOfDoses;
    int gapBetweenDose;
    public Vaccine(String name, int noOfDoses, int gapBetweenDose){
        this.name = name;
        this.noOfDoses = noOfDoses;
        this.gapBetweenDose = gapBetweenDose;
        
    }
    public static void addVac(Vaccine v){
        allVaccines.add(v);
    }

}
