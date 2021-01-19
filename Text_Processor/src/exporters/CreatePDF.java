package exporters;

import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import datamodel.buildingblocks.LineBlock;
import datamodel.buildingblocks.FormatEnum;


public class CreatePDF {
	private Document document = new Document();
	public void create(List<LineBlock> lb,String output) {
		try
		{
			PdfWriter.getInstance(document, new FileOutputStream("D:/" + output + ".pdf"));
			document.open();
			Font f0 = new Font(Font.FontFamily.TIMES_ROMAN,9,Font.NORMAL);
			Font f1 = new Font(Font.FontFamily.TIMES_ROMAN,9,Font.BOLD);
			Font f2 = new Font(Font.FontFamily.TIMES_ROMAN,9,Font.ITALIC);
			for(LineBlock element : lb)
			{
				String strng = element.getLineblockAsString();
				if(element.getFormat() == FormatEnum.BOLD)
				{
					document.add(new Paragraph(strng,f1));
				}
				else if(element.getFormat() == FormatEnum.ITALICS)
				{
					document.add(new Paragraph(strng,f2));
				}
				else
				{
					document.add(new Paragraph(strng,f0));
				}
				document.add(new Paragraph("\n"));
			}
		}catch(Exception e) 
		{
			System.out.println(e);
		}
		document.close();
	}
}