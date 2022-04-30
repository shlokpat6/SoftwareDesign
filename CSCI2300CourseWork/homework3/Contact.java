public class Contact
{
	// Attributes of the Contact class
	private String name;
	private int phoneNumber;
	
	// Contact object constructor
	public Contact(String name, int phoneNumber)
	{
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	// Method to return the name associated with contact
	public String getName()
	{
		return name;
	}
	
	// Method to return phone number associated with contact
	public int getPhone()
	{
		return phoneNumber;
	}
}
