import java.io.*;
public class Instructor implements User {
    private String name;
    public Instructor(String name){
        this.name = name;
    }

    public void closeAssessment() throws Exception{
        System.out.println("List of open assingments: " );
        for(int i = 0;i<Data.getAssessments().size();i++){
            if(Data.getAssessments().get(i).getIfOpen()){
                if(Data.getAssessments().get(i).isAsgn()){
                    System.out.println("ID: "+i+ " Assignment: "+Data.getAssessments().get(i).getProbStatement()+" Max Marks: "+ Data.getAssessments().get(i).getMaxMarks());
                }else{
                    System.out.println("ID: "+i+ " Question: "+Data.getAssessments().get(i).getProbStatement());
                }
            }
            System.out.println("-----------------------");
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter ID to close: ");
        int ID = Integer.parseInt(br.readLine());
        if(Data.getAssessments().size()<=ID){
            System.out.println("Invalid ID.");
            return;
        }
        if(Data.getAssessments().get(ID).getIfOpen()==false){
            System.out.println("Invalid ID or Already closed");
            return;
        }else{
            Data.getAssessments().get(ID).close(this);
        }
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
            System.out.println("Enter the content slide by slide: ");
            String arr[] = new String[n];
            for(int i = 0; i < n; i++){
                System.out.print("Content of slide "+(i+1)+": ");
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

    public void addAssessment() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("1. Add Assignment.");
        System.out.println("2. Add Quiz.");
        int aType = Integer.parseInt(br.readLine());
        if(aType ==1){
            System.out.print("Enter problem statement: ");
            String prob = br.readLine();
            System.out.print("Enter max marks: ");
            int mm = Integer.parseInt(br.readLine());
            Assessment currAssess = new Assignment(prob, mm, this);
            currAssess.appndAssessments();
            
        }else if(aType ==2){

            System.out.print("Enter quiz question: ");
            String ques = br.readLine();
            Assessment currQuiz = new Quiz(ques, 1, this);
            currQuiz.appndAssessments();          

        }else{
            System.out.println("invalid");
            return;
        }
        
    }
    @Override
    public void viewMaterials() {
        Data.displayMaterial(this);
        
    }
    @Override
    public void addComment(String s) {
        Data.appendComment(this, s);
    }
    @Override
    public void viewCommentSection() {
        Data.viewComments(this);
        
    } 
    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public void viewAssessments() {
        Data.displayAssessments();
        
    }

    @Override
    public void manageSubmission(int num) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        this.viewAssessments();
        System.out.print("Enter the assessment ID: ");
        int assID = Integer.parseInt(reader.readLine());
        if(assID<0 || assID>=Data.getAssessments().size()) {
            System.out.println("Invalid ID");
            return;
        }
        Assessment toGrade = Data.getAssessments().get(assID);
        int arr[] = new int[Data.getStudents().size()];
        for(int i= 0;i<arr.length;i++) {
            arr[i] = -1;
        }
        int count = 0;
        for(int i = 0;i<Data.getSubmissions().size();i++) {
            Submission temp = Data.getSubmissions().get(i);
            if(temp.getAssessment().equals(toGrade)){
                if(Data.getSubmissions().get(i).getMarkedBy()==null){
                    count++;
                    Student s = temp.getStudent();
                    int idStu = Data.getStudents().indexOf(s);
                    arr[idStu] = i;
                }

            }
        }
        
        if(count==0){
            System.out.println("No new submission for this assignment yet.");
            return;
        }
        for(int i = 0; i <arr.length; i++){
            if(arr[i]!=-1){
                System.out.println(i+" "+Data.getStudents().get(i).getName());
            }

        }
        int studentToGrade = Integer.parseInt(reader.readLine());
        if(arr[studentToGrade]<0 || studentToGrade>=Data.getStudents().size()){
            System.out.println("This ID has not submitted");
            return;
        }
        Submission submissionToGrade = Data.getSubmissions().get(arr[studentToGrade]);
        System.out.println("Submission:-");
        System.out.println("Sumbmitted: "+submissionToGrade.getAns());
        System.out.println("-----------------------");
        System.out.println("Max marks: "+submissionToGrade.getAssessment().getMaxMarks());
        System.out.print("Marks obtained: ");
        double marksScored = Double.parseDouble(reader.readLine());
        if(marksScored>submissionToGrade.getAssessment().getMaxMarks()){
            System.out.println("Entered marks are greater than max marks Do you wish to cancel?\n1 Yes\n2 No");
            int c = Integer.parseInt(reader.readLine());
            if(c == 1){
                System.out.println("Grade not alloted");
                return;
            }
        }
        submissionToGrade.setMarks(marksScored);
        submissionToGrade.setProf(this);

        

        
    }   
}
