public class Toy implements Cloneable {
    private String name;
    private boolean hasQues;
    public Toy(String name) {
        this.name = name;
        this.hasQues = false;
    }

    public Toy(String name, boolean a) {
        this.name = name;
        this.hasQues = a;
    }
    
    @Override
    public Toy clone(){
        try{
            Toy newclone = (Toy) super.clone();
            newclone.name = this.name;
            return newclone;

        }catch(CloneNotSupportedException e){
            System.out.println(e.getMessage()+": cannot clone this toy.");
            return null;
        }
        
        
    }

    public String getName() {
        return this.name;
    }

    public boolean hasques() {
        return this.hasQues;
    }
}
