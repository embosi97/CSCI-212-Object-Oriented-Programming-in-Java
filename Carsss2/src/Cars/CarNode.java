package Cars;

public class CarNode {

//create 'data' which occupies the nodes and 'next' which is essentially a pointer to the next node on the list
//make it protected so the entire package has access to them without the need of getters and setters
protected Car data;
protected CarNode next;

//no argument constructor for CarNode
public CarNode(){
	data = null;
	next = null;
}

//1-argument constructor 
public CarNode(Car data){
	this.data = data;
	next = null;
}

}//end of CarNode
