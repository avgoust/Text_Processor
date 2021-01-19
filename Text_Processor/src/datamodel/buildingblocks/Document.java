package datamodel.buildingblocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Document {

	private DocumentRawType docType;
	private String filePath;
	private List<LineBlock> document = new ArrayList<LineBlock>();
	
	public enum DocumentRawType {
		RAW, ANNOTATED
	}

	public Document(String filePath, DocumentRawType docType) {
		this.filePath = filePath;
		this.docType = docType;
	}

	public List<LineBlock> getLineBlock() {
		return document;
	}

	public DocumentRawType getInputFileType() {
		return docType;
	}



	public List<List<String>> rulesLoad()
	{
		Scanner input = new Scanner(System.in);
		List<List<String>> inputSpec = new ArrayList<>();
		List<String> currentRulesBlock = new ArrayList<>();

		int count = 1;

		System.out.println("\n-------------------------------------------|| Document Format Rules || -------------------------------------------");




			do {

				System.out.println("\nRule " + (count++) + " Input parameters -->\n" +
						"\n1) Input style of heading : ");

				String string = input.nextLine();

				currentRulesBlock.add(string);
				System.out.println("2) Input when the rule is activated : ");
				string = input.nextLine();

				String rule2AllCapsCheck = string;
				currentRulesBlock.add(rule2AllCapsCheck);
				if (!rule2AllCapsCheck.equals("ALL_CAPS"))
				{
					System.out.println("3) Input the value pertaining to the rule:");
					string = input.nextLine();
					currentRulesBlock.add(string);


				}

				inputSpec.add(currentRulesBlock);
				currentRulesBlock = new ArrayList<>();




				System.out.println("Do you wish to proceed adding rules ? || Input yes or no");
			} while (input.next().equalsIgnoreCase("yes"));


			System.out.println("\n-------------------------------------------||Rules Recap ||-------------------------------------------\n");

			count = 1;
			for(List<String> element : inputSpec)
			{
				System.out.print("Rule "+(count++)+" :	");
				System.out.println(element);
			}




			return  inputSpec;

	}

	public DocumentRawType getDocType()
	{
		return docType;
	}

	public List<String> prefixesInput()
	{
		ArrayList<String> prefixesArrayList = new ArrayList<>();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of prefixes :");
		int numberOfPrefixes = input.nextInt();
		for(int i=0; i<numberOfPrefixes; i++)
		{
			System.out.println("Input the "+i+" prefix");
			prefixesArrayList.add(input.next());
		}

		return prefixesArrayList;

	}

	public void statsReport()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Do you want to create a stats report ?  || Input yes or no ");
		if(!input.next().equalsIgnoreCase("yes"))
		{
			return;
		}





	}

}
