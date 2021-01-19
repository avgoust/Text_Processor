package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import datamodel.buildingblocks.LineBlock;
import datamodel.rules.AbstractRule;
import datamodel.rules.ConcreteRuleFactory;
import datamodel.rules.RuleAllCaps;

public class RuleAllCapsTest {
	
	private LineBlock paragraph;
	private AbstractRule allCaps;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		ConcreteRuleFactory ruleFactory = new ConcreteRuleFactory();
		paragraph = new LineBlock();
		allCaps = ruleFactory.createRuleAllCaps();
		System.out.println(allCaps);
	}

	@Test
	public void isValidTest() {
		String firstLine = "HELLO THERE";
		String secondLine = "THIS IS A SECOND LINE!";
		
		String thirdLine = "This must FAIL";
		String fourthLine = "WILL IT";
		
		paragraph.setLines(firstLine);
		paragraph.setLines(secondLine);
		
		assertTrue(allCaps.isValid(paragraph));
		
		paragraph.removeAllLines();
		paragraph.setLines(thirdLine);
		paragraph.setLines(fourthLine);
		
		assertFalse(allCaps.isValid(paragraph));
	}

}
