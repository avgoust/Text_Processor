package datamodel.rules;

import datamodel.buildingblocks.LineBlock;

import java.util.List;

public class RuleInPosition extends AbstractRule {
	private static final int ERR_POSITION = -1;
	private List<LineBlock> pLineblocks;
	private List<Integer> pPositions;
	
	public RuleInPosition(List<LineBlock> pLineblocks, List<Integer> pPositions) {
		this.pLineblocks = pLineblocks;
		this.pPositions = pPositions;
	}

	@Override
	public boolean isValid(LineBlock paragraph) {
		if (!pLineblocks.contains(paragraph)) return false;
		for (int i = 0; i < pLineblocks.size(); i ++)
		{
			if (pLineblocks.get(i).equals(paragraph))
			{
				if(pPositions.get(0) == i+1) return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Finds the position of paragraph in pLineBlocks and the "
				+ "index in List should be equal to pPositions value";
	}
}