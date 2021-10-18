public class Video implements Material {
    private String topic;
    private String filename;
    private User uploader;
    private String timeOfUpload;
    public Video(String t, String file, User uploader) {
        this.topic = t;
        this.filename = file;
        this.uploader = uploader;
        java.util.Date date=new java.util.Date();  
        this.timeOfUpload = date.toString(); 
    }
    @Override
    public void addMaterial() {
        Data.addVideo(this);
        
    }

    public String getTopic(){
        return this.topic;
    }
    public String getFileName(){
        return this.filename;
    } 
    public User getUser(){
        return this.uploader;
    }
    public String getUploadtime(){
        return this.timeOfUpload;
    }
    
}
