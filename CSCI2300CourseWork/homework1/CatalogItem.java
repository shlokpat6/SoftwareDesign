import java.util.ArrayList;

public class CatalogItem{

	private Book book;
	private String id;
	private boolean availability;

	public CatalogItem(Book book, String id, boolean availability){
		
		this.book = new Book(book.getTitle(), book.getAuthorFirstName(), book.getAuthorLastName());
		this.id = id;
		this.availability = availability;
	
	}
	
	public Book getBook(){
	
		return this.book;
	
	}
	
	public String getId(){
	
		return this.id;
	
	}
	
	public boolean isAvailable(){
	
		return this.availability;
	
	}
	
	public void setAvailable(){
	
		this.availability = true;
	
	}
	
	public void setUnavailable(){
	
		this.availability = false;
	
	}
	
}
