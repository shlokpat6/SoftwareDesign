import java.util.Scanner;
import java.util.ArrayList;

public class CatalogItemLoaderInteractive extends CatalogItemLoader{
	
	Scanner userInput;
	private Book book;
	private CatalogItem catalogItem;
	private String promptResponse;
	
	public CatalogItemLoaderInteractive()
	{
		userInput = new Scanner(System.in);
		System.out.println("A - add book");
		System.out.println("D - done");
		promptResponse = userInput.nextLine();
	}
	public ArrayList<CatalogItem> loadItems()
	{
		
		while(promptResponse.equals("A"))
		{
			
			System.out.println("Enter title:");
			String title = userInput.nextLine();
			
			System.out.println("Enter author's first name");
			String firstName= userInput.nextLine();
			
			System.out.println("Enter the author's last name");
			String lastName = userInput.nextLine();
			
			System.out.println("Enter library catalog id");
			String id = userInput.nextLine();

			System.out.println("Is the book available? Y/N");
			String available = userInput.nextLine();
			
			book = new Book(title, firstName, lastName);
			
			if(available.equals("Y"))
			{
				catalogItem= new CatalogItem(book, id, true);
				
			}
			else if(available.equals("N"))
			{
				catalogItem= new CatalogItem(book, id, false);
			}
		
			items.add(catalogItem);
			
			System.out.println("A - add book");
			System.out.println("D - done");
			promptResponse = userInput.nextLine();
		}
		return items;
		
	}
	
	
}
