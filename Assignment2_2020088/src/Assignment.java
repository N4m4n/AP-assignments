public class Assignment implements Assessment {
    private String probStatement;
    private int maxMarks;
    private Instructor uploader;
    private boolean isOpen;
    private Instructor closedBy;

    public Assignment(String probStatement, int maxMarks, Instructor uploader) {
        this.probStatement = probStatement;
        this.maxMarks = maxMarks;
        this.uploader = uploader;
        this.isOpen = true;
    }

    public Instructor getClosedBy(){
        return this.closedBy;
    }
    
    public int getMaxMarks() {
        return maxMarks;
    }
    public Instructor getUploader() {
        return uploader;
    }
    public boolean getIfOpen(){
        return isOpen;
    }
    @Override
    public void appndAssessments() {
        Data.addAssessment(this);
        
    }
    @Override
    public String getProbStatement() {
        return probStatement;
    }

    @Override
    public boolean isAsgn() {
        return true;
    }
    @Override
    public void close(Instructor u1){
        this.closedBy = u1;
        this.isOpen = false;

    }

}
