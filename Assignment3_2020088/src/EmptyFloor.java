public class EmptyFloor extends Floor {
    private int pointsObt;
    EmptyFloor(){
        pointsObt = 1;
    }
    public int getPointsScored(){
        return this.pointsObt;
    }
    public void applyChanges(Player p){
        p.addPoints(1);
        //Dice has to be used here
        p.changePos(p.getPosition()+1);
    }
}
