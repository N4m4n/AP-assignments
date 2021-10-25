public class ElevatorFloor extends LadderFloor {
    ElevatorFloor(int p){
        super(p);
        this.pointsGained = 4;
    }
    @Override
    public void updatePlayer(Player a){
        System.out.println("Player position Floor-"+a.getPosition());
        a.addPoints(getPointsPossible());
        System.out.println(a.getName()+" has reached an Elevator floor");
        System.out.println("Total points = "+ a.getPoints());
        Floor newPos = GameManager.getAllFloors().get(10);
        a.setPosition(10);
        System.out.println();
        newPos.updatePlayer(a);
    }
}
