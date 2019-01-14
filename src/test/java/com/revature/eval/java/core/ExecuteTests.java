package com.revature.eval.java.core;

public class ExecuteTests {


	public static void main(String[] args) {
		
	EvaluationServiceTest e = new EvaluationServiceTest();
	EvaluationService s = new EvaluationService(); 
	
		// Question 1
		e.testAnEmptyString();
		e.testAWord();
		e.testACapitalizedWord();
		e.testASentenceWithPunctuation();
		e.testAPalindrome();
		System.out.println("Q1 works");

		// Question 2
		e.basic();
		e.punctuation();
		e.NonAcronymAllCapsWord();
		e.punctuationWithoutWhitespace();
		System.out.println("Q2 works");
		
		// Question 3
		e.trianglesWithNoEqualSidesAreNotEquilateral();
		e.verySmallTrianglesCanBeEquilateral();
		e.isoscelesTrianglesMustHaveAtLeastTwoEqualSides();
		e.verySmallTrianglesCanBeIsosceles();
		e.trianglesWithAllSidesEqualAreNotScalene();
		e.verySmallTrianglesCanBeScalene();
		System.out.println("Q3 works");
		
		// Question 4
		e.testAValuableLetter();
		e.testAShortValuableWord();
		e.testAMediumWord();
		e.testAMediumValuableWord();
		e.testALongMixCaseWord();
		System.out.println("Q4 works");
		
		// Question 5 
		e.cleansTheNumber();
		e.cleansNumbersWithDots();
		e.cleansNumbersWithMultipleSpaces();
		try {
			e.invalidWhenMoreThan11Digits();
			e.invalidWithNonNumeric();
		} catch(IllegalArgumentException err) {
			//err.printStackTrace();
		}
		System.out.println("Q5 works");
		
		// Question 6
		e.countOneWord();
		e.countOneOfEachWord();
		e.multipleOccurrencesOfAWord();
		e.handlesCrampedLists();
		e.handlesExpandedLists();
		System.out.println("Q6 works");
		
		// Question 7
		e.findsAValueInTheMiddleOfAnArray();
		e.findsAValueAtTheBeginningOfAnArray();
		e.findsAValueAtTheEndOfAnArray();
		e.findsAValueInAnArrayOfOddLength();
		e.findsAValueInAnArrayOfEvenLength();
		System.out.println("Q7 works");
		
		// Question 8
		e.testWordBeginningWithA();
		e.testThTreatedLikeAConsonantAtTheBeginningOfAWord();
		e.testSchTreatedLikeAConsonantAtTheBeginningOfAWord();
		e.testYTreatedLikeAConsonantAtTheBeginningOfAWord();
		e.testAWholePhrase();
		System.out.println("Q8 works");
		
		// Question 9
		e.singleDigitsAreArmstrongNumbers();
		e.noTwoDigitArmstrongNumbers();
		e.threeDigitNumberIsArmstrongNumber();
		e.threeDigitNumberIsNotArmstrongNumber();
		e.fourDigitNumberIsArmstrongNumber();
		System.out.println("Q9 works");
		
		// Question 10
		e.testPrimeNumber();
		e.testSquareOfAPrime();
		e.testCubeOfAPrime();
		e.testProductOfPrimesAndNonPrimes();
		e.testProductOfPrimes();
		System.out.println("Q10 works");

		// Question 11
		e.rotateSingleCharacterWithWrapAround();
		e.rotateCapitalLetters();
		e.rotateNumbers();
		e.rotatePunctuation();
		e.rotatePunctuation();
		e.rotateAllLetters();
		System.out.println("Q11 works");
		
		// Question 12
		e.testFirstPrime();
		e.testSecondPrime();
		e.testSixthPrime();
		e.testBigPrime();
		try {
			e.testUndefinedPrime();
		} catch(IllegalArgumentException err) {
			//err.printStackTrace
		}
		System.out.println("Q12 works");
		
		// Question 13
		e.testEncodeYes();
		e.testEncodeOmgInCapital();
		e.testEncodeMindBlowingly();
		e.testEncodeNumbers();
		e.testEncodeDeepThought();
		e.testEncodeAllTheLetters();
		System.out.println("Q13 works");
		
		// Question 14
		e.testDecodeExercism(); 
		e.testDecodeNumbers();
		e.testDecodeASentence();
		e.testDecodeAllTheLetters();
		System.out.println("Q14 works");
		
		// Question 15
		e.validIsbnNumber();
		e.invalidIsbnCheckDigit();
		e.validIsbnNumberWithCheckDigitOfTen();
		e.checkDigitIsACharacterOtherThanX();
		e.invalidCharacterInIsbn();
		System.out.println("Q15 works");
		
		// Question 16
		e.emptySentenceIsNotPangram();
		e.recognizesPerfectLowerCasePangram();
		e.pangramWithOnlyLowerCaseLettersIsRecognizedAsPangram();
		e.phraseMissingCharacterXIsNotPangram();
		e.phraseMissingAnotherCharacterIsNotPangram();
		System.out.println("Q16 works");
		
		// Question 17
		e.modernTime();
		e.afterEpochTime();
		e.beforeEpochTime();
		System.out.println("Q17 works");
		
		// Question 18
		e.testSumOfMultiplesOf4and6UpToFifteen();
		e.testSumOfMultiplesOf5and6and8UpToOneHundredFifty();
		e.testSumOfMultiplesOf5and25UpToFiftyOne();
		e.testSumOfMultiplesOf43and47UpToTenThousand();
		e.testSumOfMultiplesOfOneUpToOneHundred();
		System.out.println("Q18 works");
		
		// Question 19
		e.testThatAValidCanadianSocialInsuranceNumberIsIdentifiedAsValidV1();
		e.testThatAnInvalidCanadianSocialInsuranceNumberIsIdentifiedAsInvalid();
		e.testThatAnInvalidCreditCardIsIdentifiedAsInvalid();
		e.testThatAddingANonDigitCharacterToAValidStringInvalidatesTheString();
		e.testThatStringContainingPunctuationIsInvalid();
		System.out.println("Q19 works");
		
		// Question 20
		e.testSingleAddition1();
		e.testSingleAdditionWithNegativeNumbers();
		e.testSingleSubtraction();
		e.testSingleMultiplication();
		e.testSingleDivision();
		System.out.println("Q20 works");
	}
}
