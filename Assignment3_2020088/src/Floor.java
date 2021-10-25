public class Floor {
    protected int position;
    Floor(int pos){
        this.position = pos;
    }    
    
    public void updatePlayer(Player a){
        System.out.println("Player position Floor-"+a.getPosition());
        a.addPoints(0);
        System.out.println(a.getName()+" has reached a floor");
        System.out.println("Total points = "+ a.getPoints());
    }
}
