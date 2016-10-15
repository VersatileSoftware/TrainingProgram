package firstPackage;

public class MethodExamples {

	static public int ages;

	// Constructors
	MethodExamples() {
		ages = 100;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double myAdd = sum(10.2, 2);
		myAdd = sum(1, 2);
		System.out.println(sum(1, 2));
		int rajSum = sum(100, 2000);
		System.out.println(myAdd + " " + rajSum);

		printMyFor(20);
		// MethodExamples an=new MethodExamples();
		// System.out.println(an.ages);
	}

	/*
	 * My method is to add two values and two integer value
	 */
	public static int sum(int x, int y) {
		int a = x + y;
		return a;
	}

	public static int sum(int x, int y, int z) {
		int a = x + y + z;
		return a;
	}

	public static void printMyFor(int x) {
		for (int i = 0; i < x; i++) {
			System.out.println(i);
		}
	}

	// Overloading
	public static double sum(double x, double y) {
		System.out.println(x + y);
		return (x + y);
	}

}
