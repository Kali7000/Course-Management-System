import java.util.ArrayList;
import java.util.Scanner;

public class Teacher extends User{
    
    public Scanner scan  = new Scanner(System.in);
    private Course course;
    
    public Teacher (){
        super("teacher","sucks");
        course = new Course("Intro to Artificial Intelligence", "AIS1000");
    }

    public Teacher (String name, String password){
        super(name, password);
        course = new Course("Intro to Artificial Intelligence", "AIS1000");
    }
    public Teacher (String name, String password, Course course){
        super(name, password);
        this.course = course;
    }

    public void setCourse(Course course){
        this.course = course;
    }
    public Course getCourse(){
        return this.course;
    }

    public void login(){

        while (true) {
            
            try {

                System.out.println("Welcome to your class, Mr/Ms "+getUsername()+ "\n 1)Create Assignments \n 2)Remove Assignments \n 3)Grade Assignments \n 4)View People \n 5)Remove Student \n 6)Email \n 7)Exit"); //\n6)Add Student \n7) Ban Student
                System.out.print("Your input is my command: ");
                int responce = scan.nextInt();
                scan.nextLine();
                if (responce == 1) {
                    this.course.createAssignment();
                    
                }else if (responce == 2) {
                    this.course.removeAssignement();

                }else if (responce == 3) {
                    grade();

                }else if (responce == 4) {
                    int idx = 1;
                    for (Student person : (this.course).getEnrollements()) {
                        System.out.println(idx+") "+person.getUsername());
                        idx+=1;
                    }
                    
                }else if (responce == 5) { // )Add Student \n7) Ban
                    removeStudent();
                    
                    
                }else if (responce == 6){
                    super.email();
                    
                }else if (responce == 7) {
                    System.out.println("Signing out...");
                    //save
                    break;  
                }else{
                    System.out.println("There is no such option, try again!");
                }
                


            } catch (Exception e) {
                    System.out.println("Error: Wrong type of Input, Try Again!");
            }
        }
    }  
    
    public void grade(){
        
        while (true){

            try {                    
                System.out.print("1) To search student \n2) Exit \n  Enter:");
                int num = scan.nextInt();
                scan.nextLine();
                if (num == 1){
                    
                    System.out.print("Enter Student Username to grade: ");
                    String name = scan.nextLine();
                    boolean notFound = true;
                    for (Student student : course.getEnrollements()) {
                        if(name.equals(student.getUsername())){
                            ArrayList<ArrayList> homeworks = student.getHomework(course.getCode());
                            System.out.println(name+"'s assigemts --->");
                            for (ArrayList<String> homework : homeworks){
                                
                                if (homework.size()==6){
                                    System.out.println("Assignment already graded \nQ) "+homework.get(0)+" (Max Points)"+homework.get(2)+"\n Ans: "+homework.get(4)+"\n Grades: "+homework.get(5));
                                    System.out.println("Enter (y/Y) to regrade ");
                                    String resp = scan.nextLine();
                                    if(resp.equals("y") || resp.equals("Y")){

                                        while(true){
                                            try {
                                                System.out.print("Enter Grades: ");
                                                double grade = scan.nextDouble();
                                                homework.set(5, String.valueOf(grade));
                                                System.out.println("Success: Grades Updated");
                                                break;
                                            } catch (Exception e) {
                                                System.out.println("Error: Wrong type of Input, try Again!");
                                            }
                                        }

                                    }else{
                                        System.out.println("Moving On!");
                                    }
                                }else{
                                
                                    System.out.println("Q) "+homework.get(0)+" (Max Points)"+homework.get(2)+"\n Ans: "+homework.get(4));

                                    while(true){
                                        try {
                                            System.out.print("Enter Grades: ");
                                            double grade = scan.nextDouble();
                                            homework.add(String.valueOf(grade));
                                            System.out.println("Success: Grades Added");
                                            break;
                                        } catch (Exception e) {
                                            System.out.println("Error: Wrong type of Input, try Again!");
                                        }

                                    }
                                }   
                            }

                            notFound = false;
                            break;
                        }
                    }
                    if(notFound){
                    System.out.println("There is no student with UserName: "+name);
                    }

                }else{
                    System.out.println("Exit");
                    break;
                }
            } catch (Exception e) {
                System.out.println("Error: We only accept Integers loop terminated!!!");
                break;
            }
                    
        }


    }



    public void removeStudent(){

        System.out.print("Who is the idot you want to remove from class? \nEnter UserName: ");
        String stdName = scan.nextLine();
        int num4 = 0;
        boolean is = true;
        for (Student student : course.getEnrollements()) {

            if(stdName.equals(student.getUsername())){
                (course.getEnrollements()).remove(num4);
                is = false;
                System.out.println("The student has been kicked out!!!");
            }
            num4+=1;
        }
        if (is){
            System.out.println("There is no student with Username: "+stdName);
        }
        
    }
 

}
