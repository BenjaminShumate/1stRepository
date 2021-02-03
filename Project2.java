package projectPackage;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Project2 {

   public static void main( String args[] ) {
	   
	   String[] emails = {"jake.pale@yahoo.net", "paul.brant@google.com","timonthy.brown@gmail.com","katherine.burke@gmail.com", "abigail.bright@yahoo.net"};
	   Scanner myInput = new Scanner(System.in);
	   String pattern = "(.@{1}.+[.].)"; boolean verify = false; byte emailCount = 5, loginAttempts = 0;
	   Pattern r = Pattern.compile(pattern);
	   
	   
	   System.out.println("Hello! It's nice to hear from you. Would you please type your emplyee email and hit enter?");
	   while(loginAttempts<5) {
	   System.out.print("You have entered: ");
	   String input = myInput.nextLine();
	   System.out.println("");
	   Matcher m = r.matcher(input);
	   
	   if(input.length() > 256) System.out.println("I'm sorry but its not possible for emails to be this large.");
	   else if(m.find()) {
		   System.out.println("According to email rules I was able to look up, what you entered could be a real email.");
		   for(int i=0; i<emailCount;i++) {
			   if(input.equals(emails[i])) verify = true;
		   }
		   if(verify == true) {
			   System.out.println("Congratulations you are one of the entries on our list!");
			   break;
		   }
		   else System.out.println("I'm sorry but you are not on the list.");
	   }
	   else System.out.println("Im sorry but what you input can't be a real email.");
	   loginAttempts++;
	   if(loginAttempts == 5) {
		   System.out.println("You have exceeded attempts and are no longer allowed to log in.");
		   break;
	   }
	   System.out.println("You have failed to enter a valid email, you have attempts "+(5-loginAttempts)+" remaining.");
	   System.out.print("You have entered: ");
	   }
	      myInput.close();
   }
}