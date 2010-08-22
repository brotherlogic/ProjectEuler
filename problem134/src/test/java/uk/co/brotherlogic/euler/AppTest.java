package uk.co.brotherlogic.euler;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import uk.co.brotherlogic.euler.problem134.App;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Create the test case
	 * 
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		App app = new App();
		assertTrue(app.testNumber(19, 23) == 1219);
	}
}
