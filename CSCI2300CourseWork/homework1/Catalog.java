import java.util.ArrayList;

public class Catalog{
	
	private int addCount;
	private String addCountStrings;
	ArrayList<CatalogItem> bookCatalog;
	CatalogItem item;
	ArrayList<String> searchCatalog;
	
	public Catalog(){
	
		bookCatalog = new ArrayList<CatalogItem>();
	
	}
	
	public void add(Book book){

		addCountStrings = String.valueOf(addCount);
		
		item = new CatalogItem(book, addCountStrings, true);
		
		addCount+=1;
	
		bookCatalog.add(item);
	
	}
	
	public boolean checkout(String id){
	
		boolean bookPresent= false;
		String tempId;
	
		for (int i = 0; i < bookCatalog.size(); i++){
		
			tempId = bookCatalog.get(i).getId();
		
			if (tempId.equals(id)){
			
				if (bookCatalog.get(i).isAvailable()==true){
				
					bookCatalog.get(i).setUnavailable();
					
					bookPresent = true;
					
				}
				
			}
				
		}
		return bookPresent;
	
	}
	
	public boolean checkin(String id){
	
		boolean bookPresent= false;
		String tempId;
	
		for (int i = 0; i < bookCatalog.size(); i++){
		
			tempId = bookCatalog.get(i).getId();
		
			if (tempId.equals(id)){
			
				if (bookCatalog.get(i).isAvailable()==false){
				
					bookCatalog.get(i).setAvailable();
					
					bookPresent = true;
					
				}
				
			}
				
		}
		return bookPresent;
	
	}
	
	public ArrayList<String> search(String searchTerm){
	
		searchCatalog = new ArrayList<String>();
		
		for (int i = 0; i < bookCatalog.size(); i++){
			
			Book book = item.getBook();
			String title = book.getTitle();
			String lastName = book.getAuthorLastName();
			String firstName = book.getAuthorFirstName();
			
			if (title.equals(searchTerm) || lastName.equals(searchTerm) || firstName.equals(searchTerm));{
				
				searchCatalog.add(bookCatalog.get(i).getId());
				
			}
		
		}
		
		return searchCatalog;
		
	}
	
	public Book getBook(String id){
		boolean bookPresent = false;
		String tempId;
		
		for (int i = 0; i < bookCatalog.size(); i++){
		
			tempId = bookCatalog.get(i).getId();
			
			if (tempId.equals(id)){
				bookPresent = true;
				return bookCatalog.get(i).getBook();
				
			}
			
		}
		
		return null;
	}
	
	public boolean remove(String id){
	
		boolean present= false;
		String tempId;
	
		for (int i = 0; i < bookCatalog.size(); i++){
		
			tempId = bookCatalog.get(i).getId();
			
			if (tempId.equals(id)){
				
				present= true;
				
				bookCatalog.remove(i);
				
			}		
			
		}
		
		return present;
		
	}
	
}
