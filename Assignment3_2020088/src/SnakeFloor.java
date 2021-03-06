public class SnakeFloor extends Floor{
    SnakeFloor(int p){
        super(p);
        this.pointsGained = -2;
    }
    @Override
    public void updatePlayer(Player a){
        System.out.println("Player position Floor-"+a.getPosition());
        a.addPoints(getPointsPossible());
        System.out.println(a.getName()+" has reached the snake floor");
        System.out.println("Total points = "+ a.getPoints());
        Floor newPos = GameManager.getAllFloors().get(1);
        a.setPosition(1);
        System.out.println();
        newPos.updatePlayer(a);
    }
}
