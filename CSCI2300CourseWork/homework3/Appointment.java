import java.util.GregorianCalendar;
import java.util.Calendar;
public class Appointment extends Event
{
	// Attribute of the Appointment class
	private int startBuffer;
	
	// Appointment object constructor
	public Appointment(Contact contactName, String eventDescription)
	{
		organizer = contactName;
		description = eventDescription;
	}
	
	// Method to change startBuffer value
	public void setStartBuffer(int startBuffer)
	{
		this.startBuffer = startBuffer;
	}
	
	// Method to schedule an appointment
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
			
			startTime.add(Calendar.MINUTE, -startBuffer);
			
			endTime = new GregorianCalendar(
				dateAndTime.get(Calendar.YEAR),
				dateAndTime.get(Calendar.MONTH),
				dateAndTime.get(Calendar.DAY_OF_MONTH),
				dateAndTime.get(Calendar.HOUR_OF_DAY),
				dateAndTime.get(Calendar.MINUTE),
				dateAndTime.get(Calendar.SECOND));
				
			endTime.add(Calendar.HOUR, 1);
		}
	}
}
