public class Submission {
    private Student student;
    private String ans;
    private Assessment assessment;
    private Instructor markedBy;
    private int marksObtained;
    public Submission(Student st, String ans, Assessment asmnt){
        this.student = st;
        this.ans = ans;
        this.assessment = asmnt;
        this.marksObtained = -1;
    
    }
    public Student getStudent(){
        return this.student;
    }
    public String getAns(){
        return this.ans;
    }
    public Assessment getAssessment(){
        return this.assessment;
    }
    public Instructor getMarkedBy(){
        return this.markedBy;
    }
    public int getMarksObtained(){
        return this.marksObtained;
    }

}
