package Lab2;

class Person {
	protected String name, id;
	public Person(String n, String i){
		name = n;
		id = i;
	}
	public String toString(){
		String str = "******************************";
		str += "\nName: " + name + "\nID: " + id;
		str += "\nEmail Address: " + email();
		return str;
	}
	public String email(){
		return name + "@qc.cuny.edu";
	}
}
