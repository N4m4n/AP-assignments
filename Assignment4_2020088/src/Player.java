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
        bucket.add(toAdd);
    }

    public int getJump() {
        return (int) Math.random()*(26 - 0 + 1) + 0;
    }
    public void decrementChances(){
        this.noOfChances--;
    }

}
