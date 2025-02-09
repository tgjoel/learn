package coding.generalprograms;

public class SumOfNumberTillSingleDigiit {

	public static void main(String[] args) {
		// 1234 ->  1 + 2 + 3 + 4 : 10 -> 1 + 0 -> 1
		// 5674 ->  5 + 6 + 7 + 4 : 22 -> 2 + 2 -> 4
		
		//ans: a number can be of the form 9x or 9x + k. if its of former then sum is 9 and for latter the sum is k

		
		sumOfDigit(1234);
		sumOfDigit(5674);
		sumOfDigit(9999);
		sumOfDigit(65785412);

	}

	private static void sumOfDigit(int n) {
		
		if(n == 0) {
			System.out.println(0);
		}
	
		System.out.println(n%9 == 0 ? 9 : (n%9));
	}

}
