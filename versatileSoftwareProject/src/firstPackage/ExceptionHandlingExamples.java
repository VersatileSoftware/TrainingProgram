package firstPackage;

public class ExceptionHandlingExamples {

	public static void main(String[] args) {
		// getSequence(9, 2);
		getSequence(0, 0);
		// getSequence(10, 5);
	}

	static void getSequence(int x, int y) {
		// TODO Auto-generated method stub
		try {
			System.out.println(x % y);
			int[] a = { 1, 2, 3, 4 };
			System.out.println(a[4]);
		} catch (Throwable a) {
			// TODO: handle exception
			System.out.println(a.toString());
			System.out.println(a.getStackTrace().toString());
			System.out.println("Throwable exception");
		} finally {
			System.out.println("complete");
		}

		System.out.println("SEQUENCE METHOD COMPLET");
	}

}
