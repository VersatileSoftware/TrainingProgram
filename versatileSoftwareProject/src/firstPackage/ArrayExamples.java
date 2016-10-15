package firstPackage;

public class ArrayExamples {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] age = new int[3];

		double height[] = { 170, 177.5, 180 };

		// Processing arrays are done in loops
		for (int i = 0; i < height.length; i++) {
			System.out.println("In for loop" + height[i]);
		}
		// For each loop
		for (double d : height) {
			System.out.println("In Foreach" + d);
		}

		/*
		 * 2D ARRAY
		 * 
		 * 0 1 0|Kal |Bhag | 1|Raaj |Sekeran| 2|Adrian|T |
		 * 
		 * // * names[rows][column] // * names[0][0]=Kal // * names[0][1]=Bhag
		 * // * names[1][0]=Raaj // * names[1][1]=Sekeran // *
		 * names[2][0]=Adrain // * names[2][1]=T // * //
		 */
		//
		int[][] exampleTwoDimentionalAry = new int[2][3];
		exampleTwoDimentionalAry[0][0] = 100;

		// OR
		String[][] fullNames = { { "Kal", "Bhag" }, { "Raaj", "Sekeran" }, { "Adrian", "T" } };

		for (int i = 0; i < fullNames.length; i++) {
			for (int j = 0; j < fullNames[i].length; j++) {
				System.out.println("NAMES ARE: " + fullNames[i][j]);
			}
			System.out.println("\n");

		}

	}

}
