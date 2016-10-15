package firstPackage.accessModifiers;

public class Students {

	String studentFirstName;
	private int age;
	static String course;
	public int experience;

	public void setAge(int age) {
		if (age > 100)
			this.age = 0;
		else
			this.age = age;

	}

	public int getAge() {
		return age;
	}

	protected void printStudentDetails() {
		System.out.println(studentFirstName);
		System.out.println(age);
		System.out.println(course);
		System.out.println(experience + "\n");
	}

}
