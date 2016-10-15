package objectExamples;

public class Dog {

	// INSTANCE VARAIBLE
	// Declaration
	String breed;
	int age;
	String color;
	String name;

	// constructor
	public Dog(String name) {
		// this variable
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	void barking() {
		if (age <= 2) {
			System.out.println("Bow-wow");
		} else if ((age > 2) && (age < 5)) {
			System.out.println("Bow-wow-wow-wow-Bow");
		} else if (age > 5) {
			System.out.println("Bow-wow-wow-wow-Bow");
		}
	}

	void hungry() {
		switch (age) {
		case 1:
		case 2:
			System.out.println("always hungry");
			break;
		case 3:
		case 4:
		case 5:
			System.out.println("nearly hungry");
			break;
		default:
			System.out.println("too old to be hungry");
			break;
		}

	}

}
