public class EmptyFloor extends Floor {
    EmptyFloor(int p){
        super(p);
        this.pointsGained = 1;
    }
    @Override
    public void updatePlayer(Player a){
        System.out.println("Player position Floor-"+a.getPosition());
        a.addPoints(getPointsPossible());
        System.out.println(a.getName()+" has reached an empty floor");
        System.out.println("Total points = "+ a.getPoints());
    }
}
