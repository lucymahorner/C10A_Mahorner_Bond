//Lucy Mahorner and Ethan Bond

import java.util.*;
import java.io.*;

public class ScoreTrakker{
	private ArrayList<Student> students;
	
	public void loadDataFromFile(String fileName) throws FileNotFoundException{
		students = new ArrayList<Student>();
		FileReader reader = new FileReader(fileName);
		Scanner in = new Scanner(reader);
		while(in.hasNextLine()){
			String name = in.nextLine();
			String score = in.nextLine();
			int numScore = Integer.parseInt(score);
			Student readIn = new Student(name, numScore);
			students.add(readIn);
		}
	}
	
	public void printInOrder(){
		Collections.sort(students);
		for(Student student: students){
			System.out.println(student.toString());
		}
	}
	
	public void processFiles() throws FileNotFoundException{
		loadDataFromFile("scores.txt");
		printInOrder();
	}
	
	public static void main(String args[]) throws FileNotFoundException{
		ScoreTrakker tracker = new ScoreTrakker();
		tracker.processFiles();
	}
	
}