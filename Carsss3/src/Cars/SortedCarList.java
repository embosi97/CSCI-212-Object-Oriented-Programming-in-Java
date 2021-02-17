package Cars;
//another linked list class that extends CarList
//this one actually sorts the CarNodes by make
public class SortedCarList extends CarList{

	public SortedCarList(){
		super();
	}

	 // Insert new data into the linked list in ascending order
		public void insert(Car data)
	    {
	        // Create new node
	        CarNode n = new CarNode(data);
	        // Create iterator node
	        CarNode i = head;
	        // Look for the two spots we want to insert the new node between
	        while (i.next != null && data.getMake().compareTo(i.next.data.getMake()) > 0)
	        {
	            i = i.next;
	        }
	        // Insert the new node between current node and the next node
	        n.next = i.next;
	        i.next = n;
	        this.length++;

	        // Check if we need to update tail as well
	        if (i == this.last) this.last = n;
	    }
}
