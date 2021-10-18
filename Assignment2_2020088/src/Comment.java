public class Comment {
    String comment;
    String uploadTime;
    User commenter;
    public Comment(User commenter, String comment){
        this.comment = comment;
        this.commenter = commenter;
        java.util.Date date=new java.util.Date();  
        this.uploadTime = date.toString(); 
    }

    public String getComment(){
        return this.comment;
    }
    public String getUploadTime(){
        return this.uploadTime;
    }
    public User getCommenter(){
        return this.commenter;
    }
    
}
