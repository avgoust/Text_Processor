package exporters;

import datamodel.buildingblocks.Document;

public class MarkdownExporter {
	private Document document;
	private String outputFileName;

	public MarkdownExporter(Document document, String outputFileName) {
		this.document = document;
		this.outputFileName = outputFileName;
	}

	public int export() {
		// TODO Auto-generated method stub
		return 0;
	}

}
