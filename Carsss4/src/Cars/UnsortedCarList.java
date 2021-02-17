package Cars;
//linked list class that extends CarList
public class UnsortedCarList extends CarList{

	//constructor that just inherits the properties of the
	//super class's (CarList) constructor
	public UnsortedCarList(){
		super();
	}
    
	//make an 'addIt' class that functions exactly the same way as append
	public void addIt(Car node){
		append(node);
	}
}//end of UnsortedCarList
