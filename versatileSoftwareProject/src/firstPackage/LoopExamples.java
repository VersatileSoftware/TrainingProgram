package firstPackage;

public class LoopExamples {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Print 10 times
		int count = 0;
		while (count < 10) {
			System.out.println("Inside the while loop, times " + count);
			count++;
		}

		// prints 10 times
		count = 0;
		do {
			System.out.println("Inside the Do while loop with count as " + count);
			count++;
		} while (count < 10);

		// break after 5 loops
		count = 0;
		do {
			System.out.println("Inside do while with break " + count);
			count++;
			if (count == 5) {
				System.out.println("Ran 5 times, its time to stop");
				break;
			}
		} while (count < 10);

		String star = "*";
		// Print a pattern
		/*
		 * 
		 * *
		 **
		 ***
		 ****
		 *****
		 ******
		 *******
		 ********
		 * 
		 * 
		 */
		for (int i = 0; i < 10; i++) {
			String full = star;
			for (int j = 1; j <= i; j++) {
				full += star;
			}
			System.out.println(full);

		}

	}

}
