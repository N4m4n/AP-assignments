public class KingCobraFloor extends SnakeFloor {
    KingCobraFloor(int p){
        super(p);
        this.pointsGained = -4;
    }
    @Override
    public void updatePlayer(Player a){
        System.out.println("Player position Floor-"+a.getPosition());
        a.addPoints(getPointsPossible());
        System.out.println(a.getName()+" has reached the King Cobra floor");
        System.out.println("Total points = "+ a.getPoints());
        Floor newPos = GameManager.getAllFloors().get(3);
        a.setPosition(3);
        System.out.println();
        newPos.updatePlayer(a);
    }
    
}
