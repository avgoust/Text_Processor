package exporters;

import datamodel.buildingblocks.Document;
import datamodel.buildingblocks.FormatEnum;
import datamodel.buildingblocks.LineBlock;
import datamodel.buildingblocks.StyleEnum;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.MediaSize.Other;

public class PdfExporter {
	private Document document;
	private String outputFileName;
	private CreatePDF createpdf;
	
	public PdfExporter(Document document, String outputFileName)
	{
		this.document = document;
		this.outputFileName = outputFileName;
		createpdf = new CreatePDF();
	}
	
	

	public int export()
	{
		CreatePDF createpdf = new CreatePDF();
		createpdf.create(document.getLineBlock(),outputFileName);
		/*for(LineBlock element : document.getLineBlock())
		{
	
		}*/
		System.out.println("itext PDF program executed");
		//createpdf.createBold(document.getLineBlock(),outputFileName);
		
		return 0;
	}
}




