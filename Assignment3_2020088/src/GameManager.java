import java.util.ArrayList;
import java.io.*;
public class GameManager {
    private static ArrayList<Floor> allFloors = new ArrayList<>();
    private static Player mainPlayer;
    private static Dice mainDice;
    public static void init() throws IOException {
        System.out.print("Enter the player's name and hit enter: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String playerName = br.readLine();
        GameManager.mainPlayer = new Player(playerName);
        GameManager.mainDice = new Dice(2);
        allFloors.add(new EmptyFloor(0));
        allFloors.add(new EmptyFloor(1));
        allFloors.add(new ElevatorFloor(2));
        allFloors.add(new EmptyFloor(3));
        allFloors.add(new EmptyFloor(4));
        allFloors.add(new SnakeFloor(5));
        allFloors.add(new EmptyFloor(6));
        allFloors.add(new EmptyFloor(7));
        allFloors.add(new LadderFloor(8));
        allFloors.add(new EmptyFloor(9));
        allFloors.add(new EmptyFloor(10));
        allFloors.add(new KingCobraFloor(11));
        allFloors.add(new EmptyFloor(12));
        allFloors.add(new EmptyFloor(13));
      
    }


    public static void startGame() throws IOException {
        System.out.println("The game setup is ready.");
        while(mainPlayer.getPosition()<13){
            
            System.out.println("Hit enter to roll the dice");
            System.out.println("----------------------------------------------------");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            reader.readLine();
            System.out.print("Dice gave ");
            System.out.println(mainDice.roll());
            if(mainPlayer.getPosition()==12 && mainDice.getCurrTop()==2){
                System.out.println("Player cannot move.");
                continue;
            }
            if(mainPlayer.ifStarted()){
                
                mainPlayer.setPosition(mainPlayer.getPosition()+mainDice.getCurrTop());
                Floor currFloor = allFloors.get(mainPlayer.getPosition());
                currFloor.updatePlayer(mainPlayer);
            }else{
               
                if(mainDice.getCurrTop()==1){
                    mainPlayer.setIfStarted(true);
                    mainPlayer.setPosition(0);
                    Floor currFloor = allFloors.get(mainPlayer.getPosition());
                    currFloor.updatePlayer(mainPlayer);

                }else{
                    System.out.println("Cannot start game until you get 1.");
                    continue;
                }
            }
        }
        System.out.println("Game Over!");
        System.out.println(mainPlayer.getName() + " accumulated "+mainPlayer.getPoints()+" points.");
    }

    public static ArrayList<Floor> getAllFloors(){
        return allFloors;
    }
    public static Player getMainPlayer(){
        return mainPlayer;
    }
}
