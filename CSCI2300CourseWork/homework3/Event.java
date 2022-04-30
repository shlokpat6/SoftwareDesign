import java.util.GregorianCalendar;
import java.util.Calendar;
public abstract class Event
{
	// Atributes of the Event class
	protected GregorianCalendar startTime;
	protected GregorianCalendar endTime;
	protected Contact organizer;
	protected String description;
	
	// Prints out a human readable version of the event in the eventBook
	public String toString()
	{
		// String variable that will contain the human readable form of the event
		String val;
		
		// Checks if startTime and endTime are null
		if(startTime == null && endTime == null)
		{
			// Val stores the description concatonated with "not scheduled"
			val = description + " not scheduled";
		}
		else
		{
			// Val stores the description concatonated with the start and end date and times
			val = description 
				+ " start " 
				+ String.valueOf(startTime.get(Calendar.YEAR)) 
				+ "/" + String.valueOf(startTime.get(Calendar.MONTH))
				+ "/" + String.valueOf(startTime.get(Calendar.DAY_OF_MONTH)) 
				+ " " + String.valueOf(startTime.get(Calendar.HOUR_OF_DAY)) 
				+ ":" + String.valueOf(startTime.get(Calendar.MINUTE)) 
				+ " end " 
				+ String.valueOf(endTime.get(Calendar.YEAR)) 
				+ "/" 
				+ String.valueOf(endTime.get(Calendar.MONTH)) 
				+ "/" 
				+ String.valueOf(endTime.get(Calendar.DAY_OF_MONTH)) 
				+ " " 
				+ String.valueOf(endTime.get(Calendar.HOUR_OF_DAY)) 
				+ ":" + String.valueOf(endTime.get(Calendar.MINUTE)) ;
		}
		// Returns val
		return val;
		
	}
	// Method checks to see if the event e overlaps with another event
	public boolean overlaps(Event e)
	{
		Event first, second;
		boolean overlap_found = true;
		if (this.startTime.compareTo(e.startTime) < 0)
		{
			first = this;
			second = e;
		}
		else
		{
			first = e;
			second = this;
		}
		if (first.endTime.compareTo(second.startTime) <= 0)
		{
			overlap_found = false;
		}
		return overlap_found;
	}
	
	// An abstract method that will be implemented by the two subclasses
	public abstract void schedule(GregorianCalendar g);
}
