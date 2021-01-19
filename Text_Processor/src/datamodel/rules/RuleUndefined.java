package datamodel.rules;

import datamodel.buildingblocks.LineBlock;

public class RuleUndefined extends AbstractRule {

	@Override
	public boolean isValid(LineBlock paragraph) {
		return false;
	}

	@Override
	public String toString() {
		return "When we can't define a Rule class (everything is invalid)";
	}

}
