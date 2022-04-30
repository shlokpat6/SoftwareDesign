import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.Calendar;
public class EventBook
{
	// Attribute of the eventBook class
	private ArrayList<Event> events;
	
	// eventBook object constructor
	public EventBook()
	{
		events = new ArrayList<Event>();
	}
	
	/*Method adds an event to the eventBook if that event does not overlap with 
	 *the events in the eventBook.
	*/
	public boolean addEvent(Event event, GregorianCalendar dateAndTime)
	{
		int numOverlaps = 0;
		boolean eventAdded = true; 
		event.schedule(dateAndTime);
		if (events.size() == 0){
			events.add(event);
			eventAdded = true;
		}
		else
		{
			for (int i = 0; i < events.size(); i++)
			{
				if ((events.get(i).overlaps(event)) == true)
				{
					numOverlaps += 1;
				}
			}
			if (numOverlaps > 0)
			{
				event.schedule(null);
				eventAdded = false;
			}
			else
			{
				events.add(event);
				eventAdded = true;
			}
		}
		return eventAdded;
	}
	
	/* Method checks for events in the events ArrayList that have same date as g.
	 * An Arraylist filled with events with these events is returned.
	*/
	public ArrayList<Event> getEventsForDate(GregorianCalendar g)
	{
		ArrayList<Event> eventsForToday = new ArrayList<Event>();
		for (int i = 0; i < events.size(); i++)
		{
			if(g.get(Calendar.MONTH) == events.get(i).startTime.get(Calendar.MONTH))
			{
				if(g.get(Calendar.DAY_OF_MONTH) == events.get(i).startTime.get(Calendar.DAY_OF_MONTH))
				{
					eventsForToday.add(events.get(i));
				}
			}
		}
		return eventsForToday;
	}
}
