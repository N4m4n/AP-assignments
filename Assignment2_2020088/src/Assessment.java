public interface Assessment {
    public void appndAssessments();
    public String getProbStatement();
    public int getMaxMarks();
    public boolean isAsgn();
    public boolean getIfOpen();
    public void close(Instructor u);
    public Instructor getClosedBy();
}
