import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hit enter to initialise the game.");;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        Game.init();
        Game.start();
    }
}
