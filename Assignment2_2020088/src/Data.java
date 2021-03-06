import java.util.ArrayList;

public class Data {
    private static ArrayList<Student> allStudents = new ArrayList<>();
    private static ArrayList<Instructor> allInstructors = new ArrayList<>();
    private static ArrayList<Slides> allSlides = new ArrayList<>();
    private static ArrayList<Video> allVideos = new ArrayList<>();
    private static ArrayList<Comment> allComments = new ArrayList<>();
    private static ArrayList<Assessment> allAssessments = new ArrayList<>();
    private static ArrayList<Submission> allSubmissions = new ArrayList<>();
    public static void addStudent(Student student) {
        allStudents.add(student);
    }
    public static void addInstructor(Instructor instructor) {
        allInstructors.add(instructor);
    }
    public static void addSlides(Slides slides) {
        allSlides.add(slides);
    }
    public static void addVideo(Video video) {
        allVideos.add(video);
    }
    public static void addAssessment(Assessment assessment) {
        allAssessments.add(assessment);
    }
    public static void addSubmission(Submission submission) {
        allSubmissions.add(submission);
    }

    public static  ArrayList<Instructor> getInstructors(){
        return allInstructors;
    }
    public static ArrayList<Student> getStudents(){
        return allStudents;
    }
    public static ArrayList<Slides> getSlides(){
        return allSlides;
    }
    public static ArrayList<Video> getVideos(){
        return allVideos;
    }
    public static ArrayList<Comment> getComments(){
        return allComments;
    }
    public static ArrayList<Assessment> getAssessments(){
        return allAssessments;
    }
    public static ArrayList<Submission> getSubmissions(){
        return allSubmissions;
    }


    public static void displaySubmissions(){
        for(int i = 0; i < allSubmissions.size(); i++){
            System.out.println("Name: "+allSubmissions.get(i).getStudent().getName()+" \nSubmission for : "+allSubmissions.get(i).getAssessment().getProbStatement()+"\nSubmission: "+allSubmissions.get(i).getAns());
        }
    }

    public static void displayAssessments(){
        System.out.println("------------------------------------------------------");
        System.out.println("List of all assessments:");
        System.out.println("------------------------------------------------------");
        if(allAssessments.size()==0){
            System.out.println("Woohoo! No assignments right now! Check back later for new assignments");
        }
        for(int i = 0; i < allAssessments.size(); i++){
            if(Data.getAssessments().get(i).getIfOpen()){
                
                if(Data.getAssessments().get(i).isAsgn()){
                    System.out.println("ID: "+i+ " Assignment: "+Data.getAssessments().get(i).getProbStatement()+" Max Marks: "+ Data.getAssessments().get(i).getMaxMarks());
                }else{
                    System.out.println("ID: "+i+ " Question: "+Data.getAssessments().get(i).getProbStatement());
                }
                System.out.println("Status : Open");
            }else{
                if(Data.getAssessments().get(i).isAsgn()){
                    System.out.println("ID: "+i+ " Assignment: "+Data.getAssessments().get(i).getProbStatement()+" Max Marks: "+ Data.getAssessments().get(i).getMaxMarks());
                }else{
                    System.out.println("ID: "+i+ " Question: "+Data.getAssessments().get(i).getProbStatement());
                }
                System.out.println("Status : Closed by "+Data.getAssessments().get(i).getClosedBy().getName());

            }
            System.out.println("-----------------------");
        }
        

    }

    public static void displayMaterial(){
        System.out.println("------------------------------------------------------");
        System.out.println("Videos:");
        System.out.println("------------------------------------------------------");
        for(int i = 0; i < allVideos.size(); i++){
            Video temp = allVideos.get(i);
            System.out.println("Topic of Video: "+temp.getTopic());
            System.out.println("Video File: "+temp.getFileName());
            System.out.println("Uploaded by: "+temp.getUploader().getName());
            System.out.println("Date of upload: "+temp.getTimeOfUpload());
            System.out.println();
        }
        System.out.println("------------------------------------------------------");
        System.out.println("Lectures:");
        System.out.println("------------------------------------------------------");
        for(int i = 0; i < allSlides.size(); i++){

            Slides temp = allSlides.get(i);
            System.out.println("Topic: "+temp.getTopic());
            String arr[] = temp.getContent();
            System.out.println();
            for(int j = 0; j < arr.length; j++){
                System.out.print("Slide "+(j+1)+": ");
                System.out.println(arr[j]);
            }
            System.out.println();
            System.out.println("Uploaded by: "+temp.getUploader().getName());
            System.out.println("Date of upload: "+temp.getTimeOfUpload());
            System.out.println();

        }
    }

    public static void displayMaterial(Instructor u1){
        System.out.println("------------------------------------------------------");
        System.out.println("Videos:");
        System.out.println("------------------------------------------------------");
        for(int i = 0; i < allVideos.size(); i++){
            Video temp = allVideos.get(i);
            System.out.println("Title of Video: "+temp.getTopic());
            System.out.println("Video File: "+temp.getFileName());
            if(temp.getUploader().equals(u1)){
                System.out.println("Uploaded by: Me ");
            }else{
                System.out.println("Uploaded by: "+temp.getUploader().getName());
            }
            
            System.out.println("Date of upload "+temp.getTimeOfUpload());
            System.out.println();
        }
        System.out.println("------------------------------------------------------");
        System.out.println("Lectures:");
        System.out.println("------------------------------------------------------");
        for(int i = 0; i < allSlides.size(); i++){

            Slides temp = allSlides.get(i);
            System.out.println("Title: "+temp.getTopic());
            String arr[] = temp.getContent();
            System.out.println();
            for(int j = 0; j < arr.length; j++){
                System.out.print("Slide "+(j+1)+": ");
                System.out.println(arr[j]);
            }
            System.out.println();
            if(temp.getUploader().equals(u1)){
                System.out.println("Uploaded by: Me");
            }else{
                System.out.println("Uploaded by: "+temp.getUploader().getName());
            }
            System.out.println("Date of upload "+temp.getTimeOfUpload());
            System.out.println();

        }
    }

    public static void appendComment(User u1, String s){
        Comment toAdd = new Comment(u1, s);
        allComments.add(toAdd);
    }


    public static void viewComments(User u1){
        System.out.println("--------------------------------------------------------");
        System.out.println("Comments:");
        if(allComments.size()==0){
            System.out.println("No comments till now");
            
        }
        for(int i = 0; i < allComments.size(); i++){
            Comment temp = allComments.get(i);
            System.out.println("--------------------------------------------------------");
            System.out.println(temp.getComment());
            if(u1.equals(temp.getCommenter())){
                System.out.println("Commented By: Me on "+ temp.getUploadTime());
            }else{
                System.out.println("Commented By: "+temp.getCommenter().getName()+" on "+ temp.getUploadTime());
            }


        }
        System.out.println("--------------------------------------------------------");
    }
}
