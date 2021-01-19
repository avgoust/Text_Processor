package datamodel.buildingblocks;

import java.util.ArrayList;

public class LineBlock {
	
	private StyleEnum determineHeadingStatus = null;
	private FormatEnum determineFormatStatus = null;
	public ArrayList<String> lineBlock = new ArrayList<String>();
	private static final int ERR_FORMAT = -1;

	public ArrayList<String> getLineBlock()
	{
		return lineBlock;
	}
	
	public String getLineblockAsString()
	{
		String str = "";
		for(String s : lineBlock)
		{
			str += s + "\n";
		}
		return str;
	}
	
	
	
	public String getStatsAsString() {
		return "Words in this paragraph: " + lineBlock.size();
	}
	
	public void setLines(String line) {
		lineBlock.add(line);
	}

	public int getNumWords() {
		return wordsFromEveryStringInLineBlock();
	}

	public StyleEnum getStyle() {
		return determineHeadingStatus;
	}
	
	public FormatEnum getFormat() {return determineFormatStatus;}
	
	public void setStyle(StyleEnum determineHeadingStatus) {
		if (shouldChangeFormat(determineHeadingStatus)) determineFormatStatus = FormatEnum.REGULAR;
		int previousStyle = determineStyle(this.determineHeadingStatus);
		int newStyle = determineStyle(determineHeadingStatus);
		if (newStyle > previousStyle) this.determineHeadingStatus = determineHeadingStatus;
	}

	public void setFormat(FormatEnum determineFormatStatus) {
		if (determineHeadingStatus != null && determineHeadingStatus != StyleEnum.NORMAL) {
			System.out.println("Can't give format when you have a heading");
			return;
		}
		if (this.determineFormatStatus == null) {
			this.determineFormatStatus = determineFormatStatus;
			return;
		}
		int previousFormat = determineFormat(this.determineFormatStatus);
		int newFormat = determineFormat(determineFormatStatus);
		if (newFormat > previousFormat) this.determineFormatStatus = determineFormatStatus;
	}

	public ArrayList<String> getLines() {
		return lineBlock;
	}
	
	public String[] getLineAsList(int line) {
		return lineBlock.get(line).split(" ");
	}
	
	public void removeAllLines() {
		lineBlock.clear();
	}
	
	private boolean shouldChangeFormat(StyleEnum determineHeadingStatus) {
		return (determineFormatStatus != null && determineFormatStatus != FormatEnum.REGULAR && 
				determineHeadingStatus != StyleEnum.NORMAL);
	}
	
	private int wordsFromEveryStringInLineBlock() {
		int summary = 0;
		for (String string : lineBlock)
			summary += getSummaryOfWordsInString(string);
		return summary;
	}
	
	private int getSummaryOfWordsInString(String string) {
		String[] words = string.split(" ");
		return words.length;
	}
	
	private int determineFormat(FormatEnum format) {
		if (format == FormatEnum.BOLD) return 3;
		if (format == FormatEnum.ITALICS) return 2;
		if (format == FormatEnum.REGULAR) return 1;
		return ERR_FORMAT;
	}
	
	private int determineStyle(StyleEnum style) {
		if (style == StyleEnum.OMITTED) return 3;
		if (style == StyleEnum.H1) return 2;
		if (style == StyleEnum.H2) return 1;
		if (style == StyleEnum.NORMAL) return 0;
		return ERR_FORMAT;
	}

}
