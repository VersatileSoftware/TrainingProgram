package oopsPrincipleExample;

public abstract class Bird {

	String feather;
	int size;
	boolean webFeet;
	boolean canFly;
	String gender;
	boolean canSwim;

	public Bird(boolean canFly) {
		this.canFly = canFly;
	}

	public Boolean canReproduce() {
		if (gender.equals("female"))
			return true;
		else
			return false;
	}

}
