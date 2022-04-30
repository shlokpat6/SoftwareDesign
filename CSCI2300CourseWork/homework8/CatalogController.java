import java.util.ArrayList;
import java.util.Iterator;

public class CatalogController
{
	//Declare objects
	protected Catalog catalog;
	protected CatalogUserInterface catalogUserInterface;
	private ArrayList<String> foundBooksIds;
	private ArrayList<Book> foundBooks;
	
	//Constructor for CatalogController class
	public CatalogController(Catalog catalog, CatalogUserInterface catalogUserInterface)
	{
		this.catalog = catalog;
		this.catalogUserInterface = catalogUserInterface;
	}
	
	/* Method that is run when the search button is clicked.
	 * Searches the catalog for items that contain the search term.
	*/
	public void searchSpecificTerm(String searchTerm)
	{
		foundBooksIds = this.catalog.search(searchTerm);
		foundBooks = new ArrayList<Book>();

		for ( int i = 0; i < foundBooksIds.size(); i++)
		{
			foundBooks.add(this.catalog.getBook(foundBooksIds.get(i)));
		}
		catalogUserInterface.showBooks(foundBooks);
	}

	/* Method that is run when the show all books button is clicked.
	 * Searches for all the items in the catalog.
	*/
	public void searchAllBooks()
	{
		Iterator<CatalogItem> catalogIterator = this.catalog.iterator();
		foundBooks = new ArrayList<Book>();
		while (catalogIterator.hasNext())
		{
			CatalogItem catalogItem = catalogIterator.next();
			foundBooks.add(catalogItem.getBook());
		}
		catalogUserInterface.showBooks(foundBooks);
		
	}
}
