//Lucy Mahorner and Ethan Bond

import java.util.*;
import java.io.*;

public class ScoreTrakker{
	//Declare variables
	private ArrayList<Student> students;
	private String[] files = {"scores.txt", "badscore.txt", "nofile.txt" };
	
	// Method reads in text file to variables
	public void loadDataFromFile(String fileName) throws FileNotFoundException{
		students = new ArrayList<Student>();
		FileReader reader = new FileReader(fileName);
		Scanner in = new Scanner(reader);
		while(in.hasNextLine()){
			String name = in.nextLine();
			String score = in.nextLine();
			try {
				int numScore = Integer.parseInt(score);
				Student readIn = new Student(name, numScore);
				students.add(readIn);
		    }
		    catch (NumberFormatException e) { // If not an integer score, print error message
		       	System.out.println(name + " " + score + " is not a valid score");
		    }
		}
	}
	
	// Method prints out the students
	public void printInOrder(){
		Collections.sort(students);
		for(Student student: students){
			System.out.println(student.toString());
		}
	}
	
	// Reads in file names to loadDataFromFile function
	public void processFiles() throws FileNotFoundException{
		for(String fileName: files){
			try{
				loadDataFromFile(fileName);
				printInOrder();
			}
			catch (FileNotFoundException e){ // Print error if file does not exist
				System.out.println(fileName + " does not exist.");
			}
		}
	}
	
	//Call processFiles
	public static void main(String args[]) throws FileNotFoundException{
		ScoreTrakker tracker = new ScoreTrakker();
		tracker.processFiles();
	}
	
}