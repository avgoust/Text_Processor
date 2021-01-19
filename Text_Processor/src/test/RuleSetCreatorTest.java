package test;

import datamodel.buildingblocks.LineBlock;
import datamodel.ruleset.RuleSet;
import datamodel.ruleset.RuleSetCreator;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RuleSetCreatorTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void createRuleSetTest() {
		LineBlock block1 = new LineBlock();
		LineBlock block2 = new LineBlock();
		LineBlock block3 = new LineBlock();
		LineBlock block4 = new LineBlock();
		LineBlock block5 = new LineBlock();
		LineBlock block6 = new LineBlock();
		LineBlock block7 = new LineBlock();
		
		block1.setLines("HELLO MY NAME IS JOHN");
		block2.setLines("CHAPTER one, this is a demo");
		block3.setLines("This paragraph will be deleted");
		block4.setLines("We are going to discuss those things [normal]");
		block5.setLines("This paragrapth in ITALICS!");
		block6.setLines("This paragraph will be deleted");
		block7.setLines("CHAPTER two, this is a demo");
		
		ArrayList<LineBlock> lineblocks = new ArrayList<LineBlock>();
		lineblocks.add(block1);
		lineblocks.add(block2);
		lineblocks.add(block3);
		lineblocks.add(block4);
		lineblocks.add(block5);
		lineblocks.add(block6);
		lineblocks.add(block7);
		
		ArrayList<String> rule1 = new ArrayList<String>();
		ArrayList<String> rule2 = new ArrayList<String>();
		ArrayList<String> rule3 = new ArrayList<String>();
		ArrayList<String> rule4 = new ArrayList<String>();
		
		rule1.add("OMIT");
		rule1.add("POSITIONS");
		rule1.add("3,6");
		
		rule2.add("H1");
		rule2.add("ALL_CAPS");
		
		rule3.add("H2");
		rule3.add("STARTS_WITH");
		rule3.add("CHAPTER");
		
		rule4.add("<I>");
		rule4.add("POSITIONS");
		rule4.add("5");
		
		List<List<String>> inputSpec = new ArrayList<List<String>>();
		inputSpec.add(rule1);
		inputSpec.add(rule2);
		inputSpec.add(rule3);
		inputSpec.add(rule4);
		
		RuleSetCreator rsCreator = new RuleSetCreator(lineblocks, inputSpec, "Giannis");
		RuleSet rs = rsCreator.createRuleSet();
		for (LineBlock lb : lineblocks) {
			lb.setStyle(rs.determineHeadingStatus(lb));
			lb.setFormat(rs.determineFormatStatus(lb));
		}
		
		for (LineBlock lb : lineblocks) {
			System.out.println(lb.getStyle());
			System.out.println(lb.getFormat());
			System.out.println("=============");
		}
	}


}
