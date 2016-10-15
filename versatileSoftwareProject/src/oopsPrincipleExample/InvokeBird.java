package oopsPrincipleExample;

public class InvokeBird {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Chicken c = new Chicken(false);
		c.feather = "red and white";
		c.canFly = false;
		c.gender = "male";

		Duck d = new Duck(true, 10);
		d.feather = "white";
		d.gender = "female";

	}
}
