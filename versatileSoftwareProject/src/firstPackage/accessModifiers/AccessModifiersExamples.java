package firstPackage.accessModifiers;

public class AccessModifiersExamples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Students.course = "automation";

		Students versatileSoftStudent1 = new Students();
		versatileSoftStudent1.studentFirstName = "Raaj";
		versatileSoftStudent1.setAge(30);
		versatileSoftStudent1.experience = 5;

		Students versatileSoftStudent2 = new Students();
		versatileSoftStudent2.studentFirstName = "Adrian";
		versatileSoftStudent2.setAge(20);
		versatileSoftStudent2.experience = 10;

		versatileSoftStudent1.printStudentDetails();
		versatileSoftStudent2.printStudentDetails();
	}

}
