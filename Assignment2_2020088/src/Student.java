import java.util.ArrayList;
import java.io.*;
public class Student implements User {
    private String name;
    private ArrayList<Assessment> submitted = new ArrayList<Assessment>();
    public Student(String name){
        this.name = name;
    }
    public ArrayList<Assessment> getSubmitted(){
        return this.submitted;
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

    @Override
    public void manageSubmission(int num) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        if(num==0){
            System.out.println("Pending assessments: ");
            ArrayList<Assessment> pending = new ArrayList<Assessment>();
            ArrayList<Integer> assmntID = new ArrayList<Integer>();
            for(int i = 0; i < Data.getAssessments().size(); i++) {
                if(!(this.isPresent(Data.getAssessments().get(i)))){
                    if(Data.getAssessments().get(i).getIfOpen()){
                        pending.add(Data.getAssessments().get(i));
                        assmntID.add(i);
                    }
                }
            }
            if(pending.size()==0){
                System.out.println("Woohoo! No open pending assignments right now");
                return;
            }
            for(int i = 0; i < pending.size(); i++) {
                if(pending.get(i).isAsgn()){
                    System.out.println("ID: "+assmntID.get(i)+" Assignment: "+pending.get(i).getProbStatement()+" Max Marks: "+pending.get(i).getMaxMarks());
                }else{
                    System.out.println("ID: "+assmntID.get(i)+" "+pending.get(i).getProbStatement());
                }      
            }
            System.out.print("Enter the ID: ");
            int choice = Integer.parseInt(reader.readLine());
            if((choice>=Data.getAssessments().size())||(Data.getAssessments().get(choice).getIfOpen()==false)){
                System.out.println("invalid id");
                return;
            }
            if(isPresent(Data.getAssessments().get(choice))){
                System.out.println("This assignment already submitted");
                return;
            }
            Assessment toSubmit = Data.getAssessments().get(choice);
            if(toSubmit.isAsgn()){
                System.out.print("Enter the filename to submit: ");
            }else{
                System.out.print("Enter your ans: ");
            }
            
            String ans = reader.readLine();
            if(toSubmit.isAsgn()){ 
                if(!(ans.substring(ans.length()-4).equals(".zip"))){
                    System.out.println("Assignment submissions should be in .zip format");
                    return;
                }
            }

            Submission sb = new Submission(this, ans, toSubmit);
            Data.addSubmission(sb);
            this.submitted.add(toSubmit);




        }else if(num==1){


        }
        
    }
    
    public boolean isPresent(Assessment a) {
        for(int i = 0; i < this.submitted.size(); i++) {
            if(a.equals(this.submitted.get(i))){
                return true;
            }
        }
        return false;
    }
    
}
