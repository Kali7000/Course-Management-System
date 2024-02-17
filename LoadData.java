import java.util.ArrayList;
import java.util.HashMap;

public class LoadData{
    
    HashMap<String, User> dict = Main.dict;
    HashMap<String, Course> allCourses = Main.uni;

    LoadData(){
        loadData();
    }

    public void loadData(){

        dict.put("vishal9161", new Admin());


        //add a for loop to take space saparated names and passwords from a file, crete a student and add it to dict
        //add a for loop to take space saparated names and passwords from a file, crete a teacher and add it to dict
        //read course name and code from a file and create courses and assign teacher to each. then add Students to the courses.

    
        Teacher t6 = new Teacher("yuni xia","123456");
        Teacher t7 = new Teacher("ligma lu","123456");
        Teacher t8 = new Teacher("mimi","123456");
        Teacher t9 = new Teacher("Jeffrey Watt","123456");
        Teacher t10 = new Teacher("Jeffrey Watt","123456");

        Course c1 = new Course("Computing II","CSCI2400",t6);
        Course c2 = new Course("Computing I", "CSCI2300",t7);
        Course c3 = new Course("Speech and communication", "COMMR110",t8);
        Course c4 = new Course("Calculus I","MATH1600",t9);
        Course c5 = new Course("Calculus II", "Math1700",t10);
        
        t6.setCourse(c1);
        t7.setCourse(c2);
        t8.setCourse(c3);
        t9.setCourse(c4);
        t10.setCourse(c5);


        Student s1 = new Student("std1", "12345");
        Student s2 = new Student("std2", "12345");
        Student s3 = new Student("std3", "12345");
        Student s4 = new Student("std4", "12345");
        Student s5 = new Student("std5", "12345");

        ArrayList<Student> stds = new ArrayList<Student>();

        stds.add(s1);
        stds.add(s2);
        stds.add(s3);
        stds.add(s4);
        stds.add(s5);

        Course c6 = new Course("Vishal Wagh 101", "VW101",stds);
        Course c7 = new Course("Vishal Wagh 102", "VW102",stds);
        Course c8 = new Course("Vishal Wagh 103", "VW103",stds);
        Course c9 = new Course("Vishal Wagh 104", "VW104",stds);
        Course c10 = new Course("Vishal Wagh 105", "VW105",stds);

    


        Teacher t1 = new Teacher("teacher1","123456",c6);
        Teacher t2 = new Teacher("teacher2","123456",c7);
        Teacher t3 = new Teacher("teacher3","123456",c8);
        Teacher t4 = new Teacher("teacher4","123456",c9);
        Teacher t5 = new Teacher("teacher5","123456",c10);

        c6.setTeacher(t1);
        c7.setTeacher(t2);
        c8.setTeacher(t3);
        c9.setTeacher(t4);
        c10.setTeacher(t5);
        
        dict.put(t1.getUsername(), t1);
        dict.put(t2.getUsername(), t2);
        dict.put(t3.getUsername(), t3);
        dict.put(t4.getUsername(), t4);
        dict.put(t5.getUsername(), t5);
        dict.put(t6.getUsername(), t6);
        dict.put(t7.getUsername(), t7);
        dict.put(t8.getUsername(), t8);
        dict.put(t9.getUsername(), t9);
        dict.put(t10.getUsername(), t10);

        dict.put(s1.getUsername(), s1);
        dict.put(s2.getUsername(), s2);
        dict.put(s3.getUsername(), s3);
        dict.put(s4.getUsername(), s4);
        dict.put(s5.getUsername(), s5);
        
        
        allCourses.put(c1.getCode(), c1);
        allCourses.put(c2.getCode(), c2);
        allCourses.put(c3.getCode(), c3);
        allCourses.put(c4.getCode(), c4);
        allCourses.put(c5.getCode(), c5);
        allCourses.put(c6.getCode(), c6);
        allCourses.put(c7.getCode(), c7);
        allCourses.put(c8.getCode(), c8);
        allCourses.put(c9.getCode(), c8);
        allCourses.put(c10.getCode(), c10);


    }


}
