package oopsPrincipleExample;

public class Duck extends Bird {

	int swimSpeed;

	public Duck(boolean canFly, int speed) {
		super(canFly);
		swimSpeed = speed;
	}

	protected void swimSpeed() {
		if (canSwim) {
			System.out.println("Can swim at a massive speed of" + swimSpeed);
		} else {
			System.out.println("DUCK is crippeled");
		}
	}

}
