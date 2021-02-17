package Lab2;

class Staff extends Employee {
	
	private double rate, hours;
	
	public Staff(String n, String i, String o, double r, double h) {
		super(n, i, o); //parent's strings as well as "office" from Employee are adopted
		rate = r;
		hours = h;
	}
	
	public double pay() {
		return hours * rate;
	}
}