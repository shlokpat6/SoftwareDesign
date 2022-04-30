import java.util.ArrayList;

public class Book{
	
	private String title;
	private String authorFirstName;
	private String authorLastName;
	
	public Book(String title, String firstName, String lastName){
	
		this.title = title;
		authorFirstName = firstName;
		authorLastName = lastName;
	}
	
	public String getTitle(){
		
		return title;
	
	}
	
	public String getAuthorFirstName(){
		
		return authorFirstName;
	
	}
	
	public String getAuthorLastName(){
		
		return authorLastName;
	
	}
	
	public String toString(){
	
		String val = title + ", " + authorLastName + ", " + authorFirstName;
		
		return val;
		
	}
}
