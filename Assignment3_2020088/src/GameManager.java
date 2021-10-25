import java.util.ArrayList;
import java.io.*;
public class GameManager {
    private static ArrayList<Floor> allFloors = new ArrayList<>();
    private static Player mainPlayer;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String playerName = br.readLine();
        GameManager.mainPlayer = new Player(playerName);
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

    public ArrayList<Floor> getAllFloors(){
        return allFloors;
    }
}
