package datamodel.rules;

import datamodel.buildingblocks.LineBlock;

import java.util.ArrayList;

public class RuleStartWith extends AbstractRule
{
	private static final int FIRST_LINE = 0;
	private String prefix;

	public RuleStartWith(String prefix) {
		this.prefix = prefix;
	}

	@Override
	public boolean isValid(LineBlock paragraph) {
		if (paragraph == null)
		{
			System.out.println("einai null ");
		}
		System.out.println(" den EINAI DEN einai null ");

		System.out.println(paragraph.getStatsAsString());


		String[] words = paragraph.getLineAsList(FIRST_LINE);
		ArrayList<String> wordsInPrefix = new ArrayList<String>();
		generateListOfWordsFromPrefix(wordsInPrefix);
		if (wordsInPrefix.isEmpty()) return false;
		return areSame(words, wordsInPrefix);
	}

	@Override
	public String toString() {
		return "Checking if paragraph starts with the specific word [prefix]";
	}
	
	private void generateListOfWordsFromPrefix(ArrayList<String> string) {
		String[] words = prefix.split(" ");
		for (String word : words)
			string.add(word);
	}
	
	private boolean areSame(String [] words, ArrayList<String> listPrefix) {
		for (int i = 0; i < listPrefix.size(); i ++)
			if (!listPrefix.get(i).equals(words[i])) return false;
		return true;
	}
}
