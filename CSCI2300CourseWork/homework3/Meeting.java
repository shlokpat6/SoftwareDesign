import java.util.GregorianCalendar;
import java.util.Calendar;
public class Meeting extends Event
{
	// Attribute of the Meeting class
	private int endBuffer;
	
	// Meeting object constructor
	public Meeting(Contact contactName, String eventDescription)
	{
		organizer = contactName;
		description = eventDescription;
	}
	
	// Method to change endBuffer value
	public void setEndBuffer(int endBuffer)
	{
		this.endBuffer = endBuffer;
	}
	
	// Method to schedule a meeting
	public void schedule(GregorianCalendar dateAndTime)
	{
		if(dateAndTime == null)
		{
			startTime = null;
			endTime = null;
		}
		else
		{
			startTime = new GregorianCalendar(
				dateAndTime.get(Calendar.YEAR),
				dateAndTime.get(Calendar.MONTH),
				dateAndTime.get(Calendar.DAY_OF_MONTH),
				dateAndTime.get(Calendar.HOUR_OF_DAY),
				dateAndTime.get(Calendar.MINUTE),
				dateAndTime.get(Calendar.SECOND));
				
			endTime = new GregorianCalendar(
				dateAndTime.get(Calendar.YEAR),
				dateAndTime.get(Calendar.MONTH),
				dateAndTime.get(Calendar.DAY_OF_MONTH),
				dateAndTime.get(Calendar.HOUR_OF_DAY),
				dateAndTime.get(Calendar.MINUTE),
				dateAndTime.get(Calendar.SECOND));
				
			endTime.add(Calendar.HOUR, 1);
			endTime.add(Calendar.MINUTE, endBuffer);
		}
	}
}
