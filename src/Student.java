//Lucy Mahorner and Ethan Bond

public class Student implements Comparable<Student>{
	private String name;
	private int score;
	
	public Student(String name, int score){
		this.name = name;
		this.score = score;
	}
	
	@Override //compare function compares student names
	public int compareTo(Student student){
		return (this.name.compareTo(student.name));
	}
	
	public String toString(){
		 return name + " " + score;
	}
}