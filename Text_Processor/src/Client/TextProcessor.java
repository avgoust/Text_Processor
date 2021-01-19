package Client;

import datamodel.buildingblocks.Document;
import engine.Engine;

import java.util.List;
import java.util.Scanner;

public class TextProcessor {
    public static void main(String[] args)
    {
        TextProcessor textProcessor = new TextProcessor();
        Engine engine = textProcessor.documentLoad();
        if(engine.getDocument().getDocType() == Document.DocumentRawType.RAW)
        {
            engine.registerInputRuleSetForPlainFiles(engine.getDocument().rulesLoad());
        }
        else
            {
                List<String> prefixes = engine.getDocument().prefixesInput();
                engine.registerInputRuleSetForAnnotatedFiles(engine.getDocument().rulesLoad(),prefixes);
            }
        engine.rulesImplementation();
        engine.exportPdf("OUTPUT");






    }

    public Engine documentLoad()
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Input the path of the file u want to process : ");
        String filePath = input.next();
        

        System.out.println("The default document type is RAW " +
                "\nIf the document type is ANNOTATED write the word \"ANNOTATED\"  ||  Else press 0  ");
       String documentType = "RAW" ;
        if(input.next().equalsIgnoreCase("ANNOTATED"))
            documentType = "ANNOTATED";


        System.out.println("Input file name :");
        String alias = input.next();

        System.out.println("||Confirmation Message : "+documentType+" document Inputted||");
        return new Engine(filePath, documentType, alias);
    }

}
