package unitTestsExamples.jUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AssertionExamples {

	String nameStudent1;
	String nameStudent2;
	int height1;
	int height2;
	int height3;

	@Before
	public void setUp() {
		nameStudent1 = "Raaj";
		nameStudent2 = "Kaal";

		height1 = 100;
		height2 = 100;
		height3 = 110;
	}

	@Test
	public void testAssertions() {
		// Check that a condition is true
		assertTrue(height1 > height3);

	}

	@After
	public void tearDown() {
		height1 = 0;
		height2 = 0;
		height3 = 0;
	}

	@Test
	public void testAssertion2() {
		assertEquals(height1, height2);
		assertFalse(height1 > height2);
	}

}
