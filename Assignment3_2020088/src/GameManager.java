import java.util.ArrayList;
import java.io.*;
import java.nio.Buffer;
public class GameManager {
    private static ArrayList<Floor> allFloors = new ArrayList<>();
    private static Player mainPlayer;
    private static Dice mainDice;
    private static int highscore;
    public static void init() throws IOException {
        System.out.print("Enter the player's name and hit enter: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String playerName = br.readLine();
        GameManager.mainPlayer = new Player(playerName);
        GameManager.mainDice = new Dice(2);
        highscore = Integer.MIN_VALUE;
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
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(mainPlayer.getPosition()<13){
            
            System.out.println("Hit enter to roll the dice");
            System.out.println("----------------------------------------------------");
            
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
        System.out.println();
        if(getHighScore()<mainPlayer.getPoints()){
            System.out.println("Congratulations! You have set a new high score!");
            setHighScore(mainPlayer.getPoints());
        }
        System.out.println("Do you wish to restart?\n1. Yes\n2. No");
        String restrt = reader.readLine();
        if(restrt.equals("1")){
            GameManager.restart();
        }else if(restrt.equals("2")){
            return;
        }else{
            System.out.println("Invalid input. Exiting game.");
            return;
        }

    }

    public static void restart() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        mainPlayer.setPosition(-1);
        mainPlayer.addPoints(-mainPlayer.getPoints());
        mainPlayer.setIfStarted(false);
        System.out.print("Enter new Player's name: ");
        String newName = br.readLine();
        mainPlayer.setName(newName);
        GameManager.startGame();
    }

    public static ArrayList<Floor> getAllFloors(){
        return allFloors;
    }
    public static Player getMainPlayer(){
        return mainPlayer;
    }
    public static void setHighScore(int hs){
        highscore = hs;
    }
    public static int getHighScore(){
        return highscore;
    }
}
