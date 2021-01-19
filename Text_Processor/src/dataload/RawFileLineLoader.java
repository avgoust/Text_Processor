package dataload;

import datamodel.buildingblocks.LineBlock;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;


public class RawFileLineLoader
{
	public void fileLoad(String filePath, List<LineBlock> lineBlocks)
	{

		try
		{
			File file = new File(filePath);
			Scanner scanner = new Scanner(file);
			LineBlock lineBlock = new LineBlock();

			while (scanner.hasNextLine())
			{
				String input = scanner.nextLine();
				if(input.equals(""))
				{
					lineBlocks.add(lineBlock);
					lineBlock = new LineBlock();
					continue;
				}
				lineBlock.setLines(input);

			}



		}
		catch (FileNotFoundException e)
		{
			System.out.println("File not Found !");
		}


	}

}
