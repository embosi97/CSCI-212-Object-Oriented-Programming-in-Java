package Lab2;

class Faculty extends Employee {

	private double salary = 1500;

	public Faculty(String n, String i, String o, double s) {
		super(n, i, o); 
		salary = s;
	}

	public double pay() {
		return salary;
	}
}

