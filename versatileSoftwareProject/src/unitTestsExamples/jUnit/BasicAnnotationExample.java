package unitTestsExamples.jUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class BasicAnnotationExample {

	@BeforeClass
	public static void runOnceBeforeClass() {
		System.out.println("@BeforeClass - runOnceBeforeClass");
	}

	// Run once, e.g close connection, cleanup
	@AfterClass
	public static void runOnceAfterClass() {
		System.out.println("@AfterClass - runOnceAfterClass");
	}

	// Should rename to @BeforeTestMethod
	// e.g. Creating an similar object and share for all @Test
	@Before
	public void runBeforeTestMethod() {
		System.out.println("@Before - runBeforeTestMethod");
	}

	// Should rename to @AfterTestMethod
	@After
	public void runAfterTestMethod() {
		System.out.println("@After - runAfterTestMethod");
	}

	@Test
	public void test_method_1() {
		System.out.println("@Test - test_method_1");
	}

	// Time out in milli seconds
	@Test(timeout = 1000)
	public void test_method_2() throws Throwable {
		System.out.println("@Test - test_method_2");
		while (true) {
			Thread.sleep(100);
		}
	}

	@Test
	@Ignore
	public void test_method_3() {
		System.out.println("@Test - test_method_2");
	}
}
