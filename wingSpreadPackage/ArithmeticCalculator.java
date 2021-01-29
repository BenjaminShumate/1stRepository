//Note this code was created and compiled in an Eclipse dynamic web project

package wingSpreadPackage;

import java.util.Scanner;

public class ArithmeticCalculator{

	public static void main(String[] args){
		Scanner myInput = new Scanner(System.in);
		boolean calculationDone = false, error = false; String temp; double val1, val2; char operator; double ans = 0;
		
	while(calculationDone == false){
		
		do {
		System.out.println("Lets get computing!");
		System.out.print("Please enter the first number in your calculation: ");
			
		temp = myInput.nextLine();
		try{
			Double.parseDouble(temp);
		}catch(java.lang.NumberFormatException e) {
			System.out.println("Your input was not a real number.");
			break;
		}
		val1 = Double.parseDouble(temp);
		
		System.out.print("Please enter the operation you would like to perform. You may use +, -, /, or *: ");
			temp = myInput.nextLine();
			try{
				temp.charAt(0);
			}catch(java.lang.StringIndexOutOfBoundsException e) {
				System.out.println("Nothing is not an acceptable entry.");
				break;
			}
			operator = temp.charAt(0);
			if(operator != '+'&& operator != '-'&& operator != '/'&& operator != '*')
			{
				System.out.println("You did not enter a valid operator.");
				break;
			}
			
		System.out.print("Please enter the second number in your calculation: ");
			temp = myInput.nextLine();
			try{
				Double.parseDouble(temp);
			}catch(java.lang.NumberFormatException e) {
				System.out.println("You did not enter a real number.");
				break;
			}
			val2 = Double.parseDouble(temp);
			if(val2 == 0) {
				System.out.println("You cannot divide by zero.");
				break;
			}
			
		switch(operator){
			case '+': ans = val1+val2; break;
			case '-': ans = val1-val2; break;
			case '/': ans = val1/val2; break;
			case '*': ans = val1*val2; break;
			default: System.out.println("You did not enter a valid multiplier.");}
		System.out.println(val1+" "+operator+" "+val2+" is: "+ans);
	}while(error == true);
		
		System.out.println("Would you like to compute again? Enter no if you would like to terminate the calculator.");
			
		if(myInput.nextLine().equals("no"))calculationDone = true;
}
	System.out.println("Process terminated. Have a great day!");
	myInput.close ();
}
}