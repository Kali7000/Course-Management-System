import java.util.ArrayList;
import java.util.Scanner;

public class Course{
    public Scanner scan  = new Scanner(System.in);
    private String name;
    private String code;
    private Teacher teacher;
    public ArrayList<Student> enrollements;
    private ArrayList<ArrayList<String>> assignments = new ArrayList<>();

    //Teacher Assignmet = [[question, dueDate, maxPoints, 0/1],[[question2, dueDate, maxPoints, 0/1]]]
    //Student Assignmet = [[question, dueDate, maxPoints, 0/1, ans, grade],[[question2, dueDate, maxPoints, 0/1, ans, grade]]]

    public Course(){
        this.name = "Who is Vishal";
        this.code = "VW101";
        this.enrollements = new ArrayList<>();
        if (assignments.isEmpty()){
            ArrayList<String> ls = new ArrayList<>();
            ls.add("What's your name?");
            ls.add("No due date");
            ls.add("10");
            ls.add("1");
            assignments.add(ls);
        }
    }

    public Course(String name, String code){
        this.name = name;
        this.code = code;
        this.enrollements = new ArrayList<>();
        if (assignments.isEmpty()){
            ArrayList<String> ls = new ArrayList<>();
            ls.add("What's your name?");
            ls.add("No due date");
            ls.add("10");
            ls.add("1");
            assignments.add(ls);
        }

    }

    public Course(String name, String code, ArrayList<Student> enrollemts){
        this.name = name;
        this.code = code;
        this.enrollements = enrollemts;
        makeBalance(enrollemts);
        if (assignments.isEmpty()){
            ArrayList<String> ls = new ArrayList<>();
            ls.add("What's your name?");
            ls.add("No due date");
            ls.add("10");
            ls.add("1");
            assignments.add(ls);
        }


    }
    
    public Course(String name, String code, ArrayList<Student> enrollemts, Teacher teach){
        this.name = name;
        this.code = code;
        this.enrollements = enrollemts;
        this.teacher = teach;
        makeBalance(enrollemts);

        if (assignments.isEmpty()){
            ArrayList<String> ls = new ArrayList<>();
            ls.add("What's your name?");
            ls.add("No due date");
            ls.add("10");
            ls.add("1");
            assignments.add(ls);
        }

    }
    public Course(String name, String code, Teacher teach){
        this.name = name;
        this.code = code;
        this.teacher = teach;
        if (assignments.isEmpty()){
            ArrayList<String> ls = new ArrayList<>();
            ls.add("What's your name?");
            ls.add("No due date");
            ls.add("10");
            ls.add("1");
            assignments.add(ls);
        }

    }

    public String getName(){
        return this.name;
    }
    public String getCode(){
        return this.code;
    }
    public ArrayList<Student> getEnrollements(){
        return this.enrollements;
    }
    public Teacher getTeacher(){
        return this.teacher;
    }
    public ArrayList<ArrayList<String>> getAssignments(){
        return this.assignments;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setCode(String code){
        this.code = code;
    }
    public void setTeacher(Teacher teach){
        this.teacher = teach;
    }
    public void setEnrollements(ArrayList<Student> enrollements){
        this.enrollements = enrollements;
    }
    public void enroll(Student std){
        enrollements.add(std);
    }
    public void addAssignment(ArrayList<String> assignment){
        (this.assignments).add(assignment);
    }

    public void makeBalance(ArrayList<Student> stds){
        for (Student student : stds) {
            student.enroll(this); // How do I add this course itself in student's list
        }
    }


    public void createAssignment(){
        while(true) {
            try {
                System.out.println("1)Create a new Assignment (Enter AnyNumber To Stop)");
                int num = scan.nextInt();
                scan.nextLine();
                if (num == 1){
                    ArrayList<String> newAssignment = new ArrayList<>();
                    System.out.println("Creating a new assignment \nEnter the question: ");
                    String question = scan.nextLine();
                    newAssignment.add(question);
                    System.out.print("Enter Due Date: ");
                    String date = scan.nextLine();
                    newAssignment.add(date);
                    System.out.print("Enter Points: ");
                    String points = scan.nextLine();
                    newAssignment.add(points);
                    newAssignment.add("1");
                    assignments.add(newAssignment);    
                }
                else{
                    break;
                }
   
            } catch (Exception e) {
                System.out.println("Error: Wrong type of input, we only accept Integers, loop terminated good bye");
                break;
            }

        }

    }



    public void removeAssignement(){
        int n = 1;
        for (ArrayList<String> i : assignments){
            System.out.println(n+") "+i.get(n-1)+"  Status: "+i.get(3));
            n+=1;
        }
        while(true){
            try {
                System.out.print("Enter Assignement index to remove (0 to exit): ");
                int num = scan.nextInt();
                scan.nextLine();
                if (num == 0){
                    System.out.println("Sparing students....");
                    break;
                }
                else if (num>assignments.size() || num < 1){
                    System.out.println("Error: There is no assignment at that index");
                }else{
                    (assignments.get(n-1)).set(3,"0");
                }
            } catch (Exception e) {
                System.out.println("Error: Wrong type of input, loop terminated!!!!!");
                break;
            }

        }


    }



}

