package Lab2;

abstract class Employee extends Person {
	
	protected String office;
	
	public Employee(String n, String i, String o){ 
		super(n,i); //name and id from the super class
		office = o;
	}
	
	public abstract double pay();
	
	public String toString(){
		String str = super.toString();
		str += "\nWeekly Salary: " + pay();
		return str;
	}
}
