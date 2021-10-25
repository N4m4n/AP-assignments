import java.util.ArrayList;
import java.io.*;
public class GameManager {
    private static ArrayList<Floor> allFloors = new ArrayList<>();
    private static Player mainPlayer;
    private static Dice mainDice;
    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String playerName = br.readLine();
        GameManager.mainPlayer = new Player(playerName);
        GameManager.mainDice = new Dice(2);
        allFloors.add(new EmptyFloor());
        allFloors.add(new EmptyFloor());
        allFloors.add(new ElevatorFloor());
        allFloors.add(new EmptyFloor());
        allFloors.add(new EmptyFloor());
        allFloors.add(new SnakeFloor());
        allFloors.add(new EmptyFloor());
        allFloors.add(new EmptyFloor());
        allFloors.add(new LadderFloor());
        allFloors.add(new EmptyFloor());
        allFloors.add(new EmptyFloor());
        allFloors.add(new KingCobraFloor());
        allFloors.add(new EmptyFloor());
        allFloors.add(new EmptyFloor());
      
    }
    public static void startGame() throws IOException {
        System.out.println("The game setup is ready.");
        while(mainPlayer.getPosition()<13){
            
            System.out.println("Hit enter to roll the dice");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            reader.readLine();
            System.out.print("Dice gave ");
            System.out.println(mainDice.roll());
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

        System.out.println(mainPlayer.getName() + " accumulated "+mainPlayer.getPoints()+" points.");
    }

    public static ArrayList<Floor> getAllFloors(){
        return allFloors;
    }
    public static Player getMainPlayer(){
        return mainPlayer;
    }
}
