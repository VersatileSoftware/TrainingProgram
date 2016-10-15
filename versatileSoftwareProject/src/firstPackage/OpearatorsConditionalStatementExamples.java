package firstPackage;

public class OpearatorsConditionalStatementExamples {

	public static void main(String[] args) {

		int houseNumber = 10;
		int street = 200;
		String city = "London";
		String area = "Westminster";

		if (houseNumber > street) {
			System.out.println("Value of houseNumber is great than street");
		} else {
			System.out.println("Value of street is greater");
		}

		// Change the input to see what is printed
		if ((houseNumber < street) && city.equals("Birmingham")) {
			System.out.println(houseNumber + "Is greater than Street and City is :  " + city);
		} else if ((houseNumber > street) || area.contains("West")) {
			System.out.println(houseNumber + "Is greater than Street and Area :  " + area);
		} else if (!(city.contains("Congo"))) {
			System.out.println("City is not CONGO");
		}

		// Terenary Operator
		int telephoneNumber = (houseNumber == 10) ? 888888 : 9999999;
		System.out.println("The telephone number is " + telephoneNumber);

		// Switch Statement example
		String grade = "A";
		switch (grade) {
		case "A":
			System.out.println("Excellenet");
			break;
		case "B":
			System.out.println("Good");
			break;
		default:
			System.out.println("BAD");
			break;
		}

	}

}
