public abstract class Floor {
    protected int position;
    protected int pointsGained;
    Floor(int pos){
        this.position = pos;
        this.pointsGained = 0;
    }    
    
    public abstract void updatePlayer(Player a);

    public int getPointsPossible(){
        return this.pointsGained;
    }
}
