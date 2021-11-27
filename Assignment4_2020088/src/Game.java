import java.util.ArrayList;
import java.io.*;
public class Game {
    private static ArrayList<Toy> tileCarpet = new ArrayList<Toy>();
    private static Player mainPlayer = new Player();
    private static Calculator<String> strCalc = new Calculator<String>();
    private static Calculator<Integer> intCalc = new Calculator<Integer>();
    public static void start() {
        System.out.println("Game is ready.");
        while(mainPlayer.getNoOfChances()>0){
            System.out.println("Hit enter for your chance number "+(5-mainPlayer.getNoOfChances()+1));
            mainPlayer.decrementChances();
            try{
                int jump = mainPlayer.getJump();
                if(jump>=20){
                    throw new EnergeticException("Muddy Puddle Splash!");   
                }else if(jump%2==0){
                    
                }else if(jump%2==1){

                }

            }catch(EnergeticException e){
                System.out.println("You are too energetic and zoomed past all tiles.");
            }

            
        }
        
    }

    public static void init(){
        tileCarpet.add(new Toy("Teddy", true));
        tileCarpet.add(new Toy("Duck", false));
        tileCarpet.add(new Toy("Dog", true));
        tileCarpet.add(new Toy("Mickey"));
        tileCarpet.add(new Toy("Jerry", true));
        tileCarpet.add(new Toy("Tom"));
        tileCarpet.add(new Toy("Daffy", true));
        tileCarpet.add(new Toy("Buzz Lightyear"));
        tileCarpet.add(new Toy("Woody", true));
        tileCarpet.add(new Toy("Xbox"));
        tileCarpet.add(new Toy("Tiger", true));
        tileCarpet.add(new Toy("PS5"));
        tileCarpet.add(new Toy("", true));
        tileCarpet.add(new Toy(""));
        tileCarpet.add(new Toy("", true));
        tileCarpet.add(new Toy(""));
        tileCarpet.add(new Toy("", true));
        tileCarpet.add(new Toy("Piggu Penguin"));
        tileCarpet.add(new Toy("Bob", true));
        tileCarpet.add(new Toy("Minion"));
        
        

    }
    public Toy getToyAt(int i){
        return tileCarpet.get(i);
    }
}
