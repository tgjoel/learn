package coding.stringoperations;

import javax.xml.stream.events.Characters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class StringPrograms {


	public static void main(String[] args) {

//		int arr[] = {10, 324, 45, 90, 9808};
//		int maximum = maximum(arr);
//		System.out.println(maximum);
//		Languages ap;
//		for (Languages a: Languages.values()) {
//			System.out.println(a + " " + a.getCoders() + " coders.");
//		}


//		List list = new ArrayList<>();
//		
//		list.add(1);
////		list.add(2);
////		list.add(3);
////		list.add(4);
////		list.add(5);
////		list.add(6);
////		list.add(7);
//		
//		String lst = list.toString().substring(1,
//				list.toString().length() - 1);
//		
//		System.out.println(lst);
//		
//		String[] nameList = null;
//		Object[] paramList = null;
//		if(true) {
//			nameList = new String[]{"companyIds"};
//			paramList =new Object[] {lst.split(",")};
//		}
//		System.out.println(nameList[0]);
//		System.out.println(paramList[0]);
//
//		//Arrays.stream(nameList).forEach(System.out::print);
//		System.out.println();
//		Arrays.stream(paramList).forEach(System.out::print);
		
//		List companyIdList = Arrays.asList("1","2", "3", 4, 676L);
//
//		List<Long> cmpList = new ArrayList<>();
//		for (Object o : companyIdList) {
//			if(o instanceof String) {
//				cmpList.add(Long.valueOf((String) o));
//			} else if(o instanceof Integer) {
//				cmpList.add(Long.valueOf((Integer) o));
//			} else if(o instanceof Long) {
//				cmpList.add((Long) o);
//			}
//		}
//
//		cmpList.forEach(System.out::print);

//		findDulpicatesInArray();
//		biggestOfArrayUsingRecursion();
//		recursiveBinarySearch();
//		checkAnagram();
//		largestOddNumberInTheString();
//		longestEvenWord();
//		compress()
		
//		
//		String input1 = "qa w u    "; 
//		String expectedOutput = "qa%20w%20u";
//		insertCharacters(input1.toCharArray(), 6);
//		
//		
//		String input2 = "Tact Coa";
//		//Ex: taco cat,  atco cta
//		boolean output = true;
//		System.out.println(isPermutationOfPalindrome(input2.toLowerCase()));
//		
//	
//		String str1 = "pale"; String str2 = "ple";  //--> true 
//		String str3 = "pales"; String str4 = "pale"; // --> true
//		String str5 = "pale"; String str6 = "bae";  // --> false
//		String str7 = "pale"; String str8 = "bale";  // --> true
//		
//		//insert, delete, replace
//		System.out.println(isOneEditAway(str1, str2));
//		System.out.println(isOneEditAway(str3, str4));
//		System.out.println(isOneEditAway(str5, str6));
//		System.out.println(isOneEditAway(str7, str8));
//		
//		
//		 str1 = "aaaabbccccccccaaa";// a4b2c8a3
//		 str2 = "abca";// a1b1c1a1 --> abca as this is less than former
//		 str3 = "aaaabbccccccccaaah";// a4b2c8a3h1
//		System.out.println(commpressedString(str1));
//		System.out.println(commpressedString(str2));
//		System.out.println(commpressedString(str3));

//		String st1 = "waterbottle";
//		String st2 = "terbottlewa";
//		System.out.println(isStringRotation(st1, st2));

		//String st11 = "abba";
		//superReducedString(st11);

		String st12 = "saveChangesInTheEditor";
		camelCase(st12);
	
	}
	private static void  occurences() {
		String S = "occurrences";
		int[] arr = new int[26];

		for(int i = 0; i< S.length(); i++) {
			arr[S.charAt(i) - 'a']++;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < S.length(); i++) {
			if(!sb.toString().contains(""+S.charAt(i))) {
				sb.append(S.charAt(i)).append(arr[S.charAt(i) - 'a']);
			}
		}
		System.out.println(sb.toString());
	}

	private static void camelCase(String s) {
		System.out.println(s.chars().filter(Character::isUpperCase).count() + 1 );
	}


	private static String superReducedString(String s) {
		if(s==null) {
			//handle null
			return null;
		}
		for(int i = 1; i<s.length();i++) {
			if(s.charAt(i) == s.charAt(i-1)) {
				s = s.substring(0, i-1) + s.substring(i+1);
				i=0;
			}
		}
		if(s.length() == 0) {
			System.out.println("Empty String");
			return "Empty String";
		} else {
			System.out.println("Super reduced string: " +s);
			return s;
		}

	}



	enum Languages {
		Python(10-10+10*10), Java(9-9+9*9), Angular(12-12+12*12);
		private int coders;
		Languages(int p) {
			this.coders = p;
		}
		public int getCoders() {
			return coders;
		}
	}


	private static void longestEvenWord() {
		String s = "this is a simple input for the problem";

		String lword = Arrays.stream(s.split(" "))
				.filter(w ->  w.length() % 2 ==0)
				.max(Comparator.comparingInt(String::length)).orElse("");
		System.out.println("Longest Even word in the string: " + lword);

	}

	private static void sumOfSquaresOfOddNumber() {
		//Sum of squares of the odd numbers in the list
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		Integer sumsgr1 = list.stream().filter(x -> x % 2 != 0).map(x -> x * x).mapToInt(Integer::intValue).sum();
		System.out.println(sumsgr1);
		Integer sumsgr2 = list.stream().filter(x->x%2 != 0).map(x -> x * x).reduce(0, Integer::sum);
		System.out.println(sumsgr2);
	}

	private static void largestOddNumberInTheString() {
		// method finds the largest odd number in the string
		//Ex: 56 -> 5 || 4206 -> none ||  35427 -> 35427

		String s = "354276";
		//s = "4206";
		//s = "56";
		int num = Integer.MIN_VALUE;

		for(int i = s.length()-1;i>=0; i--) {
			if(Integer.parseInt(String.valueOf(s.charAt(i))) % 2 != 0){
				num = Integer.parseInt(s.substring(0, i +1)); // second index is exclusive hence +1;
				break;
			}
		}
		if(Integer.MIN_VALUE == num) {
			System.out.println("None");
		} else {
			System.out.println("Largest odd number: " + num);
		}

	}

	private static boolean isStringRotation(String st1, String st2) {
		
		// need to check if rotation of st2 makes it st1
		
		if(st1.length()!=st2.length()) {
			return false;
		}
		// st2 should be a substring of st1st1
		String st = st1 + st1;
		return st.contains(st2);
	}

	private static String commpressedString(String str) {
		
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			count++;
			if((i+1 >= str.length()) || str.charAt(i)!= str.charAt(i+1)) {	
				sb.append(str.charAt(i)).append(count);
				count = 0;
			}
		}
		
		return sb.toString().length() < str.length() ?  sb.toString(): str ;
	}

	private static boolean isOneEditAway(String str1, String str2) {
		
		if(str1.length() - str2.length() > 1) {
			return false;
		}
		int arr[] = new int[26];
		
		for (int i = 0; i < str1.length(); i++) {
			arr[str1.charAt(i) - 'a']++; 
		}
		
		for (int i = 0; i < str2.length(); i++) {
			arr[str2.charAt(i) - 'a']--;
		}
		
		int sum = Arrays.stream(arr).map(Math::abs).sum();
		if(sum > 2) {
			return false;
		}
		
		return true;
	}

	private static boolean isPermutationOfPalindrome(String input) {
		
		int a[] = new int[26];
		
		IntStream.range(0, input.length())
		.filter(index -> input.charAt(index) != ' ')
		.forEach(index -> {
			  a[input.charAt(index) - 'a']++;
		});
		
//		for (int i = 0; i < input.length(); i++) {
//			
//			if(input.charAt(i) == ' ') {
//				continue;
//			}	
//		}
//		
		// there should only be one odd character, rest all should be even;
		
		
		boolean isOneOddChar = false;
		for (int i = 0; i < input.length(); i++) {
		
			if(input.charAt(i) != ' ' && a[input.charAt(i) - 'a'] % 2 == 1) {
				if(isOneOddChar) {
					return false;
				}
				isOneOddChar = true;
			}
		}
		
		return true;
	}

	private static void insertCharacters(char[] charArray, int actualLength) {
		
		System.out.println(charArray.length);
		// need to insert '%20'
		
		int spaceCount = 0;
		
		for (int i = 0; i < actualLength; i++) {
			if(charArray[i] == ' ') {
				++spaceCount;
			}
		}	
		
		// only two is required even though we are inserting 3 characters because 1 character size is already 
		// taken as the space
		int newLength = actualLength + spaceCount * 2 ; 
	
		for (int i = actualLength - 1, index = newLength-1; i > 0; i--) {
			
			if(charArray[i] == ' ') {
				charArray[index] = '0';
				--index;
				charArray[index] = '2';
				--index;
				charArray[index] = '%';
				--index;
			} else {
				charArray[index] =  charArray[i];
				--index;
			}	
		}
		
		System.out.println(charArray);
		
	}

	private static void checkAnagram() {
		 String str1 = "qawsxedco";
		 String str2 = "cdexswaqy";
		 
		 if(str1.length() != str2.length()) {
			 System.out.println("not anagram");
			 return;
		 }
		 
		 int arr[] = new int[26];
		 
		 IntStream.range(0, str1.length()).forEach(index -> {
			 arr[str1.charAt(index) - 'a']+=1;
			 
		 });
		 
		 IntStream.range(0, str2.length()).forEach(index -> {
			 
			 arr[str2.charAt(index) - 'a']-=1;
			 
			 if(arr[str2.charAt(index) - 'a'] < 0) {
				 System.out.println("not anagram");
			 } 
		 });
		 
		 
	}

	private static void recursiveBinarySearch() {
		int array[] = {27,53,11,345,4431,4643};
		
		boolean isPresent = recursiveBinarySearch(array, 0, array.length-1);
		System.out.println(isPresent);
	}

	private static boolean recursiveBinarySearch(int[] array, int start, int end) {
		int i = 46432;
		
		if(start == end) {
			return array[start] == i ;
		}
		
		int midIndex = (start + end)/2;
		int midNumber = array[midIndex];
		
		if(i == midNumber) {
			return true;
		}
		
		if(i > midNumber) {
			return recursiveBinarySearch(array, midIndex+1, end);
		} else {
			return recursiveBinarySearch(array, start, midIndex-1);
		}
		
	}

	private static void biggestOfArrayUsingRecursion() {
		int array[] = {27,53,11,345,4431,4643};
		int biggest = biggestOfArrayUsingRecursion(array, 0, Integer.MIN_VALUE);
		System.out.println(biggest);
	}

	//static int highest = Integer.MIN_VALUE;
	private static int biggestOfArrayUsingRecursion(int[] array, int i, int highest) {	
		if(i >= array.length) {
			return highest;
		}
		
		if(array[i] > highest) {
			highest = array[i];
		}
		
		return biggestOfArrayUsingRecursion(array, i+1, highest);
	}

	private static void findDulpicatesInArray() {
		int array[] = {2,5,1,5,1,4}; // elements should be less than the size of the array
		
		for (int i = 0; i < array.length; i++) {
			
			if(array[Math.abs(array[i])] > 0) {
				array[Math.abs(array[i])] *= -1;  // fliping if the array is positive  
			} else {
				System.out.println(Math.abs(array[i]) +  " is duplicate");
			}
			
		}
		
	}

	private static void compress() {
		String input = "czzzzaaaa0aaaaaayyyyyllllflllc";

		int count = 1;
		StringBuilder sb = new StringBuilder();
		if(input == null){
			//handle null
		}
		for (int i = 0; i < input.length(); i++) {

			if (i == input.length() - 1) {
				sb.append(input.charAt(i)).append(count);
				break;
			}
			if (input.charAt(i) == input.charAt(i + 1)) {
				count++;
			} else {
				sb.append(input.charAt(i)).append(count);
				count = 1;
			}

		}
		System.out.println(sb);
	}
}
