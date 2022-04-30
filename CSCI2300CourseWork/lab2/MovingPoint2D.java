/*
 *  Class that defines a point in 2D
 **/

public class MovingPoint2D extends Point2D
{

   public MovingPoint2D()
   {
      super();
   }

   public MovingPoint2D(int x, int y)
   {
      super(x,y);
   }

   public void moveVertically(int length)
   {
      y = y + length;
   }

   public void moveHorizontally(int length)
   {
      x = x + length;
   }
   
}
