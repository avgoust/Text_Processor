package datamodel.rules;

import datamodel.buildingblocks.LineBlock;

public class RuleAllCaps extends AbstractRule {

	@Override
	public boolean isValid(LineBlock paragraph)
	{
		return checkEveryLineOfParagraph(paragraph);
	}

	@Override
	public String toString() {
		return "Checks if whole paragraph is UpperCase";
	}
	
	private boolean checkEveryLineOfParagraph(LineBlock paragraph) {
		for (String line : paragraph.getLines())
		{
			if (!checkAllWordsOfLine(line))
				return false;
		}
		return true;
	}
	
	private boolean checkAllWordsOfLine(String line) {
		String[] lineWords = line.split(" ");
		boolean lineUpperCase = true;
		for (String word : lineWords) {
			if (!word.toUpperCase().equals(word))
			{
				lineUpperCase = false;
				break;
			}


		}
		return lineUpperCase;
	}

}
