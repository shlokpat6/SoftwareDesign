import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class CatalogItemLoaderCSV extends CatalogItemLoader{
	
	File fileName;
	Scanner userInputCSV;
	private Book book;
	private CatalogItem catalogItem;
	String line = "";
	
	public CatalogItemLoaderCSV(String fileName) throws Exception
	{
		this.fileName= new File(fileName);
		userInputCSV= new Scanner(fileName);
	}
	
	public ArrayList<CatalogItem> loadItems()
	{
		while((line=userInputCSV.nextLine())!= null)
		{
			String[] parsedLine = line.split(",");
			if(parsedLine.length == 5)
			{
				book = new Book(parsedLine[0], parsedLine[1], parsedLine[2]);
				if (Integer.parseInt(parsedLine[4]) == 1)
				{
					catalogItem= new CatalogItem(book, parsedLine[3], true);
					items.add(catalogItem);
				}
				else if(Integer.parseInt(parsedLine[4]) == 0)
				{
					catalogItem= new CatalogItem(book, parsedLine[3], false);
					items.add(catalogItem);
				}
				
			}
	
		}
		
		return items;	
	}

}
