package Cars;
	public class Car { 
		//private instance variables for car
		private String make;
		private String model;
		private int year;
		private int mileage; 
		
		//four argument constructor 
		public Car(String make, String model, int year, int mileage) {
			if(make == null || model == null || year < 0 || mileage < 0) throw new IllegalArgumentException("Not Valid");
			this.make = make;
			this.model = model;
			this.year = year;
			this.mileage = mileage;
			}
		
		public Car() { //no argument/default constructor
			this.make = null; //strings set to null and numbers to 0
			this.model = null;
			this.year = 0;
			this.mileage = 0;
			}
		
			//getters and setters for above the instance values so that other classes in this package can access them		
		    //getter for make
			public String getMake() {   
			return make;
		    }
			//setter for make
			public void setMake(String newMake) {
			  if(make == null) throw new IllegalArgumentException("Not Valid");
				make = newMake;
			}
			//getter for model
			public String getModel() {   
				return model;
			}
			//setter for model
			public void setModel(String newModel) {
			  if(model == null) throw new IllegalArgumentException("Not Valid");
				model = newModel;
			}
			//getter for year
			public int getYear() {   
			return year;
			}
			//setter for year
			public void setYear(int newYear) { 
		    if(year == 0) throw new IllegalArgumentException("Not Valid");
				year = newYear;
			}
			//getter for mileage
			public int getMileage() {   
				return mileage;
			}//setter for mileage
			public void setMileage(int newMileage) { 
		    if(mileage == 0) throw new IllegalArgumentException("Not Valid");
			mileage = newMileage;
			}
				
			
			//Override the toString so that it reads like the desired input
			public String toString() { 
			    return this.make + ", " + this.model + ", " + this.year + ", " + this.mileage + "\n";
			}
			
			
		}


