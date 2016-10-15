package unitTestsExamples.testNg;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParamaterisedExampleTests {

	@Test(dataProvider = "provideNumbers")
	public void testAddNum(int number, int expected) {
		Assert.assertEquals(number, expected);
	}

	@DataProvider(name = "provideNumbers")
	public Object[][] provideData() {

		return new Object[][] { { 10, 10 }, { 100, 110 }, { 200, 210 } };
	}
}
