package unitTestsExamples.jUnit;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class EachTestRunner {

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(ParametrisedTestExamples.class);

		for (Failure failure : result.getFailures()) {
			System.out.println(failure.getMessage());
		}

		System.out.println(result.wasSuccessful());
	}

}
