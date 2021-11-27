import java.util.ArrayList;
import java.io.*;

public class Game {
    private static ArrayList<Toy> tileCarpet = new ArrayList<Toy>();
    private static Player mainPlayer = new Player();
    private static Calculator<String> strCalc = new Calculator<String>();
    private static Calculator<Integer> intCalc = new Calculator<Integer>();

    public static int getRandomInt(int min, int max){
        return (int) (Math.random()*(max - min + 1) + min);
    }

    public static void start() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Game is ready. Press enter to start");
        
        while(mainPlayer.getNoOfChances()>0){
            System.out.println("Hit enter for your chance number "+(5-mainPlayer.getNoOfChances()+1));
            br.readLine();
            mainPlayer.decrementChances();
            try{
                int jump = getRandomInt(0, 26);
                if(jump>=20){
                    throw new EnergeticException("Muddy Puddle Splash!");
                }else if(jump%2==0){
                    System.out.println("You landed on tile "+(jump+1));
                    oddTile(jump);
                }else if(jump%2==1){
                    System.out.println("You landed on tile "+(jump+1));
                    evenTile(jump);
                }

            }catch(EnergeticException e){
                System.out.println("You are too energetic and zoomed past all tiles.");
            }

            
        }
        
    }


    public static void evenTile(int j){
        Toy toClone = Game.getToyAt(j);
        Toy toAdd = toClone.clone();
        mainPlayer.addToy(toAdd);
    }

    public static void oddTile(int j){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Question Answer round. Integer or Strings?");
        boolean inputTaken = false;
        while(!inputTaken) {
            try{
                String inp = br.readLine();
                if((inp.equals("integer"))||(inp.equals("string"))){
                    if(inp.equals("integer")){
                        int a = getRandomInt(2, 1000000);
                        int b = getRandomInt(2, 1000000);
                        int actualAns= 0;
                        
                        System.out.println("Calculate the result of "+a+" divided by "+b);
                        try{
                            actualAns = intCalc.solve(a, b);
                        }catch(IllegalArgumentException iae){
                            System.out.println(iae.getMessage());
                        }

                        int userAns = 0;
                        boolean ansGiven = false;
                        while(!ansGiven){
                            try{
                                userAns = Integer.parseInt(br.readLine());
                                ansGiven = true;
                            }catch(NumberFormatException nfe){
                                System.out.println( nfe.getMessage() +": integer values allowed only. Try again.");
                            }catch(IOException e){
                                System.out.println(e.getMessage() +": Error occured while taking the answer input. Try again.");
                            }
                        }
                        if(actualAns == userAns){
                            Toy toClone = Game.getToyAt(j);
                            Toy toAdd = toClone.clone();
                            mainPlayer.addToy(toAdd);
                        }else{
                            System.out.println("You did not win any toy.");
                        }

                       
                    }else{
                        //Need to start here
                        System.out.println("Didnt write code");
                    }
                }else{
                    throw new InvalidOptionEnteredException("Invalid question type selected");
                }

                inputTaken = true;

            }catch(InvalidOptionEnteredException e){
                System.out.println("You can only choose between strings or integers.");
            }
            catch(IOException e){
                System.out.println("Error while taking input.");
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
    public static Toy getToyAt(int i){
        return tileCarpet.get(i);
    }
}
