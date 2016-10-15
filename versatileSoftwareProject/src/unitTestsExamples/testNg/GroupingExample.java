package unitTestsExamples.testNg;

import org.testng.annotations.Test;

public class GroupingExample {

	@Test(groups = { "uat", "live" })
	public void testUatLive() {
		System.out.println("Inside testUatLive()");
	}

	@Test(groups = "uat")
	public void testUatOnly() {
		System.out.println("Inside testUatOnly()");
	}

	@Test(groups = "live")
	public void testLiveOnly() {
		System.out.println("Inside Live ");
	}

}
