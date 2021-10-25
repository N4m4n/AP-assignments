public class LadderFloor extends Floor {
    LadderFloor(int p){
        super(p);
        this.pointsGained = 2;
    }


    @Override
    public void updatePlayer(Player a){
        System.out.println("Player position Floor-"+a.getPosition());
        a.addPoints(2);
        System.out.println(a.getName()+" has reached the ladder floor");
        System.out.println("Total points = "+ a.getPoints());
        Floor newPos = GameManager.getAllFloors().get(12);
        a.setPosition(12);
        System.out.println();
        newPos.updatePlayer(a);
    }
    
}
