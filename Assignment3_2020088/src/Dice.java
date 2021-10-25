import java.util.*;

public class Dice {
    private final int numFaces;
    private int faceVal;
    public Dice (int numFaces){
        this.numFaces = numFaces;
    }

    public int roll(){
        int curr = (int)(Math.random()*(2-1+1)+1);
        this.faceVal = curr;
        return this.faceVal;

    }
    public int getNumFaces(){
        return this.numFaces;
    }
    public int getCurrTop(){
        return this.faceVal;
    }
    
}
