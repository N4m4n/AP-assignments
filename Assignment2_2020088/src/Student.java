public class Student implements User {
    private String name;
    public Student(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public void viewMaterials() {
        Data.displayMaterial();        
    }

    @Override
    public void addComment(String s) {
        Data.appendComment(this, s);
        
    }
    
}
