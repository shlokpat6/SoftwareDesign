import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class CatalogTest
{
	// Declare catalog object;
	Catalog catalog;
	
	// Initialize catalog object before each test method
	@Before
	public void setUp()
	{
		catalog = new Catalog();
	}
	
	// Checks to see if the catalog size increases when a book is added
	@Test
	public void addIncreasesCatalogSize()
	{
		catalog.add(new Book("Hello world", "Kate", "Holdener"));
		ArrayList<String> foundBooks = catalog.search("Kate");
		assertEquals("add(Book b) ", 1, foundBooks.size());
	}
	
	// Checks to see if the add method increases id sequentially
	@Test
	public void addSequentially()
	{
		catalog.add(new Book("Hello world", "Kate", "Holdener"));
		Book book1 = new Book("Rogue Lawyer", "John", "Grisham");
		catalog.add(book1);
		Book book2 = catalog.getBook("2");
		assertEquals("add(Book b) ", book1.toString(), book2.toString());
	}
	
	/* Checks if the search method compares the search term against the 
	 * author's first name. If it does, the returned arrayList should
	 * be of size one.
	*/
	@Test
	public void searchFirstName()
	{
		catalog.add(new Book("Rogue Lawyer", "John", "Grisham"));
		ArrayList<String> foundBooks = catalog.search("John");
		assertEquals("search(String searchTerm) ", 1, foundBooks.size());
	}
	
	/* Checks if the search method compares the search term against the 
	 * book's title. If it does, the returned arrayList should
	 * be of size one.
	*/
	@Test
	public void searchTitle()
	{
		catalog.add(new Book("Rogue Lawyer", "John", "Grisham"));
		ArrayList<String> foundBooks = catalog.search("Rogue Lawyer");
		assertEquals("search(String searchTerm) ", 1, foundBooks.size());
	}
	
	/* Checks if the search method compares the search term against the 
	 * author's last name. If it does, the returned arrayList should
	 * be of size one.
	*/
	@Test
	public void searchLastName()
	{
		catalog.add(new Book("Rogue Lawyer", "John", "Grisham"));
		ArrayList<String> foundBooks = catalog.search("Grisham");
		assertEquals("search(String searchTerm) ", 1, foundBooks.size());
	}
	
	/* Checks if the search method compares the search term against the 
	 * author's first name and title. If it does, the returned arrayList should
	 * be of size zero.
	*/
	@Test
	public void searchTermLowerCase()
	{
		catalog.add(new Book("Rogue Lawyer", "John", "Grisham"));
		catalog.add(new Book("John", "Rogue Lawyer", "Grisham"));
		ArrayList<String> foundBooks = catalog.search("john");
		assertEquals("search(String searchTerm) ", 0, foundBooks.size());
	}
	
	/* Checks if the search method can find two books with the same 
	 * exact attributes. If it does, the returned arrayList should 
	 * only be of size two. It should not matter if John appears as all
	 * three attributes for the book. 
	 */
	@Test
	public void searchBooks()
	{
		catalog.add(new Book("John", "John", "John"));
		catalog.add(new Book("John", "John", "John"));
		ArrayList<String> foundBooks = catalog.search("John");
		assertEquals("search(String searchTerm) ", 2, foundBooks.size());
	}
	
	/* Checks to make sure the search method does not find any books
	 * via a given search term that does not appear as on the book's 
	 * attributes. The returned array size should remain zero.
	 */
	@Test
	public void searchNoMatches()
	{
		catalog.add(new Book("Hello world", "Kate", "Holdener"));
		ArrayList<String> foundBooks = catalog.search("John");
		assertEquals("search(String searchTerm) ", 0, foundBooks.size());
	}
	
	/* Checks to see if the search method checks the search term against
	 * the entire Title, First Name, or Last Name. It does not count if
	 * the search term only matches with a fragment in any of those 
	 * attributes. In this case, the search method should return zero.
	*/
	@Test
	public void searchFragments()
	{
		catalog.add(new Book("Hello world", "Kate", "Holdener"));
		ArrayList<String> foundBooks = catalog.search("Hello");
		assertEquals("search(String searchTerm) ", 0, foundBooks.size());
	}
	
	/* Checks to see if the checkin method returns false if there is no
	 * book with the search id, 1.
	 */
	@Test
	public void checkInNoBooks()
	{
		boolean result = catalog.checkin("1");
		assertEquals("checkin(String id) ", false, result);
	}
	
	/* Checks to see if the checkin method returns false if the book is 
	 * being checked in right after being added to the catalog.
	 */
	@Test
	public void checkInAfterAdded()
	{
		catalog.add(new Book("Hello world", "Kate", "Holdener"));
		boolean result = catalog.checkin("1");
		assertEquals("checkin(String id) ", false, result);
	}
	
	/* Checks to see if the checkin method returns true if the book is 
	 * being checked in right after being checkedout.
	 */
	@Test
	public void checkInAfterCheckOut()
	{
		catalog.add(new Book("Hello world", "Kate", "Holdener"));
		catalog.checkout("1");
		boolean result = catalog.checkin("1");
		assertEquals("checkin(String id) ", true, result);
	}
	
	/* Checks to make sure checkIn method returns false if it is called
	 * consecutively.
	 */
	@Test
	public void checkInConsecutively()
	{
		catalog.add(new Book("Hello world", "Kate", "Holdener"));
		catalog.checkin("1");
		boolean result = catalog.checkin("1");
		assertEquals("checkin(String id) ", false, result);
	}
	
	/* Checks to make sure checkout method returns false if it is passed
	 * a book id that does not exist.
	 */
	@Test
	public void checkOutNoBook()
	{
		boolean result = catalog.checkout("1");
		assertEquals("checkout(String id) ", false, result);
	}
	
	/* Checks to make sure checkout method returns true if it is called 
	 * on a book that was just added.
	 */
	@Test
	public void checkOutAfterAdded()
	{
		catalog.add(new Book("Hello world", "Kate", "Holdener"));
		boolean result = catalog.checkout("1");
		assertEquals("checkout(String id) ", true, result);
	}
	
	/* Checks to make sure checkout method returns true if it is called 
	 * on a book that was checkedin.
	 */
	@Test
	public void checkOutAfterCheckedIn()
	{
		catalog.add(new Book("Hello world", "Kate", "Holdener"));
		catalog.checkout("1");
		boolean result = catalog.checkout("1");
		assertEquals("checkout(String id) ", true, result);
	}
	
	/* Checks to see if checkout method returns false after being called
	 * twice on the same book.
	 */
	@Test
	public void checkOutConsecutively()
	{
		catalog.add(new Book("Hello world", "Kate", "Holdener"));
		catalog.checkout("1");
		boolean result = catalog.checkout("1");
		assertEquals("checkout(String id) ", false, result);
	}
	
	/* Checks to see if the getbook method returns a book when there is
	 * only one book.
	 */
	@Test
	public void getBookOneBookInCatalog()
	{
		Book book1 = new Book("Hello world", "Kate", "Holdener");
		catalog.add(book1);
		Book book2 = catalog.getBook("1");
		assertEquals("getBook(String id) ", book1.toString(), book2.toString());
	}
	
	/* Checks to see if the getbook method returns null if called on an 
	 * empty catalog.
	 */
	@Test
	public void getBookEmptyCatalog()
	{
		Book book = catalog.getBook("1");
		assertEquals("getBook(String id) ", null, book);
	}
	
	/* Checks to see if the getBook method returns the correct book
	 * when there is more than 1 book in the catalog.
	 */
	@Test
	public void getBookMultipleBooksInCatalog()
	{
		Book book1 = new Book("Hello world", "Kate", "Holdener");
		Book book2 = new Book("Rogue Lawyer", "John", "Grisham");
		catalog.add(new Book("Hello world", "Kate", "Holdener"));
		catalog.add(new Book("Rogue Lawyer", "John", "Grisham"));
		Book book3 = catalog.getBook("2");
		assertEquals("getBook(String id) ", book2.toString(), book3.toString());
	}
	
	/* Checks to see if the remove method returns false after the book is
	 * checked out.
	 */
	@Test
	public void removeReturnsFalseAfterCheckout()
	{
		catalog.add(new Book("Hello world", "Kate", "Holdener"));
		catalog.checkout("1");
		boolean removed = catalog.remove("1");
		assertEquals("getBook(String id) ", false, removed);
	}
	
	/* Checks to see if the remove method returns true after the book is
	 * checked in.
	 */
	@Test
	public void removeReturnsFalseAfterCheckin()
	{
		catalog.add(new Book("Hello world", "Kate", "Holdener"));
		catalog.checkin("1");
		boolean removed = catalog.remove("1");
		assertEquals("getBook(String id) ", true, removed);
	}
	
	
	/* Checks to see if the remove method returns true after being
	 * called on a book that exists.
	 */
	@Test
	public void removeReturnsTrue()
	{
		catalog.add(new Book("Hello world", "Kate", "Holdener"));
		boolean result = catalog.remove("1");
		assertEquals("remove(String id) ", true, result);
	}
	
	/* Checks to see if the remove method returns false after being 
	 * called on a book that does not exists in the catalog
	 */
	@Test
	public void removeReturnsFalse()
	{
		catalog.add(new Book("Rogue Lawyer", "John", "Grisham"));
		boolean result = catalog.remove("2");
		assertEquals("remove(String id) ", false, result);
	}
	
	/* Checks to see if the remove method removes the correct book.
	 */
	@Test
	public void removeCorrectBookFromFront()
	{
		Book book1 = new Book("Hello world", "Kate", "Holdener");
		catalog.add(book1);
		catalog.add(new Book("Rogue Lawyer", "John", "Grisham"));
		catalog.remove("2");
		Book book2 = catalog.getBook("1");
		assertEquals("remove(String id) ", book1.toString() , book2.toString());
	}
	
	/* Checks to see if the remove method removes the correct book.
	 */
	@Test
	public void removeCorrectBookFromBack()
	{
		catalog.add(new Book("Rogue Lawyer", "John", "Grisham"));
		Book book2 = new Book("Hello world", "Kate", "Holdener");
		catalog.add(book2);
		catalog.remove("1");
		Book book3 = catalog.getBook("2");
		assertEquals("remove(String id) ", book2.toString() , book3.toString());
	}
	
	/* Checks to see if the remove method removes the book from the 
	 * catalog. If it does, the search method should return zero when
	 * called.
	 */
	@Test
	public void removeCatalogShrinks()
	{
		catalog.add(new Book("Hello world", "Kate", "Holdener"));
		boolean result = catalog.remove("1");
		ArrayList<String> foundBooks = catalog.search("Kate");
		assertEquals("remove(String id) ", 0, foundBooks.size());
	}
}
