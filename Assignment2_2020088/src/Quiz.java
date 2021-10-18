public class Quiz implements Assessment {
    private String probStatement;
    private int maxMarks;
    private Instructor uploader;
    private Instructor closedBy;
    public Quiz(String probStatement, int maxMarks, Instructor uploader) {
        this.probStatement = probStatement;
        this.maxMarks = maxMarks;
        this.uploader = uploader;
        this.isOpen = true;
    }

    public Instructor getClosedBy(){
        return this.closedBy;
    }
    private boolean isOpen;

    
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
    public String getProbStatement() {
        return probStatement;
    }

    @Override
    public void appndAssessments() {
        Data.addAssessment(this);
        
    }

    @Override
    public boolean isAsgn() {
        return false;
    }

    @Override
    public void close(Instructor u1){
        this.closedBy = u1;
        this.isOpen = false;

    }
    
}
