import java.util.*;

public class Student extends User{

    public Scanner scan  = new Scanner(System.in);
    HashMap<String, Course> allCourses = Main.uni; 
    HashMap<String, User> dict = Main.dict;                                                                         
    private HashMap<String, ArrayList<ArrayList<String>>> homeworks;
    private ArrayList<Course> courses;
    private HashMap<String, ArrayList> notes = new HashMap<>(); 

//homeworks =={CourseCode : [[question, dueDate, maxPoints, 0/1, ans], [question2, dueDate, maxPoints, 0/1, ans]], CourseCode1 : [[question, dueDate, maxPoints, 0/1, ans],[[question2, dueDate, maxPoints, 0/1, ans]]]}

    public Student(){
        super();
        courses = new ArrayList<Course>();
        homeworks = new HashMap<>();
    }
    public Student(String username, String pass){
        super(username, pass);
        courses = new ArrayList<Course>();
        homeworks = new HashMap<>();

    }
    public Student(String username, String pass, ArrayList<Course> courses){
        super(username, pass);
        this.courses = courses;
        homeworks = new HashMap<>();

    }


    public ArrayList getHomework(String courseCode){
        return homeworks.get(courseCode);
    }
    public void enroll(Course cs){
        courses.add(cs);
    }

    public void login(){

        while (true){
            System.out.println("Welcome to your Dashbord "+ this.username + "\n1) View Courses \n2) Edit enrollment \n3) Email \n4) Exit"); 
            
             System.out.print("Enter: ");
                int num = scan.nextInt();
                scan.nextLine();
                
                if (num == 1){
                    viewCourses();
                    
                }
                else if (num == 2){
                    editEnrollements();

                }else if (num == 3){
                    super.email();

                }else if (num == 4){
                    System.out.println("Not so sorry to see you go...Get out!!!");
                    break;
                }
                else{
                    System.out.println("Invalid input, try again your options are-------> ");
                    System.out.println();
                }
        }  
    }


    public void viewCourses(){

        while(true){
            try{
                int n = 1;
                for (Course i : courses){
                    System.out.println(n+") "+i.getCode()+" "+i.getName());
                    ++n;
                }
                System.out.print("\nEnter course index to view the course (0 to Exit): ");
                int num = scan.nextInt();
                scan.nextLine();
                if (num == 0){
                    break;
                }
                else if (num>courses.size() || num < 0){
                    System.out.println("Ohhh! ohh, slow down. You're not enrolled in that many courses little buddy. \n Don't think too much of yourself, try a smaller number but not a zero or less");
                }else{
                    Course course = courses.get(num-1);

                    while (true){

                        try {
                            System.out.println("\n Welcome to "+course.getCode()+" \n 1) Assignemts \n 2) Notes \n 3) View People \n 4) View Grades\n 5) Exit");
                            System.out.print("Your input is my command: ");
                            int num1 = scan.nextInt();
                            scan.nextLine();
                            
                            if (num1 ==1 ){
                                ArrayList<ArrayList<String>> homework = new ArrayList<ArrayList<String>>();
                                homework = (ArrayList<ArrayList<String>>) (course.getAssignments()).clone();
                                ArrayList<ArrayList<String>> oldHomework;
                                if (homeworks.containsKey(course.getCode())){
                                    oldHomework = homeworks.get(course.getCode());
                                    int c = 0;
                                    for (ArrayList<String> arrayList : homework) {
                                        if ((arrayList.get(3)).equals("0")){
                                            (arrayList).set(3,"0");
                                        }
                                        c+=1;
                                }

                                }else{
                                    oldHomework = homework;
                                    homeworks.put(course.getCode(), oldHomework);
                                }

                                

                                System.out.println("\nEnter 1 to Solve, 2 to Skip, & 3 to Quit\n");
                                int b = 0;
                                for (ArrayList j : oldHomework){           //ArrayList<> or just ArrayList?
                                    try {
                                    
                                        if ((j.get(3)).equals("1")){
                                            System.out.println("\n(Due Date: "+j.get(1)+"  Points: "+j.get(2)+")\n"+j.get(0));
                                            
                                            if (j.size() == 5){
                                                
                                                System.out.println("Old Answer: "+j.get(4));
                                                System.out.println("\nAlready Answered!! Want to Resubmit? (y/Y for Yes)");
                                                String reDo  = scan.nextLine();
                                                if (reDo.equals("y") || reDo.equals("Y")) {
                                                    System.out.print("Enter your Answer: ");
                                                    String ans = scan.nextLine();
                                                    (oldHomework.get(b)).set(4, ans); //answer is at the index 4 
                                                }
                                                System.out.println("Moving on!!");

                                            }else{ 
                                                   
                                                System.out.print("Solve(1) Skip(2) Quit(3) \nYour input is my command: ");
                                                int num2 = scan.nextInt();
                                                scan.nextLine();

                                                if (num2 == 1){
                                                    
                                                    System.out.print("Enter your Answer: ");
                                                    String ans = scan.nextLine();
                                                    (oldHomework.get(b)).add(ans); //answer is at the index 4 
                                                    
                                                }else if(num2 == 2){
                                                    //Eat Five-Star. Do nothing!
                                                }else if (num2 == 3){

                                                    break;
                                                }else{
                                                    System.out.println("Error: Invalid Input, Moving on!");
                                                }

                                            }
                                        }
                                        b+=1;    
                                    } catch (Exception e) {
                                        System.out.println("Error: Wrong input type, we only accepts integers!");
                                    }

                                }

                                
                            }else if (num1 == 2){

                                if (notes.containsKey(course.getCode())){
                                    System.out.println("List of your Notes: ");
                                    int noteIdx = 1;
                                    ArrayList<String> note1 = notes.get(course.getCode());
                                    for (String note : note1) {
                                        System.out.println(noteIdx+") "+note);
                                    }
                                    
                                    while (true){
                                        try {
                                            System.out.println("1) Remove Note  2) Add Note  3) Edit Note 4) Exit ");
                                            System.out.print("Your input is my command: ");
                                            int num3 = scan.nextInt();
                                            scan.nextLine();
                                            if (num3==1){
                                                try {
                                                    System.out.print("Enter note index to remove: ");
                                                    int idx = scan.nextInt();
                                                    scan.nextLine();
                                                    if (idx > (notes.get(course.getCode())).size() || idx < 1 ){
                                                        System.out.println("Error: No note at such index");
                                                    }else{
                                                        (notes.get(course.getCode())).remove(idx-1);
                                                    }
                                                    
                                                } catch (Exception e) {
                                                    System.out.println("Error: Wrong type of Input, try Again!");
                                                }

                                                

                                            }else if (num3==2) {
                                                System.out.print("Enter the note: ");
                                                String not = scan.nextLine();
                                                (notes.get(course.getCode())).add(not);
                                                System.out.println("Success: Note Added!");
                                                
                                            } else if (num3 == 3) {
                                                
                                                try {
                                                    System.out.print("Enter note index to Edit: ");
                                                    int idx1 = scan.nextInt();
                                                    scan.nextLine();
                                                    if (idx1 > (notes.get(course.getCode())).size() || idx1 < 1 ){
                                                        System.out.println("Error: No note at such index");
                                                    }else{
                                                        
                                                        System.out.println("Copy this note to Edit and enter updated note "+(notes.get(course.getCode())).get(idx1-1));
                                                        System.out.print("Enter the new note: ");
                                                        String not = scan.nextLine();
                                                        (notes.get(course.getCode())).set(idx1-1,not);
                                                        System.out.println("Success: Note Updated!");
                                                    }
                                                    
                                                } catch (Exception e) {
                                                    
                                                    System.out.println("Error: Wrong type of Input, try Again!");
                                                }


                                            }else {
                                                System.out.println("\nExiting Notes!");
                                                break;
                                            }

                                        } catch (Exception e) {
                                            
                                            System.out.println("Error: Wrong type of Input, try Again!");
                                        }

                                    }


                                }else{
                                    System.out.println("There are no Notes to show!");

                                        try {
                                            System.out.println("1) Add Note  2) Exit ");
                                            System.out.print("Your input is my command: ");
                                            int num3 = scan.nextInt();
                                            scan.nextLine();
                                            if (num3==1){
                                                System.out.print("Enter the note: ");
                                                String not = scan.nextLine();
                                                ArrayList<String> notesArr = new ArrayList<>();
                                                notesArr.add(not);
                                                notes.put(course.getCode(), notesArr);
                                                System.out.println("Added!! \n");
                                                break;
                                            } else {
                                                System.out.println("Leaving Notes!");
                                                break;
                                            }

                                        } catch (Exception e) {
                                            
                                            System.out.println("Error: Wrong type of Input, try Again!");
                                        }


                                }
                                
                            }else if (num1 == 3) {
                                int stdIdx = 0;
                                for (Student student : course.getEnrollements()) {
                                    stdIdx+=1;
                                    System.out.println(stdIdx+") "+student.getUsername());
                                }
                                
                                
                            }else if (num1 == 4) {//grades
                                System.out.println("You will only see grades of graded assignmetns: ");
                                int idx2 = 0;
                                for (ArrayList<String> homework : homeworks.get(course.getCode())) {
                                    if (homework.size() == 6){
                                        System.out.println("Your grades for assignment "+idx2+") \n"+homework.get(0)+" are "+homework.get(5)+" out of "+homework.get(2)+") ");
                                    }else{
                                        System.out.println("Assignmet "+(idx2+1)+" is not graded yet!");
                                    }
                                idx2+=1;
                                }
                                
                                
                                
                            }else if (num1 == 5) {
                                System.out.println("Signing Out...");
                                break;
                            }else {
                                System.out.println("Ohhh! No No No! You don't have any other choices, Work with what you have");

                            }
                        } catch (Exception e) {
                            System.out.println("Error: You can only enter integers!!");
                        }
                    }

                }
            } catch (Exception e){
                System.out.println("Error: Invalid input, Try Again!");
            }
        }

    }
    
    public void editEnrollements(){

        try {

        System.out.println("\nWhat do want now!!!\n 1) Enroll in a New Course \n 2) Drop Out");
        int num5  = scan.nextInt();
        scan.nextLine();
        
        if(num5==1){
            int n2 = 1;
            System.out.println("List of courses: ");
            
            for (Course i : allCourses.values()){
                System.out.println(n2+") ["+i.getCode()+"]  "+i.getName());
                ++n2;
            }

            
            System.out.print("Enter the Course Code: ");
            String courseCode = scan.nextLine();
            if (allCourses.containsKey(courseCode)){
                User tempStd = dict.get(username);
                Student newStudent = (Student) tempStd;
                (allCourses.get(courseCode)).enroll(newStudent);//how do I add this student to the course and check if student is alredy enrolled
                courses.add(allCourses.get(courseCode));
                System.out.println("Course Added!!");
            }else{
                System.out.println("There is no such course with Code Code : "+courseCode);
            }

        }
        else if (num5 == 2) {

            try {

                    System.out.println("The Courses you are enrolled in are: ");
                    int n1 = 1;
                    for (Course i : courses){
                        System.out.println(n1+") "+i.getCode()+" "+i.getName());
                        ++n1;
                    } 
                    
                    System.out.print("Enter the index of the course you want to drop out of: ");
                    int cIdx = scan.nextInt();
                    scan.nextLine();
                    if(cIdx<=courses.size() && cIdx>0){
                        courses.remove(cIdx-1);
                        System.out.println(" Dropped Out!!!");
                    }else{
                        System.out.println("There is no course at such index");
                    }
                

                } catch (Exception e) {
                    System.out.println("Error: Wrong type of input");
                }


            }else{
                System.out.println("Error: Wrong Input, try Again!");
            }

        } catch (Exception e) {
            System.out.println("Error: Wrong type of input");
        }


    }


}
