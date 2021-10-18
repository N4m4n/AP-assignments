import java.io.*;
public class Instructor implements User {
    private String name;
    public Instructor(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void addCont() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("1. Add Lecture Slides.");
        System.out.println("2. Add lecture videos.");
        int mType = Integer.parseInt(br.readLine());
        if(mType ==1){
            System.out.print("Enter topic of slides: ");
            String topic = br.readLine();
            System.out.print("Enter no of slides ");
            int n = Integer.parseInt(br.readLine());
            String arr[] = new String[n];
            for(int i = 0; i < n; i++){
                arr[i] = br.readLine();
            }
            Material currSlides = new Slides(topic, n, arr, this);
            currSlides.addMaterial();
            
        }else if(mType ==2){

            System.out.print("Enter topic of video: ");
            String topic = br.readLine();
            System.out.print("Enter the filename for the video: ");
            String vidName = br.readLine();
            if(!(vidName.substring(vidName.length()-4).equals(".mp4"))){
                System.out.println("The video should be .mp4 format. ");
                return;
            }
            Material currVideo = new Video(topic, vidName, this);
            currVideo.addMaterial();           

        }else{
            System.out.println("invalid");
            return;
        }
        
    }    
}
