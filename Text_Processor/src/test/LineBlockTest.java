package test;

import datamodel.buildingblocks.LineBlock;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LineBlockTest {
	
	private LineBlock lineBlockTest;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.lineBlockTest = new LineBlock();
	}

	@Test
	public void testGetNumWords() {
		final int WORD_COUNT = 7;
		String sample = "This is a test of 7 words";
		lineBlockTest.setLines(sample);
		assertEquals(WORD_COUNT, lineBlockTest.getNumWords());
	}




	@Test
	public void testGetLines() {
		String firstLine = "First Line";
		String secondLine = "Second Line";


		lineBlockTest.setLines(firstLine);
		lineBlockTest.setLines(secondLine);

		assertNotNull(lineBlockTest.getLines());
	}

}
