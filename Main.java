import java.util.*;

public class Main{

	public static HashMap<String, User> dict = new HashMap<String, User>();
	public static HashMap<String, ArrayList<ArrayList<String>>> emailMap = new HashMap<>();
	public static HashMap<String, Course> uni = new HashMap<>();
	public static ArrayList<Student> enrollements = new ArrayList<>(); //what's its purpos?

    public static void main(String[] args) {

        

		LoadData ld = new LoadData();
		ld.loadData();
		Scanner scan  = new Scanner(System.in);


	    while(true){
    		System.out.println("Hello fellow Human, this is super Canvas, where you get everything a regular canvas has and more!");
    		System.out.println("1- Login");
    		System.out.println("2- Register");
    		System.out.println("3- Logout");

    		
    		try{
				System.out.print("Choose one: ");
        		int input = scan.nextInt();
				scan.nextLine();
        		if (input ==1){
        		    System.out.print("Enter Username: ");
        		    String inputName = scan.nextLine();
        		    
        		    if (dict.containsKey(inputName)){
        		        System.out.print("Enter Password: ");
        		        String inputPassword = scan.nextLine();
        		        if (inputPassword.equals((dict.get(inputName)).getPassword())){
        		            (dict.get(inputName)).login();
        		            
        		        }else{
        		            System.out.println("Wrong Password ------) try Again");
        		            System.out.println();
        		        }
        		    } 
        		    else{
        		        System.out.println("Entered username Dosen't Exist! ---> Try Again");
        		        System.out.println();
        		    }
        		    
        		    
        		    
        		} else if(input == 2){
        		    System.out.println("Hi there---> Let's get you started with your canvas");
        		    
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
                                    dict.put(newUsername, new Student(newUsername, newPassword)); 
                                    break;
                                }
                            }
            		        
            		        System.out.println(newUsername+" added!!");
            		        break;
        		        }   
        		        
                    }
                }
                else if (input == 3){
                    //Save program state
                    System.out.println("Sined out! Get out! Have some fun in the real world you Nerd!!");
                    break;
                }
            }catch (Exception e) {
                System.out.println("Wrong Type of Input ---> Try Again");
                System.out.println();
                continue;
            }
        }

    }
}
