package model;
import java.util.ArrayList;

public class ObservableMovingPoint2D extends MovingPoint2D
{
   protected ArrayList<PointObserver> observers;

   public ObservableMovingPoint2D()
   {
      super();
      observers = new ArrayList<PointObserver>();
   }

   public ObservableMovingPoint2D(int x, int y)
   {
      super(x,y);
      observers = new ArrayList<PointObserver>();
   }

   public void notifyObservers()
   {
	  for(int i =0; i < observers.size(); i++)
	  {
		  observers.get(i).update(x,y);
      }
   }

   public void addObserver(PointObserver o)
   {
	   observers.add(o);
   }

   @Override
   public void moveVertically(int length)
   {
      super.moveVertically(length);
      notifyObservers();
   }

   @Override
   public void moveHorizontally(int length)
   {
      super.moveHorizontally(length);
      notifyObservers();
   }
}
