package package1;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Methods {
	
	Scanner scanner = new Scanner(System.in);
	int choice;
	Path directory;
	Path file;
	File dir;
	List<String> organizedFiles = new ArrayList<String>();
	File[] files;
	
	public void menu() {
		if(directory == null) createLocation();
		System.out.println("============================================================================================================");
		System.out.println("Welcome to the main menu.");
		System.out.println("Local directory path: "+directory);
		System.out.println("You have 3 choices.");
		System.out.println("Enter 1 to view the local directory's contained files.");
		System.out.println("Enter 2 to proceed to the business logic menu.");
		System.out.println("Enter 3 to close the application.");
		System.out.print("Your choice: ");
		try {
			choice = Integer.parseInt(scanner.nextLine());
			switch (choice){
			case 1: viewDirectory(); break;
			case 2:	fileManagement(); break;
			case 3: close(); break;
			default: System.err.println("\nYou did not enter an integer between 1 - 3 inclusive.\n"); menu(); break;
			}
		} catch(java.lang.NumberFormatException e) {
			System.err.println("\nYou did not enter an integer.\n");
			menu();
		}
	}
	
	public void fileManagement() {
		System.out.println("============================================================================================================");
		System.out.println("Welcome to the business logic menu.");
		System.out.println("Local directory path: " + directory);
		System.out.println("You have 4 choices.");
		System.out.println("Enter 1 to create a new file.");
		System.out.println("Enter 2 to delete a file.");
		System.out.println("Enter 3 to read the contents of a file.");
		System.out.println("Enter 4 to return to previous menu.");
		System.out.print("Your choice: ");
		try {
			choice = Integer.parseInt(scanner.nextLine());
			switch (choice){
			case 1: createFile(); break;
			case 2: deleteFile(); break;
			case 3: readFile(); break;
			case 4: menu(); break;
			default: System.err.println("\nYou did not enter an integer between 1 - 4 inclusive.\n"); fileManagement(); break;
			}
		} catch(java.lang.NumberFormatException e) {
			System.err.println("\nPlease enter an integer.\n");
			fileManagement();
		}
	}
	
	private void viewDirectory() {
		System.out.println("============================================================================================================");
		dir = new File(directory.toUri());
		files = dir.listFiles();
		System.out.println("The directory's contents are: ");
		for(File file: files) {
			organizedFiles.add(file.getName());
		}
		breakList(0, organizedFiles.size() - 1);
		for(String files: organizedFiles) {
			System.out.println(files);
		}
		organizedFiles.clear();
		menu();
	}

	private void createFile() {
		System.out.println("============================================================================================================");
		System.out.print("What do you want to name your new file: ");
		try {
			file = directory.resolve(scanner.nextLine());
			Files.createFile(file, (FileAttribute<?>[])new FileAttribute[0]);
			System.out.println(file.getFileName()+ " has been create");	
		}catch (FileAlreadyExistsException e) {
				System.err.println("\nThe file already exists.\n");
		} catch (IOException e) {
			System.err.println("\nThe file doesn't exist but there is some other issue with creating the file.\n");
			e.printStackTrace();
		}
		fileManagement();
	}
	
	private void deleteFile() {
		System.out.println("============================================================================================================");
		System.out.print("Enter the name of the file you want to delete: ");
		try {
			Files.delete(directory.resolve(directory+"/"+scanner.nextLine()));
			System.out.println("The file has been deleted.");	
		} catch (java.nio.file.NoSuchFileException e) {
			System.err.println("\nThe file cannot be deleted as there is no file with this name.\n");
		
		} catch (IOException e) {
			System.err.println("\nThe file exists but it can't be deleted for some other reason.\n");
			e.printStackTrace();
		} 
		fileManagement();
	}
	
	private void readFile() {
		System.out.println("============================================================================================================");
		try {
		   System.out.print("Enter the name of the file you want to read: ");
		   file = directory.resolve(scanner.nextLine());
           Scanner readScanner = new Scanner(file);
           System.out.println("The data stored in file <" + file.getFileName() + "> is as follows.");
           while (readScanner.hasNextLine()) {
               System.out.println(readScanner.nextLine());
           }
           readScanner.close();
        }
        catch (java.nio.file.NoSuchFileException e) {
        	System.err.println("\nThe file cannot be read as there is no file with this name.\n");
        }
		catch (IOException e) {
			System.err.println("\nThe file cannot exists but cannot be read for some reason.\n");
			e.printStackTrace();
		}
		fileManagement();
	}
	
	private void close() {
		System.out.println("============================================================================================================");
		System.out.println("Thank you for using the prototype file modification application.");
		dir = new File(directory.toUri());
		files = dir.listFiles();
		try {
		for(File file: files) Files.delete(file.toPath()); Files.delete(directory);
		}catch(IOException e) { 
			System.err.println("\nWe could not delete the files, please delete the directory manually.");
			e.printStackTrace();
		}
		scanner.close();
		System.out.println("The application has been closed.");
		System.out.println("============================================================================================================");
	}
	
	private void createLocation() {
		System.out.println("============================================================================================================");
			try {
				directory = Files.createTempDirectory("default-directory", (FileAttribute<?>[])new FileAttribute[0]);
				file = directory.resolve("DefaultFile");
				Files.createFile(file, (FileAttribute<?>[])new FileAttribute[0]);
				System.out.println("A default directory and file have been created.");
			} catch (IOException e) {
				System.err.println("There is an issue with creating the default directory and file.");
				e.printStackTrace();
			}			
	}
	
	 private void breakList(int startIndex, int endIndex)
	    {
	        if (startIndex < endIndex)
	        {          
	            int midIndex = (startIndex + endIndex) / 2;
	            breakList(startIndex, midIndex);
	            breakList(midIndex + 1, endIndex);
	            combineLists(startIndex, midIndex, endIndex);
	        }
	    }

	 private void combineLists(int startIndex, int midIndex, int endIndex)
	    {
	        String[] leftArray  = new String[midIndex - startIndex + 1];
	        String[] rightArray = new String[endIndex - midIndex];
	        for (int i = 0; i < leftArray.length; i++)
	            leftArray[i] = organizedFiles.get(startIndex + i);
	        for (int i = 0; i < rightArray.length; i++)
	            rightArray[i] = organizedFiles.get(midIndex + 1 + i);
	        int leftIndex = 0, rightIndex = 0;
	        int tempIndex = startIndex;    
	        while (leftIndex < leftArray.length && rightIndex < rightArray.length) { 
	        	if (leftArray[leftIndex].compareTo(rightArray[rightIndex]) <= 0) organizedFiles.set(tempIndex++, leftArray[leftIndex++]);
	            else organizedFiles.set(tempIndex++, rightArray[rightIndex++]);           
	        }  
	        while (leftIndex < leftArray.length) organizedFiles.set(tempIndex++, leftArray[leftIndex++]); 
	        while (rightIndex < rightArray.length) organizedFiles.set(tempIndex++, rightArray[rightIndex++]); 
	    }
}
