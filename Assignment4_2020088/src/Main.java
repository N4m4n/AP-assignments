import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hit enter to initialise the game.");;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        Game.init();
        Game.start();
        
        // Testing random numbers
        // System.out.println(Game.getRandomInt(0, 25, 65));
        // System.out.println(Game.getRandomInt(0, 28, 0));
        // System.out.println(Game.getRandomInt(0, 1000000,-50000));
    }
}
