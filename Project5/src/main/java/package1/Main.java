package package1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	String[] arr = {"1. I wish to review my expenditure", //Lines 10 - 21 have been changed to instance variables to cut down on value passing
            "2. I wish to add my expenditure",
            "3. I wish to delete my expenditure",
            "4. I wish to sort the expenditures",
            "5. I wish to search for a particular expenditure",
            "6. Close the application"
    };
    int[] arr1 = {1,2,3,4,5,6};
    int  slen = arr1.length;
    List<Integer> expenses = new ArrayList<Integer>(Arrays.asList(1000,2300,45000,32000,110)); //Values declared at initialization to allow use of list values without adding them from a method
    ArrayList<Integer> arrlist = new ArrayList<Integer>(); 
    Scanner sc = new Scanner(System.in); 
    
    public static void main(String[] args) {
        //System.out.println("Hello World!"); <- this should really be deleted, but its not a bug
        System.out.println("\n**************************************\n");
        System.out.println("\tWelcome to TheDesk \n");
        System.out.println("**************************************");
        Main m = new Main(); //Added code to allow us to utilize an instance object we can easily share, future methods will be modified to accept and/or pass m as needed
        optionsSelection(m);
    }
    
    public static void optionsSelection(Main m) {
    	for(int i=0; i<m.slen;i++){
            System.out.println(m.arr[i]);
            // display the all the Strings mentioned in the String array
        }
    	int options = 10;
        System.out.println("\nEnter your choice:\t");
        try {
        	options =  m.sc.nextInt();
        	//for(int j=1;j<=slen;j++){ <- The default case already deals with unacceptable input so lines 41 - 42 are unnecessary and forces undesired repetitions
            //if(options==j){
                switch (options){
                    case 1:
                        System.out.println("Your saved expenses are listed below: \n");
                        System.out.println(m.expenses+"\n");
                        optionsSelection(m);
                        break;
                    case 2:
                        System.out.println("Enter the value to add your Expense('s): \n");
                        int value = m.sc.nextInt();
                        m.expenses.add(value);
                        System.out.println("Your value is updated\n");
                        //m.expenses.addAll(m.arrlist); <- We don't want to append arrlist to our expenses
                        System.out.println(m.expenses+"\n");
                        optionsSelection(m);
                        break;
                    case 3:
                        System.out.println("You are about the delete all your expenses! \nConfirm again by selecting the same option...\n");                                               
                        int con_choice = m.sc.nextInt();
                        if(con_choice==options){
                        	m.expenses.clear();
                            System.out.println(m.expenses+"\n");
                            System.out.println("All your expenses are erased!\n");
                        } else {
                        		System.out.println("Oops... try again!");                       
                        	}
                        optionsSelection(m);
                        break;
                    case 4:
                        sortExpenses(m);
                        optionsSelection(m);
                        break;
                    case 5:
                        searchExpenses(m);
                        optionsSelection(m);
                        break;
                    case 6:
                        closeApp(m);
                        break;
                    default:
                        System.out.println("You have made an invalid choice!");                   
                        optionsSelection(m); //Added as I believe the close the application should be called to end the application
                        break;
                }
    }catch(Exception e) {
    	System.err.println("You didn't enter an integer."); 
    	m.sc = new Scanner(System.in); 
    	optionsSelection(m);
    	}
            //}
        //}
    }
    
    private static void closeApp(Main m) {
    	m.sc.close(); //The scanner should be closed so this is added
        System.out.println("Closing your application... \nThank you!");
    }
    
    private static void searchExpenses(Main m) {
        int leng = m.expenses.size();
        System.out.println("Enter the expense you need to search:\t");
        //Complete the method <- done
        try { //Added input checking
        int findExpense = m.sc.nextInt();
        boolean found = false; //Temp variable used to determine appropriate output message 
        for(int x = 0; x < leng; x++) { //A simple big O (n) search loop to my knowledge only a tree type collection could potentially be faster
        	if(m.expenses.get(x) == findExpense) {
        		System.out.println("We have found an instance of expense: " + m.expenses.get(x) + " at the index of: " + x);
        		found = true;
        	}
        } 
        if(found == false)System.out.println("There were no results that matched your query.");
        }catch(Exception e) {
        	System.err.println("You didn't enter an integer."); 
        	m.sc = new Scanner(System.in);
        	}
    }
    
    private static void sortExpenses(Main m) {
        //Complete the method. The expenses should be sorted in ascending order. <- done
        m.breakList(m, 0, m.expenses.size() - 1); //We were told to utilize a big O (log n), I used merge short.
        System.out.println(m.expenses);
    }
    
    void breakList(Main m, int startIndex, int endIndex) //One of two added methods for the merge short, these are needed for merge short's recursive nature.
    {
        if (startIndex < endIndex) //this statement allows list to be broken into smaller componets but stops the break if we have whittled a section down to a single element
        {          
            int midIndex = (startIndex + endIndex) / 2; //Find the midpoint of the list or whole list
            m.breakList(m, startIndex, midIndex); //Recursively break the list again but this time taking one half of the list passed into breakList
            m.breakList(m, midIndex + 1, endIndex); //Recursively break the list again but this time taking the other half of the list passed into breakList
            combineLists(m, startIndex, midIndex, endIndex); //Finally call the last method of the merge sorting functions to combine all the broken lists
        }
    }

    void combineLists(Main m, int startIndex, int midIndex, int endIndex) //The second method for the merge sort combines the broken-down lists
    {
        int[] leftArray  = new int[midIndex - startIndex + 1]; //Populate temporary left and right arrays for logical comparisons
        int[] rightArray = new int[endIndex - midIndex];
        for (int i = 0; i < leftArray.length; i++)
            leftArray[i] = m.expenses.get(startIndex + i);
        for (int i = 0; i < rightArray.length; i++)
            rightArray[i] = m.expenses.get(midIndex + 1 + i);
        int leftIndex = 0, rightIndex = 0;
        int tempIndex = startIndex;
        
        while (leftIndex < leftArray.length && rightIndex < rightArray.length) { //Carefully compare and assign the values to expenses
            if (leftArray[leftIndex] <= rightArray[rightIndex])
            {
            	m.expenses.set(tempIndex, leftArray[leftIndex]);
                leftIndex++;
            }
            else
            {
            	m.expenses.set(tempIndex, rightArray[rightIndex]);           
                rightIndex++;
            }
            tempIndex++;
        }  
        while (leftIndex < leftArray.length) { //Assign additional last values to expenses if the right array was entirely used up
        	m.expenses.set(tempIndex, leftArray[leftIndex]); 
        	tempIndex++; leftIndex++;
        }
        while (rightIndex < rightArray.length) {
        	m.expenses.set(tempIndex, rightArray[rightIndex]); //Assign additional last values to expenses if the left array was entirely used up 
        	tempIndex++; rightIndex++;
        }
    }
}