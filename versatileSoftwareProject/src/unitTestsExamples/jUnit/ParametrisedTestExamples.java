package unitTestsExamples.jUnit;

import java.util.Arrays;
import java.util.Collection;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

// Junit runner
@RunWith(value = Parameterized.class)
public class ParametrisedTestExamples {

	private int numberA;
	private int numberB;
	private int expected;

	// Inject via constructor
	// for {8, 2, 10}, numberA = 8, numberB = 2, expected = 10
	public ParametrisedTestExamples(int numberA, int numberB, int expected) {
		this.numberA = numberA;
		this.numberB = numberB;
		this.expected = expected;
	}

	@Test
	public void test_addTwoNumbes() {
		System.out.println("Compare " + numberA + " with " + numberB + "");
		Assert.assertTrue(Sum(numberA, numberB) == (expected));

	}

	// name attribute is optional, provide an unique name for test
	// multiple parameters, uses Collection<Object[]>
	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { 1, 1, 2 }, { 2, 2, 5 }, { 8, 2, 10 }, { 4, 5, 9 }, { 5, 5, 10 } });
	}

	public int Sum(int a, int b) {
		return a + b;
	}
}
