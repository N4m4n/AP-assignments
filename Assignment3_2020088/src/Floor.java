public class Floor {
    protected int position;
    protected int pointsGained;
    Floor(int pos){
        this.position = pos;
        this.pointsGained = 0;
    }    
    
    public void updatePlayer(Player a){
        System.out.println("Player position Floor-"+a.getPosition());
        a.addPoints(getPointsPossible());
        System.out.println(a.getName()+" has reached a floor");
        System.out.println("Total points = "+ a.getPoints());
    }

    public int getPointsPossible(){
        return this.pointsGained;
    }
}
