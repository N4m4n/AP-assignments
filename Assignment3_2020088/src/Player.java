public class Player {
    private int currPosition;
    private int points;
    private String name;
    private boolean started;
    Player(String name){
        this.name = name;
        this.currPosition = 0;
        this.points = 0;
        this.started = false;
    }
    public int  getPosition() { 
        return this.currPosition; 
    }
    public int getPoints(){
        return this.points;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public void addPoints(int n){
        this.points += n;
    }
    public void changePos(int n){
        this.currPosition = n;
    }
    public boolean ifStarted(){
        return this.started;
    }


}
