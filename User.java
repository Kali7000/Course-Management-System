import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class User{

    HashMap<String, ArrayList<ArrayList<String>>> emailMap = Main.emailMap;  
    public Scanner scan  = new Scanner(System.in);
    protected String username;
    private String password;

    public User(){
        username = "vishal";
        password = "123456";
        ArrayList<ArrayList<String>> mailBox = new ArrayList<>();
        emailMap.put(username, mailBox);
    }
    public User(String username, String password){
        this.username = username;
        this.password = password;
        ArrayList<ArrayList<String>> mailBox = new ArrayList<>();
        emailMap.put(username, mailBox);
    }

    public String getPassword() {
        return password;
    }
    public String getUsername(){
        return this.username;
    }
    public void setPassword(String newPass){
        this.password = newPass;
    }
    public void setUsername(String name){
        this.username = name;
    }
    public void login(){
        System.out.println("Default login method");

    }

    public void email(){
        while (true) {
            try {
                System.out.println("Welcome to you mailBox \n 1)Inbox \n 2)Compose \n 3)Exit");
                int num = scan.nextInt();
                scan.nextLine();
                if (num ==1) {
                    int num1 = 1;
                    System.out.println("------Inbox------"); 

                    for (ArrayList<String> mails : emailMap.get(username)) {
                        System.out.println(num1+") "+mails.get(0));
                        num1+=1;

                    }
                    System.out.print("Enter Subject Index to view the email: ");
                    int num2 = scan.nextInt();
                    scan.nextLine();
                    if (num2 > (emailMap.get(username)).size() || num2 < 1){
                        System.out.println("There is no email at such index");
                    }else{
                        
                        System.out.println(num2+") \n  Subject: "+(emailMap.get(username).get(num2-1)).get(0)+"\n  Body: "+(emailMap.get(username).get(num2-1)).get(1));
                    }
                    
                } else if (num==2) {
                    System.out.print("Who do you want to email to? \n Enter Username: ");
                    String toSend = scan.nextLine();
                    if (emailMap.containsKey(toSend)){
                        System.out.print("\nEnter the Subject of your Email: ");
                        String subj = "From: "+getUsername()+"| "+ scan.nextLine();
                        System.out.print("\nEnter the Body of your Email: ");
                        String body = scan.nextLine();

                        ArrayList<String> massage = new ArrayList<>();
                        massage.add(subj);
                        massage.add(body);
                        (emailMap.get(toSend)).add(massage);

                        System.out.println("Massage Sent!!");

                    }else{
                        System.out.println("There is no user with such userName!");
                    }
                } else if (num ==3) {
                    System.out.println("Good bye!!");
                    break;
                } else{
                    System.out.println("Error: wrong type of input, try again");
                }
                
            } catch (Exception e) {
                System.out.println("Error: Wrong type of input, try again");
            }
        }
        
    }



}
