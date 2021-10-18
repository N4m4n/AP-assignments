
public class Slides implements Material {
    private String topic;
    private int noOfSlides;
    private String[] content;
    private User addedBy;
    private String timeOfUpload;
    public Slides(String t, int n, String[] content, User uploader){
        this.topic = t;
        this.noOfSlides = n;
        this.content = content;
        this.addedBy = uploader;
        java.util.Date date=new java.util.Date();  
        this.timeOfUpload = date.toString(); 
    }

    @Override
    public void addMaterial() {
        Data.addSlides(this);
        System.out.println("Slides added");
    }

    public String getTopic(){
        return this.topic;
    }
    public int getNoOfSlides(){
        return this.noOfSlides;
    }
    public String[] getContent(){
        return this.content;
    }
    public User getUploader(){
        return this.addedBy;
    }
    public String getTimeOfUpload(){
        return this.timeOfUpload;
    }
    
}
