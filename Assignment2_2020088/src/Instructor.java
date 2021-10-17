public class Instructor implements User {
    private String name;
    public Instructor(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }    
}
