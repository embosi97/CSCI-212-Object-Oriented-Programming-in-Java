package Lab2;

class Student extends Person {

	protected double gpa;

	public Student(String n, String i, double g){ 
		super(n, i); //name and id are inherited from Person
		gpa = g; //gpa is created in Student
	}
}
