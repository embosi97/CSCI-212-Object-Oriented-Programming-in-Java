package Cars;

public class CarNode {

//create 'data' which occupies the nodes and 'next' which is essentially a pointer to the next node on the list
//make it protected so the entire package has access to them without the need of getters and setters
protected Car data; //the object itself
protected CarNode next; //what connects the object nodes itself

//no argument constructor for CarNode (dummy node)
public CarNode(){
	data = null;
	next = null;
}

//1-argument constructor, CarNode's data is whatever is present in the parameter and next is null.
public CarNode(Car data){
	this.data = data;
	next = null;
}

}//end of CarNode
