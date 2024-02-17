import java.util.*;

public class Admin extends User{

    public Scanner scan  = new Scanner(System.in);
    HashMap<String, User> dict = Main.dict;
    HashMap<String, Course> uni = Main.uni;
    //ArrayList<Students> enrollements = Course.enrollements;
    
    public Admin(){
        super("vishal9161","9161");
    }
    public Admin(String name, String pass){
        super(name, pass);

    }
    
    public void login(){

        while (true) {

            try {
                
                System.out.println(" 1- Add Account"+
                "\n 2- Remove Account\n 3- Create Courses\n"+
                " 4- Remove courses\n 5- Manage users account info \n 6- Email \n 7- Logout");

                System.out.print("Enter: ");
                int num = scan.nextInt();
                scan.nextLine();
                if (num == 1){
                    addAccount();
                }
                
                else if (num == 2){
                    removeAccount();
                }
                
                else if (num == 3){
                    newCourse();
                    
                }else if (num ==4){
                    removeCourse();
                }else if (num ==5){
                    userInfo();

                }else if (num == 6){
                    super.email();
                    
                }else if(num == 7){
                    break;
                }

            } catch (Exception e) {
                System.out.println("Error: Wrong type of inout");
            }

        }

    }




    public void addAccount(){
        System.out.println("1) Student account \n2) Techer Account");
        System.out.print("Enter: ");
        int num = scan.nextInt();
        scan.nextLine();
        if (num == 1){
            newAccount(1);   
        }

        else if(num == 2){
            newAccount(2);
        }

    }


    public void removeAccount(){

        while(true){
            System.out.print("Enter Username to remove:");
            String newUsername = scan.nextLine();
            if (dict.containsKey(newUsername)){
                System.out.println("This username exists in the system!! Enter Admin password to remove");
                System.out.print("Enter Password:");
                String inputPassword = scan.nextLine();
                if (inputPassword.equals((dict.get(getUsername())).getPassword())){
                    dict.remove(newUsername);
                    System.out.println("Sucess: User removed");
                    break;
                }else{
                    System.out.println("Wrong Password ------) try Again");
                    System.out.println();
                }
            }
            else{
                System.out.println("Error: This username doesn't exist");
                break;
            }
        }

    }
    

    public void newAccount(int key){
        while(true){
            System.out.print("Enter New Username: ");
            String newUsername = scan.nextLine();
            
            if (dict.containsKey(newUsername)){
                System.out.println("The username already exists!! Try a different one");
            }
            else{
                while (true){
                    System.out.print("Create Password: ");
                    String newPassword = scan.nextLine();
                    if (newPassword.length()>12){
                        System.out.println("Error: the password is too long try again!");
                    }else if (newPassword.length()<6){
                        System.out.println("Error: the password is too short try again!");
                    }else{
                        if (key == 1){
                            dict.put(newUsername, new Student(newUsername, newPassword)); 
                            System.out.println("New Student -"+newUsername+"- added!!");
                        }else if (key == 2){
                            dict.put(newUsername, new Teacher(newUsername, newPassword)); 
                            System.out.println("New Teacher -"+newUsername+"- added!!");
                        }
                        
                        break;
                    }
                }
                break;
            }   
        }
    }


    public void newCourse(){
        
        //ArrayList<User> temp = new ArrayList<>();
        while (true){
            System.out.print("Enter new course Code:");
            String newCode = scan.nextLine();
            if (uni.containsKey(newCode)){
                System.out.println("Error: This course already exits \nTry Again!");

            }else{
                
                if (newCode.length()>10){
                    System.out.println("Error: Code cannot be more than 10 charactors long");
                }else{
                    System.out.print("Enter Course Name: ");
                    String newCourseName = scan.nextLine();
                    Course tempCourse = new Course(newCourseName,newCode);
                    System.out.print("Course Created!!!");
                        uni.put(newCode, tempCourse); //Course is saved by code name, key of the dict is code
                        break;

                    /**
                    System.out.print("Want to add more students to the course? (y=Yes, anyKey=No)");
                   String ans1 = scan.nextLine();
                    if ((ans1.equals("y")) || (ans1.equals("Y"))) {
                        System.out.print("Enter Student's username:");
                        String newUsername = scan.nextLine();
                        if (dict.containsKey(newUsername)){
                            temp.add(dict.get(newUsername));

                            //if students already enrolled

                        }
                        else{
                            System.out.println("Error: Username does not exitst");
                        }

                    }
                    else{
                        Course tempCourse = new Course(newCourse,newCode, );
                        uni.put(newCode, tempCourse); //Course is saved by code name, key of the dict is code
                        break;
                    } */
                }   

            }
        }

    }

    public void removeCourse(){
        
        while(true){
            System.out.print("Enter course code to remove:");
            String courseName = scan.nextLine();
            if (uni.containsKey(courseName)){
                System.out.println("This course name exists in the system!! Enter Admin password to remove");
                System.out.print("Enter Password:");
                String inputPassword = scan.nextLine();
                if (inputPassword.equals((dict.get(getUsername())).getPassword())){
                    uni.remove(courseName);
                    System.out.println("Sucess: Course deleated");
                    break;
                }else{
                    System.out.println("Wrong Password ------) try Again");
                    System.out.println();
                }
            }
            else{
                System.out.println("Error: This Course doesn't exist");
            }
        }
    }


    public void userInfo(){
        while(true){
        System.out.println("Change username/password of users without their consent");
        System.out.print("Enter Username to edit: ");
            String name = scan.nextLine();
            if (dict.containsKey(name)){
                try{
                    System.out.println("User is present in the system, proceed to edit---> \n1)Change Username 2) change Password  ");
                    System.out.print("Enter: ");
                    int ans2 = scan.nextInt();
                    scan.nextLine();
                    if (ans2 == 1){
                        System.out.print("Enter new username: ");
                        String input = scan.nextLine();
                        (dict.get(name)).setUsername(input);
                        break;
                    }else if (ans2 ==2){
                        System.out.print("Enter new Password: ");
                        String input = scan.nextLine();
                        (dict.get(name)).setPassword(input);
                        break;
                    }else{
                        System.out.println("Error: Wrong input (1/2), try again!");
                    }
                }catch (Exception e) {
                    System.out.println("Error, wron type of data, we only accept int");
                }
            }
        }
   
    }


}
