import java.util.ArrayList;

public class Player {
    private int noOfChances;
    private ArrayList<Toy> bucket = new ArrayList<Toy>();  
    
    public Player(){
        this.noOfChances = 5;
    }

    public int getNoOfChances() {
        return this.noOfChances;
    }

    public ArrayList<Toy> getbucket(){
        return bucket;
    }

    public void addToy(Toy toAdd){
        System.out.println("You just won a "+toAdd.getName()+" soft toy.");
        bucket.add(toAdd);
    }

    public void decrementChances(){
        this.noOfChances--;
    }

}
