public class SnakeFloor extends Floor{
    public void updatePlayer(Player a){
        System.out.println("Player position Floor-"+a.getPosition());
        a.addPoints(-2);
        System.out.println(a.getName()+" has reached the snake floor");
        System.out.println("Total points = "+ a.getPoints());
        Floor newPos = GameManager.getAllFloors().get(1);
        a.setPosition(1);
        newPos.updatePlayer(a);
    }
}
