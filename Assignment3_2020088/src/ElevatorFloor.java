public class ElevatorFloor extends LadderFloor {
    public void updatePlayer(Player a){
        System.out.println("Player position Floor-"+a.getPosition());
        a.addPoints(4);
        System.out.println(a.getName()+" has reached an Elevator floor");
        System.out.println("Total points = "+ a.getPoints());
        Floor newPos = GameManager.getAllFloors().get(10);
        a.setPosition(10);
        System.out.println();
        newPos.updatePlayer(a);
    }
}
