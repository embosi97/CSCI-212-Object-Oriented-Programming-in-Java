package Cars;

//abstract linked list class
public class CarList {
protected CarNode head, first, last;
protected int length; //make an int 'length' to count the size of the linked list

//The no-argument constructor should create an empty list 
//with first and last pointing to an empty head node, and length equal to zero
public CarList(){
	head = new CarNode();
	first = head;
	last = head;
	length = 0; //since there's just one node
}

//Include an append method in this class
//This adds a new CarNode to the end of the list
public void append(Car node){
	CarNode x = new CarNode(node); //create a new CarNode that contains the Car in the parameter 
	last.next = x; //link the new node to the linked list by having the last node's next point to it
	last = x; //the new node x becomes the new last node in the list
	length++; //add one to the length since we just added a new node 
}

//override the toString so that it prints out the CarNodes
//this uses the toString in the Car class to print the Car objects in the CarNodes
public String toString() {
	//create a StringBuilder that'll store the CarNodes
	StringBuilder list = new StringBuilder();

	 for (CarNode i = head.next; i != null; i = i.next) { //while the next node isn't null, move on to the next CarNode
		list.append((i.data).toString() + "->"); //calls the toString in Car class and adds the CarNode to the StringBuilder
	}//since the Car's toString goes to the next line after mileage, that's why "->" is at the beginning of each new line
      // Add to the StringBuilder the last string
	  list.append("null");
	  
	return list.toString();
}//toString	

}//End of CarList
