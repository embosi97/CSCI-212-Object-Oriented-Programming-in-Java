package Lab1;

public class Matrix {
	
	int [][] matrix;
	int rows, columns;
	
	public Matrix (int[][] m) {
		this.matrix = m;  
		this.rows = m.length;
		this.columns = m[0].length;
	}
	
	public String toString() {
		String string = "";
		String spac = " ";
		for(int i=0; i < matrix.length; i++){
		   for(int j=0; j < matrix[i].length; j++){
		    string = string + spac + matrix[i][j];
		}
		   string += "\n";
		}
		return string;
	}
			
	
	
	// Helper function to determine if it is legal to add or subtract two matrices
	private boolean sameDimensions(Matrix otherMatrix) {
		return this.rows == otherMatrix.rows && this.columns == otherMatrix.columns; // this. is a and otherMatrix is a
	}
	
	// Addition
	public Matrix add(Matrix otherMatrix) {
		if(!sameDimensions(otherMatrix))  
			return null;
		int added[][] = new int[rows][columns];
		for(int r = 0; r < rows; r++) {
			for(int c = 0; c < columns; c++) {
				added[r][c] = matrix[r][c] + otherMatrix.matrix[r][c];
			}
		}
		return new Matrix(added);
	}
	// Subtraction
	public Matrix subtract(Matrix otherMatrix) {
		if(!sameDimensions(otherMatrix))  
			return null;
		int diff[][] = new int[rows][columns];
		for(int r = 0; r < rows; r++) {
			for(int c = 0; c < columns; c++) {
				diff[r][c] = matrix[r][c] - otherMatrix.matrix[r][c];
			}
		}	
		return new Matrix(diff);
	}

	
	private boolean colsEqualsOthersRows (Matrix otherMatrix) {
		return this.columns == otherMatrix.rows;
	}
	
	// Matrix Multiplication
	public Matrix mult(Matrix otherMatrix) {
		if(!colsEqualsOthersRows(otherMatrix))  
			return null;
		int multiplication[][] = new int[rows][otherMatrix.columns];
		for(int r = 0; r < rows; r++) {
			for(int c = 0; c < otherMatrix.columns; c++) {
				int sum = 0;
				for(int i = 0; i < columns; i++) {
					sum = sum + matrix[r][i]*otherMatrix.matrix[i][c];
				}
				multiplication[r][c] = sum;
			}
		}
		return new Matrix(multiplication);
	}

	
	
	// Scalar Multiplication
	public Matrix mult(int scalar) {
		// TODO: Multiply the matrix with a scalar value
		// passed as a parameter
		// Store the value in a new matrix and return that matrix
		int product[][] = new int[rows][columns];
		for(int r = 0; r < rows; r++) {
			for(int c = 0; c < columns; c++) {
				product[r][c] = matrix[r][c] * scalar;
			}
		}
		return new Matrix(product);
	}
	// Transpose
	public Matrix transpose() {
		// TODO: Transpose the matrix
		// Store the value in a new matrix and return that matrix
		int transpose[][] = new int[rows][columns];
		for(int r = 0; r < rows; r++) {
			for(int c = 0; c < columns; c++) {
				transpose[r][c] = matrix[c][r];
			}
		}
	return new Matrix(transpose);
}
	public boolean equal(Matrix otherMatrix) {
		if(!sameDimensions(otherMatrix))  
			return false; 
		
		for(int r = 0; r < rows; r++) {
			for(int c = 0; c < columns; c++) {
				if(matrix[r][c] != otherMatrix.matrix[r][c]) {
					return false;
				}
			}
		}
		return true;
	}
	
}