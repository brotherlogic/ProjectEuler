package uk.co.brotherlogic.euler;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import uk.co.brotherlogic.euler.problem135.App;

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
	 * Rigourous Test :-)
	 */
	public void testApp() {
		App app = new App();
		assertEquals(app.getCount(27), 2);
		assertEquals(app.getCount(1155), 10);
	}
}
