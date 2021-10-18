import java.io.*;
public interface User {
    public void viewMaterials();
    public void addComment(String s);
    public void viewCommentSection();
    public String getName();
    public void viewAssessments();
    public void manageSubmission(int num) throws IOException;
}
