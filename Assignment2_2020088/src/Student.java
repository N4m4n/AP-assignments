public class Student implements User {
    private String name;
    public Student(String name){
        this.name = name;
    }

    @Override
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

    @Override
    public void viewCommentSection() {
        Data.viewComments(this);
        
    }
    @Override
    public void viewAssessments() {
        Data.displayAssessments();
        
    } 
    
}
