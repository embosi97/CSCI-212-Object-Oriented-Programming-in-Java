import java.util.Scanner;
public class Lab0 {
    public static void main(String[] arg) {
    System.out.println("Enter a random number!: ");
    Scanner console = new Scanner(System.in);
    int upperbound = console.nextInt(); // user puts input
    System.out.println(upperbound); // should be 100
    int sieveE[] = new int[upperbound+1];
    int start = 2;
    for(int a= 0; a < upperbound; a++) { 
    sieveE[a] = 1; 
    }
    for(int b = start; b*b <= upperbound; b++){ // b*b ensure it doesn't go past the multiples of upperbound        
    if(sieveE[b] == 1) 
    { 
    for(int c = b*start; c <= upperbound; c = c + b) {//sieves through all the multiples of upperbound 
    sieveE[c] = 0; 
    }
    } 
    }
    System.out.print("All the prime numbers are" + "\n");
    for(int d = 2; d <= upperbound; d++) { 
    if(sieveE[d] == 1) // should print out all the non-multiples
    System.out.print(d + "\n"); 
    } 
    System.out.print("Thank you!" + "\n");
    } 
}