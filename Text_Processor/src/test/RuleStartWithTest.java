package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import datamodel.buildingblocks.LineBlock;
import datamodel.rules.AbstractRule;
import datamodel.rules.ConcreteRuleFactory;

public class RuleStartWithTest {
	
	private LineBlock paragraph;
	private AbstractRule startsWith;
	private ConcreteRuleFactory ruleFactory;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		ruleFactory = new ConcreteRuleFactory();
		paragraph = new LineBlock();
	}

	@Test
	public void isValidTest() {
		String prefix = "OATH END";
		startsWith = ruleFactory.createRuleStartWith(prefix);
		System.out.println(startsWith);
		paragraph.setLines("OATH END bourou bourou!");
		
		assertTrue(startsWith.isValid(paragraph));
		
		paragraph.removeAllLines();
		prefix = "OATN END";
		startsWith = ruleFactory.createRuleStartWith(prefix);
		paragraph.setLines("OATH END bourou bourou!");
		
		assertFalse(startsWith.isValid(paragraph));
		
	}

}
