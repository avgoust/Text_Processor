package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import datamodel.buildingblocks.LineBlock;
import datamodel.rules.AbstractRule;
import datamodel.rules.ConcreteRuleFactory;

public class RuleInPositionTest {
	
	private LineBlock paragraph;
	private AbstractRule ruleInPosition;
	private ConcreteRuleFactory ruleFactory;
	private ArrayList<Integer> pPositions;
	private ArrayList<LineBlock> pLineblocks;
	private int number = 0;

	@Before
	public void setUp() throws Exception {
		ruleFactory = new ConcreteRuleFactory();
		paragraph = new LineBlock();
		pPositions = new ArrayList<Integer>();
		pLineblocks = new ArrayList<LineBlock>();
	}

	@Test
	public void isValidTest() {
		LineBlock block1 = new LineBlock();
		LineBlock block2 = new LineBlock();
		LineBlock block3 = new LineBlock();
		LineBlock block4 = new LineBlock();
		
		populateLineBlocks(block1, block2, block3, block4);
		addLineBlocksToList(block1, block2, block3, block4);
		generatePositionList();
		
		ruleInPosition = ruleFactory.createRuleInPosition(pLineblocks, pPositions);
		
		assertTrue(ruleInPosition.isValid(block4));
		
	}
	
	private void populateLineBlocks(LineBlock... lineBlocks) {
		for (LineBlock lineBlock : lineBlocks)
			lineBlock.setLines("This is " + number++ + " paragraph!");
			
	}
	
	private void addLineBlocksToList(LineBlock... lineBlocks) {
		for (LineBlock lineBlock : lineBlocks)
			pLineblocks.add(lineBlock);
	}
	
	private void generatePositionList() {
		if (pLineblocks.isEmpty()) return;
		for (int i = 0; i < pLineblocks.size(); i ++)
			pPositions.add(i+1);
	}

}
