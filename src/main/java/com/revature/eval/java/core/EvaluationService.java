package com.revature.eval.java.core;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.Year;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j=0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		String acronym = ""; 
		boolean trigger = true; 
		char[] cPhrase = phrase.toCharArray(); 
		for(int i = 0; i<cPhrase.length; i++) { 
			if ((cPhrase[i] >= 65 && cPhrase[i] <= 90) 
					|| (cPhrase[i] >= 97 && cPhrase[i] <=122)){ 
				if(trigger) {
					acronym += cPhrase[i]; 
				    trigger = false;
				}
			}
			else if (!trigger){
			    trigger = true;
			}
		}
		return acronym.toUpperCase();
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			if(sideOne == sideTwo && sideOne == sideThree) {
				return true; 
			}
			return false;
		}

		public boolean isIsosceles() { 
			if(sideOne == sideTwo) {
				return true; 
			}
			if (sideOne == sideThree) {
				return true;
			}
			if (sideTwo == sideThree) {
				return true; 
			}
			return false;
		}

		public boolean isScalene() {
			if(sideOne == sideTwo) {
				return false; 
			}
			if (sideOne == sideThree) {
				return false;
			}
			if (sideTwo == sideThree) {
				return false; 
			}
			return true;
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		Hashtable<Character, Integer> value = new Hashtable();
		value.put('A', 1); 
		value.put('E', 1); 
		value.put('I', 1); 
		value.put('O', 1); 
		value.put('U', 1); 
		value.put('L', 1); 
		value.put('N', 1); 
		value.put('R', 1); 
		value.put('S', 1); 
		value.put('T', 1); 
		value.put('D', 2); 
		value.put('G', 2); 
		value.put('B', 3); 
		value.put('C', 3); 
		value.put('M', 3); 
		value.put('P', 3); 
		value.put('F', 4); 
		value.put('H', 4); 
		value.put('V', 4); 
		value.put('W', 4); 
		value.put('Y', 4); 
		value.put('K', 5); 
		value.put('J', 8); 
		value.put('X', 8); 
		value.put('Q', 10); 
		value.put('Z', 10); 
		int score = 0; 
		char[] charArr = string.toUpperCase().toCharArray();
		for(char chari : charArr) {
			score += value.get(chari);
		}
		return score;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) throws IllegalArgumentException {
		String stringOut = "";
		char[] nonIllegalChar = {' ', '(', ')', '+', '-', '.', '[', ']', '_'};
		ArrayList<Character> nonIllegalCharArr = new ArrayList(); 
		for(char i : nonIllegalChar) {
			nonIllegalCharArr.add(i); 
		}
		char[] charArr = string.toCharArray(); 
		for(Character c : charArr) {
			if(c >= 48 && c <= 57) {
				stringOut += c; 
			}
			else if(!nonIllegalCharArr.contains(c)) {
				throw new IllegalArgumentException(); 
			}
			
		}
		if(stringOut.length() > 10 || stringOut.length() < 7) {
			throw new IllegalArgumentException();
		}
		return stringOut;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		char[] delim = {' ', '!', '"', '#', '$', '%', '&', 
				'\'', '(', ')', '*', '+', ',', '-', '.', 
				'/', '\n', '\\', '\t' 
		};
		for(char c : delim) {
			string = string.replace(c, ' '); 
		}
		String[] words = string.split(" ");
		
		Map<String, Integer> strFreq = new HashMap<String, Integer>();
		for(int i = 0; i < words.length; i++) {
			if(!words[i].isEmpty()) {
				if(strFreq.containsKey(words[i])) {
					strFreq.put(words[i], strFreq.get(words[i]) + 1); 
				} else {
					strFreq.put(words[i], 1); 
				}
			}
		}
		return strFreq;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
			String tStr = t.toString(); 
			Integer tInt = Integer.parseInt(tStr); 
			
			Integer iMid = sortedList.size() / 2; 
			T tMid = sortedList.get(iMid);
			String tMidStr = tMid.toString();
			Integer tMidInt = Integer.parseInt(tMidStr); 
			
			Integer tCompare = tInt.compareTo(tMidInt); 
			
			if(tCompare == 0) {
				return iMid; 
			} else if(tCompare < 0) {
				return indexOf(t, sortedList.subList(0, iMid)); 
			} else if (tCompare > 0) {
				return iMid + indexOf(t, sortedList.subList(iMid, sortedList.size()));
			} else {
				System.out.println("THIS DIDN'T WORK");
			}
			
			return -1; 
		}
		
		private int indexOf(T t, List<T> sortedList) {
			String tStr = t.toString(); 
			Integer tInt = Integer.parseInt(tStr); 
			
			Integer iMid = sortedList.size() / 2; 
			T tMid = sortedList.get(iMid);
			String tMidStr = tMid.toString();
			Integer tMidInt = Integer.parseInt(tMidStr); 
			
			Integer tCompare = tInt.compareTo(tMidInt); 
			
			if(tCompare == 0) {
				return iMid; 
			} else if(tCompare < 0) {
				return indexOf(t, sortedList.subList(0, iMid)); 
			} else if (tCompare > 0) {
				return iMid + indexOf(t, sortedList.subList(iMid, sortedList.size()));
			} else {
				System.out.println("THIS DIDN'T WORK");
			}
			
			return -1; 
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		// Note: this fails when the first vowel in a word is y
		// [e.g. why should become ywhay but instead becomes whyay]
		// If this task were more important I would attempt to fix that
		String[] words = string.split(" ");
		char[] vowel = {'a', 'e', 'i', 'o', 'u'};
		String pigLatin = ""; 
		for(String word : words) {
			int firstVowelIndex = word.length();
			String wordMod = word;
			 
			for (char c : vowel) {
				int vowelIndex = word.indexOf(c); 
				if(vowelIndex > -1 && vowelIndex < firstVowelIndex){
					firstVowelIndex = vowelIndex; 
				}
			}
			
			//Cheat to fix 'qu' at the beginning of a word
			if(firstVowelIndex > 0 && word.charAt(firstVowelIndex) == 'u'
					&& word.charAt(firstVowelIndex-1) == 'q') {
				firstVowelIndex = firstVowelIndex + 1; 
			}
			
			pigLatin = pigLatin + word.substring(firstVowelIndex, word.length()) + 
					word.substring(0, firstVowelIndex) + "ay"; 
			if(word != words[words.length-1]) {
				pigLatin += " ";
			}
		}
		
		return pigLatin;
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		// break the input into its digits
		int[] digits; 
		
		int x = input;
		int xSize = (int)Math.log10(x) + 1; 		
		int xDigit = (int)((double)x / Math.pow(10, xSize));
		digits = new int[xSize]; 

		for(int i = 0; i < digits.length; i++) {
			xSize = (int)Math.log10(x);
			xDigit = (int)((double)x / Math.pow(10, xSize));
			digits[i] = xDigit; 
			x = x - (xDigit * (int)Math.pow(10,  xSize)); 
		}
		
		// calculate Armstrong Number from its digits
		int digitSum = 0; 
		for(int i = 0; i < digits.length; i++) {
			digitSum = digitSum + (int)Math.pow(digits[i], digits.length); 
		}
		
		return (input == digitSum); 
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		// TODO Write an implementation for this method declaration
		List <Long> primeFactors = new ArrayList<Long>(); 
		
		// base case, 1 or 0
		if(l == 1 && l == 0) {
			return primeFactors; 
		}
		
		boolean isPrime = true; 
		for(long i = 2; i <= Math.floor(Math.sqrt(l)); i++) {
			if(l % i == 0) {
				isPrime = false; 
				primeFactors.add(i); 
				primeFactors.addAll(calculatePrimeFactorsOf(l / i)); 
				break; 
			}
		}
		if (isPrime) {
			primeFactors.add(l); 
		}
		
		return primeFactors; 
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			// TODO Write an implementation for this method declaration
			char[] rotArr = string.toCharArray();
			int cMax = -1; 
			boolean checkRotate = false; 
			for(int i = 0; i < rotArr.length; i++) {
				if(rotArr[i] >= 'a' && rotArr[i] < 'a' + 26) {
					cMax = 'a' + 26;
					checkRotate = true; 
				} else if(rotArr[i] >= 'A' && rotArr[i] < 'A' + 26){
					cMax = 'A' + 26; 
					checkRotate = true; 
				} else {
					checkRotate = false; 
				}; 
				if(checkRotate) {
					rotArr[i] = (char)(rotArr[i] + key); 
					if(rotArr[i] >= cMax) {
						rotArr[i] -= 26; 
					}
				}
			}
			return String.valueOf(rotArr);
		}

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		// TODO Write an implementation for this method declaration
		long number = 1; 
		if(i < 1) {
			throw new IllegalArgumentException(); 
		}
		while(i > 0) {
			number++; 
			List<Long> factors = this.calculatePrimeFactorsOf(number); 
			if(factors.size() == 1){
				i--;
			}
		}
		return (int)number;
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			char[] charArr = string.toCharArray();
			String stringEn = "";  
			for(int i = 0, j = 0; i < charArr.length; i++, j++) {
				if(j >= 5 && i < charArr.length-1) {
					stringEn += " ";
					j = 0; 
				} 
				if(charArr[i] >= 'a' && charArr[i] <= 'z') {
					stringEn += (char)('a' + ('z' - charArr[i]));
				} else if (charArr[i] >= 'A' && charArr[i] <= 'Z'){
					stringEn += (char)('a' + ('Z' - charArr[i]));
				} else if (charArr[i] >= '0' && charArr[i] <= '9'){
					stringEn += charArr[i];
				} else {
					j -= 1; 
				}
			}
			return stringEn; 
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			char[] charArr = string.toCharArray();			String stringEn = "";  
			for(int i = 0; i < charArr.length; i++) {
				if(charArr[i] >= 'a' && charArr[i] <= 'z') {
					stringEn += (char)('a' + ('z' - charArr[i]));
				} else if (charArr[i] >= 'A' && charArr[i] <= 'Z'){
					stringEn += (char)('a' + ('Z' - charArr[i]));
				} else if (charArr[i] >= '0' && charArr[i] <= '9'){
					stringEn += charArr[i];
				}
			}
			return stringEn; 
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		List<Integer> isbn = new ArrayList<Integer>(); 
		for(int i = 0; i < string.length(); i++) {
			char val = string.charAt(i); 
			if(val >= '0' && val <= '9') {
				isbn.add(val - '0'); 
			}
			if(isbn.size() == 9 && val == 'X') {
				isbn.add(10); 
			}
		}
		if(isbn.size() != 10) {
			return false; 
		}
		int isbnSum = 0; 
		for(int i = 0; i < isbn.size(); i++) {
			isbnSum += (10-i) * isbn.get(i); 
		}
		if(isbnSum % 11 == 0) {
			return true; 
		}
		return false;
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		string = string.toLowerCase();
		for(int i = 0; i < 26; i++) {
			if(string.indexOf((char)('a' + i)) == -1) { 
				return false; 
			}
		}
		return true;
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		
		Temporal giga = given;
		int secondsRemain = 1000000000; 
		int SECONDS_IN_MINUTE = 60; 
		int SECONDS_IN_HOUR = 3600; 
		int SECONDS_IN_DAY = 86400;  
		int SECONDS_IN_YEAR = 31536000; 
		int SECONDS_IN_LEAP_YEAR = 31622400;

		int secondStart = 0; 
		int minuteStart = 0; 
		int hourStart = 0; 
		int dayStart; 
		int monthStart; 
		int yearStart;
		
		if(given.isSupported(ChronoUnit.SECONDS)) {
			secondStart = given.get(ChronoField.SECOND_OF_MINUTE);
		}
		if(given.isSupported(ChronoUnit.MINUTES)) {
			minuteStart = given.get(ChronoField.MINUTE_OF_HOUR);  
		}
		if(given.isSupported(ChronoUnit.MINUTES)) {
			hourStart = given.get(ChronoField.HOUR_OF_DAY); 
		}
		dayStart = given.get(ChronoField.DAY_OF_MONTH); 
		monthStart = given.get(ChronoField.MONTH_OF_YEAR); 
		yearStart = given.get(ChronoField.YEAR);

		for(int secondCurrent = secondStart; secondCurrent < 60; secondCurrent++) {
			secondsRemain -= 1; 
		} 
		minuteStart += 1; 
		
		for(int minuteCurrent = minuteStart; minuteCurrent < 60; minuteCurrent++) {
			secondsRemain -= 60; 
		}
		hourStart += 1; 
		
		for(int hourCurrent = hourStart; hourCurrent < 24; hourCurrent++) {
			secondsRemain -= 3600; 
		}
		dayStart += 1; 
		
		for(int dayCurrent = dayStart; 
				dayCurrent < Month.of(monthStart).length(Year.isLeap(yearStart)); 
				dayCurrent++) {
			secondsRemain -= SECONDS_IN_DAY; 
		}
		monthStart += 1; 
		
		for(int monthCurrent = monthStart; monthCurrent <= 12; monthCurrent++) {
			secondsRemain -= SECONDS_IN_DAY * Month.of(monthCurrent).length(Year.isLeap(yearStart)); 
		}

		int second = 0; 
		int minute = 0; 
		int hour = 0; 
		int day = 0; 
		int month = 1; 
		int year = yearStart+1; 
		
		while(secondsRemain >= (Year.isLeap(year) ? SECONDS_IN_LEAP_YEAR : SECONDS_IN_YEAR)) {
			secondsRemain -= (Year.isLeap(year) ? SECONDS_IN_LEAP_YEAR : SECONDS_IN_YEAR); 
			year += 1; 
		}
		
		while(secondsRemain >= (SECONDS_IN_DAY * Month.of(month).length(Year.isLeap(year)))) {
			secondsRemain -= (SECONDS_IN_DAY * Month.of(month).length(Year.isLeap(year))); 
			month += 1; 
		}
		
		while(secondsRemain >= SECONDS_IN_DAY) {
			secondsRemain -= SECONDS_IN_DAY;
			day += 1; 
		}
		
		while(secondsRemain >= SECONDS_IN_HOUR) {
			secondsRemain -= SECONDS_IN_HOUR; 
			hour += 1; 
		}
		
		while(secondsRemain >= 60) {
			secondsRemain -= SECONDS_IN_MINUTE; 
			minute += 1; 
		}
		
		second = secondsRemain; 
		
		return LocalDateTime.of(year, month, day, hour, minute, second);
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		int sumOfMultiples = 0; 
		for(int x = 0; x < i; x++) {
			for(int a : set) {
				if(x % a == 0) {
					sumOfMultiples += x; 
					break;
				}
			}
		}
		return sumOfMultiples;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		string = string.replace(" ", "");
		int luhnSum = 0; 
		for(int i = string.length()-1, j=1; i >= 0; i--, j++) {
			if(string.charAt(i) < '0' || string.charAt(i) > '9') { // must be a number
				return false; 
			}
			if(j%2 == 1) {
				luhnSum += (string.charAt(i) - '0'); 
			} else {
				int iVal = (string.charAt(i) - '0') * 2;
				luhnSum = iVal > 9 ? luhnSum + (iVal-9) : luhnSum + iVal; 
			}
		}
		return (luhnSum % 10) == 0;
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		Set<String> operators = new HashSet<String>(); 
		operators.add("plus");
		operators.add("minus");
		operators.add("multiplied by");
		operators.add("divided by"); 
		
		String operation = ""; 
		
		for(String s : operators) {
			if(string.contains(s)) {
				operation = s; 
			}
		}
		
		String[] vals = string.split(operation); 
		if(vals.length > 2) {
			throw new UnsupportedOperationException(); 
		}
		int left = 0; 
		int right = 0; 
		boolean leftBool = false; 
		for(String v : vals) {
			String numStr = ""; 
			for(int i = 0; i < v.length(); i++) {
				if((v.charAt(i) >= '0' && v.charAt(i) <= '9') || v.charAt(i) == '-') {
					numStr += v.charAt(i);
				}
			} if (!leftBool) {
				left = Integer.parseInt(numStr); 
			} else {
				right = Integer.parseInt(numStr); 
			}
			leftBool = true; 
		}
		switch(operation) {
		case "plus": 
			return left+right; 
		case "minus": 
			return left-right; 
		case "multiplied by": 
			return left*right; 
		case "divided by": 
			return left/right;
		default:
			throw new UnsupportedOperationException(); 
		}
	}

}
