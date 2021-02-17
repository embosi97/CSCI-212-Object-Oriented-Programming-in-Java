package Lab1;

public class Driver {

	public static void main(String[] args) {

		System.out.println("----------- PART 2a -----------\n");

		// set up some matrices to test with. Don't change these.
		Matrix a = new Matrix(new int[][]{{1,2},{3,4}});
		Matrix b = new Matrix(new int[][]{{5,6},{7,8}});
		Matrix c = new Matrix(new int[][]{{9,0},{0,0}});
		int r = 3; // we'll use this for scalar multiplication. (Don't change)
		Matrix lhs, mid, rhs, result; // these are for storing our results and comparing them. (Don't change)

		/*
		 * For questions 1 - 9: compute the left hand side, compute the
		 * right hand side, then print out if they're equal or not.
		 * Make sure to reuse the lhs and rhs variables for each problem.
		 * 
		 * As an example, I'll do #1 so you know what I'm expecting.
		 */

		// 1. (A^T)^T = A
		System.out.println("1. (A^T)^T = A");
		lhs = a.transpose().transpose();
		rhs = a;
		System.out.println(lhs.equal(rhs) + "\n");

		// 2. (A+B)^T = A^T+B^T
		System.out.println("2. (A+B)^T = A^T+B^T");
		lhs = (a.add(b)).transpose();
		rhs = (a.transpose().add(b.transpose()));
		System.out.println(lhs.equal(rhs) + "\n");

		// 3. (rA)^T = rA^T
		System.out.println("3. (rA)^T = rA^T");
		lhs = (a.mult(r)).transpose();
		rhs = a.mult(r).transpose();
		System.out.println(lhs.equal(rhs) + "\n");

		// 4. (AB)^T = B^T*A^T
		System.out.println("4. (AB)^T = B^T*A^T");
		lhs = a.mult(b).transpose(); 
		rhs = b.transpose().mult(a.transpose());
		System.out.println(lhs.equal(rhs) + "\n");

		// 5. AB != BA
		System.out.println("5. AB != BA");
		lhs = a.mult(b);
		rhs = b.mult(a);
		System.out.println(!lhs.equal(rhs) + "\n");

		// 6. A(BC) = (AB)C
		System.out.println("6. A(BC) = (AB)C");
		lhs = a.mult(b.mult(c));
		rhs = (a.mult(b)).mult(c);
		System.out.println(lhs.equal(rhs) + "\n");

		// 7. A(B+C) = AB + AC
		System.out.println("7. A(B+C) = AB + AC");
		lhs = a.mult(b.add(c));
		rhs = a.mult(b).add(a.mult(c));
		System.out.println(lhs.equal(rhs) + "\n");

		// 8. (A+B)C = AC + BC
		System.out.println("8. (A+B)C = AC + BC");
		lhs = (a.add(b)).mult(c);
		rhs = a.mult(c).add(b.mult(c));
		System.out.println(lhs.equal(rhs) + "\n");

		// 9. (rA)B = r(AB) = A(rB)
		System.out.println("9. (rA)B = r(AB) = A(rB)");
		lhs = (a.mult(r)).mult(b);
		mid = (a.mult(b).mult(r));
		rhs = a.mult(b.mult(r));
		System.out.println((lhs.equal(lhs) && lhs.equal(rhs)) + "\n");


		System.out.println("----------- PART 2b -----------\n");

		// create the given matrices from part 2. (Don't change)
		Matrix A = new Matrix(new int[][] {{1,-2,3},{1,-1,0}});
		Matrix B = new Matrix(new int[][] {{3,4},{5,-1},{1,-1}});
		Matrix C = new Matrix(new int[][] {{4,-1,2},{-1,5,1}});
		Matrix D = new Matrix(new int[][] {{-1,0,1},{0,2,1}});
		Matrix E = new Matrix(new int[][] {{3,4},{-2,3},{0,1}});
		Matrix F = new Matrix(new int[][] {{2},{-3}});
		Matrix G = new Matrix(new int[][] {{2,-1}});


		// (a) 3C-4D
		System.out.println("(a) 3C-4D");
		result = C.mult(3).subtract(D.mult(4));
		if (result != null) { System.out.println(result); } 
		else { System.out.println("Explain why it went wrong here.\n"); }

		// (b) A-(D+2C)
		System.out.println("(b) A-(D+2C)");
		result = A.subtract(D.add(C.mult(2)));
		if (result != null) { System.out.println(result); } 
		else { System.out.println("Explain why it went wrong here.\n"); }

		// (c) A-E
		System.out.println("(c) A-E");
		result = A.subtract(E);
		if (result != null) { System.out.println(result); } 
		else { System.out.println("Explain why it went wrong here.\n"); }
		System.out.println("It went wrong because amount of columns != rows, which results in null - E.B.\n");

		// (d) AE
		System.out.println("(d) AE");
		result = A.mult(E);
		if (result != null) { System.out.println(result); } 
		else { System.out.println("Explain why it went wrong here.\n"); }

		// (e) 3BC-4BD
		System.out.println("(e) 3BC-4BD");
		result = (B.mult(3).mult(C)).subtract(B.mult(4).mult(D));
		if (result != null) { System.out.println(result); } 
		else { System.out.println("Explain why it went wrong here.\n"); }

		// (f) CB + D
		System.out.println("(f) CB+D");
		result = C.mult(B).add(D);
		if (result != null) { System.out.println(result); } 
		else { System.out.println("Explain why it went wrong here.\n"); }
		System.out.println("It violates a condition - E.B.");

		// (g) GC
		System.out.println("(g) GC");
		result = G.mult(C);
		if (result != null) { System.out.println(result); } 
		else { System.out.println("Explain why it went wrong here.\n"); }

		// (h) FG
		System.out.println("(h) FG");
		result = F.mult(G);
		if (result != null) { System.out.println(result); } 
		else { System.out.println("Explain why it went wrong here.\n"); }

		// (i) C^2
		System.out.println("(i) C^2");
		result = C.mult(C);
		if (result != null) { System.out.println(result); } 
		else { System.out.println("Explain why it went wrong here.\n"); }
		System.out.println("There is no otherMatrix in this problem, so it cannot solve it - E.B.\n");

		// (j) C+D
		System.out.println("(j) C+D");
		result = C.add(D);
		if (result != null) { System.out.println(result); } 
		else { System.out.println("Explain why it went wrong here.\n"); }
	}

}