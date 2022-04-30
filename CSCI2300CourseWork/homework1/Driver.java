import java.util.ArrayList;

public class Driver{
	
	public static int testAdd(){
		
		Catalog catalog1 = new Catalog();
		
		int numErrors = 0;
		
		Book book1 = new Book("Rogue Lawyer", "John", "Grisham");
		
		catalog1.add(book1);
		
		ArrayList<String> foundBooks = catalog1.search("Kate");
		
		if(foundBooks.size() != 1){
			
			System.out.println("Error: search method should have found one book");
			numErrors++;
			
		}
		
		return numErrors;
		
	}
	
	
	public static int testCheckout(){
		
		int numErrors = 0;
		boolean checkedIn;
		
		Catalog catalog2 = new Catalog();
		
		Book book1 = new Book("The Confession", "John", "Grisham");
		Book book2 = new Book("Rogue Lawyer", "John", "Grisham");
		Book book3 = new Book("The Summons", "John", "Grisham");
		
		catalog2.add(book1);
		catalog2.add(book2);
		catalog2.add(book3);
		
		checkedIn = catalog2.checkout("1");
		checkedIn = catalog2.checkout("1");
		
		if (checkedIn != false){
				
			System.out.println("Error: checkout method should have returned false as the book was already checked out");
			
			numErrors++;
		
		}
		
		checkedIn = catalog2.checkin("1");
		checkedIn = catalog2.checkout("1");
		
		if (checkedIn != true){
				
			System.out.println("Error: checkout method should have returned true as the book was checked out before");
			
			numErrors++;
		
		}
		
		return numErrors;
		
	}
	
	
	public static int testCheckin(){
		
		int numErrors = 0;
		boolean checkedIn;
		
		Catalog catalog3 = new Catalog();
		
		Book book1 = new Book("The Confession", "John", "Grisham");
		Book book2 = new Book("Rogue Lawyer", "John", "Grisham");
		Book book3 = new Book("The Summons", "John", "Grisham");
		
		catalog3.add(book1);
		catalog3.add(book2);
		catalog3.add(book3);
		
		checkedIn = catalog3.checkin("1");
		checkedIn = catalog3.checkin("1");
		
		if (checkedIn != false){
				
			System.out.println("Error: checkin method should have returned false as the book was already checked in");
			
			numErrors++;
		
		}
		
		checkedIn = catalog3.checkout("1");
		checkedIn = catalog3.checkin("1");
		
		if (checkedIn != true){
				
			System.out.println("Error: checkin method should have returned true as the book was checked out before");
			
			numErrors++;
		
		}
		
		return numErrors;
	}
	
	
	public static int testSearch(){
		
		int numErrors = 0;
		
		Catalog catalog4 = new Catalog();
		
		Book book1 = new Book("The Confession", "John", "Grisham");
		Book book2 = new Book("Rogue Lawyer", "John", "Grisham");
		Book book3 = new Book("The Summons", "John", "Grisham");
		
		catalog4.add(book1);
		catalog4.add(book2);
		catalog4.add(book3);
		
		ArrayList<String> foundBooks = catalog4.search("John");
		
		if(foundBooks.size() != 3){
			
			System.out.println("Error: search method should have found three book");
			
			numErrors++;
			
		}
		
		return numErrors;
		
	}
	

	public static int testGetBook(){
		
		int numErrors = 0;
		Catalog catalog5 = new Catalog();
		
		Book book1 = new Book("The Confession", "John", "Grisham");
		Book book2 = new Book("Rogue Lawyer", "John", "Grisham");
		Book book3 = new Book("The Summons", "John", "Grisham");
		
		catalog5.add(book1);
		catalog5.add(book2);
		catalog5.add(book3);
		
		if(catalog5.getBook("0").toString().equals(book1.toString())== false){
			System.out.println("The getBook method should have returned the same book");
			numErrors++;
		}
		
		if(catalog5.getBook("4")!=null){
			System.out.println("The getBook method should have returned null");
			numErrors++;
			
		}
		return numErrors;
	}

	
	public static int testRemove(){
		
		int numErrors= 0;
		
		Catalog catalog6 = new Catalog();
		
		Book book1 = new Book("The Confession", "John", "Grisham");
		Book book2 = new Book("Rogue Lawyer", "John", "Grisham");
		Book book3 = new Book("The Summons", "John", "Grisham");
		
		catalog6.add(book1);
		catalog6.add(book2);
		catalog6.add(book3);
		
		catalog6.remove("0");
		
		if(catalog6.getBook("0") != null){
			System.out.println("Error: remove method should have removed the catalog item from with the id 0");
			numErrors++;
		}
		
		return numErrors;
		
	}
	
	
	public static void main(String []args){
		
		int numErrors = 0;
	
		numErrors += testAdd();
		numErrors += testCheckout();
		numErrors += testCheckin();
		numErrors += testSearch();
		numErrors += testGetBook();
		numErrors += testRemove();
		
		if (numErrors > 0){
			System.out.println("Fix your errors");
			
		}
		else{
			System.out.println("No errors were found");
		}
	}
}
