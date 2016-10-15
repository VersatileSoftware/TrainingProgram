package objectExamples;

public class InvokeObjExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Object reference variable d, creating a new object
		Dog d = new Dog("Tommy");
		System.out.println(d.name);
		d.name = "steve";
		d.age = 2;
		System.out.println(d.name);
		System.out.println(d.age);
		d.barking();

		System.out.println(d.age);
		d.hungry();

	}

}
