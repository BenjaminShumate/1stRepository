package project4Package;

import java.util.ArrayList;
import java.util.Random;

public class Project4Methods {
	Random rand = new Random(System.currentTimeMillis());
	ArrayList<Integer> arrList = new ArrayList<Integer>();
	int numEntries;
	
	//This function introduces the program.
	void sayWelcome() {
		System.out.println("Welcome to project 4 for Simplilearn.");
		System.out.println("In this project an arraylist will be created with a random size from 0 - 100.");
		System.out.println("We will then populate the list with random integers from 0 - 100.");
		System.out.println("We will scan for the longest index consecutive subsequence of increasing numbers.");
		System.out.println("Lastly we will output the results to the screen.");
	}
	
	//This function generates a random integer, between 1 and 100, and creates an array of that size.
	//The integers of the arrayList are randomly generated between 1 and 100.
	void genEntries() {
		numEntries = rand.nextInt(101);
		for(int i=0; i<numEntries;i++) {
			arrList.add(rand.nextInt(101));
		}
		System.out.println("An arraylist of "+numEntries+" integers has been created.");
	}
	
	//This method looks for and records the number of index sequential entries and outputs the largest found subsequence.
	//The output message also acknowledges the number of identical size index consecutive value increasing subsequences.
	void checkForIncreasingPattern() {
		int patStart =0, newPatStart = 0, numSequence=1, newNumSequence = 1, numRepeatedSequence=0;
		for(int i=1; i<numEntries;i++) {
			if(arrList.get(i)>arrList.get(i-1)) {
				newNumSequence++;
			}else {
				newNumSequence = 1;
				newPatStart = i;
				}
			if(numSequence < newNumSequence) {
				patStart = newPatStart;
				numSequence = newNumSequence;
				numRepeatedSequence = 0;
				}
			if(numSequence == newNumSequence)numRepeatedSequence++;
		}
		
		System.out.println("The longest index sequencial increasing subsequence had a length of "+numSequence+" elements.");
		if(numRepeatedSequence > 1) { 
			System.out.println("Since there were "+numRepeatedSequence+" instances of the same number of index consecutive increasing integers only the first set will be displayed.");
		}		
		System.out.print("The set: <");
		for(int i = patStart; i<patStart+numSequence;i++)
		{
			if(i > patStart)System.out.print(", ");
			System.out.print(arrList.get(i));
		}
		System.out.println(">");
	}

}
