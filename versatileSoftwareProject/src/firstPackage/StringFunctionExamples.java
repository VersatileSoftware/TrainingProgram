package firstPackage;

public class StringFunctionExamples {

	/**
	 * 
	 */
	public static void main(String[] args) {

		String firstStringExample = "I am Learnig programming";
		String secondStringExample = "Java is a high level programme";

		System.out.println("The length of my first string is :" + firstStringExample.length());
		System.out.println("The length of my Second string is :" + secondStringExample.length());
		System.out.println("Compare two string, is the two strings equal?, " + "comparing String : "
				+ firstStringExample + " and second String : " + secondStringExample + " "
				+ firstStringExample.equals(secondStringExample));

		System.out.println("Replace Java with PHP in second string  :" + secondStringExample.replace("Java", "PHP"));
		System.out.println("Print - am leaning as substring of first string  :" + firstStringExample.substring(5, 12));

	}

}
