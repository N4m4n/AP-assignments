public class Quiz implements Assessment {
    private String probStatement;
    private int maxMarks;
    private Instructor uploader;
    
    public Quiz(String probStatement, int maxMarks, Instructor uploader) {
        this.probStatement = probStatement;
        this.maxMarks = maxMarks;
        this.uploader = uploader;
        this.isOpen = true;
    }
    private boolean isOpen;

    public String getProbStatement() {
        return probStatement;
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
    
}
