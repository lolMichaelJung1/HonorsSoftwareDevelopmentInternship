//Michael Jung Period 6 11/29/22
import java.util.Scanner;
class starter  {
	public static boolean checkPrime(int num1){
		int counter = 2;
		while (counter < num1){
			if (num1 % counter == 0){
				return false;
			}
			counter = counter + 1;
		}  
		
		return true;
	} 
	public static void printPrimes(int num1){
		int counter = 2;
		while (counter < num1){
			if (checkPrime(counter)){
				System.out.println(counter);
			}
			counter = counter + 1;
		}  
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		try{
		System.out.println("Enter your integer");
		int num1 = sc.nextInt();
		printPrimes(num1);
		} finally {
		sc.close();
		}
	}
}