import java.io.IOException;
import javax.swing.*;

import model.*;
import controller.*;
import view.*;

public class Driver
{
   public static void main(String []args)
   {
      ObservableMovingPoint2D observablePoint = new ObservableMovingPoint2D(10,10);
      PointController controller = new PointController(observablePoint);
      JFrame window = new JFrame("Moving Car");
      try
      {
         MovableImage img = new MovableImage("view/RedCar.png", 500, 500);
         observablePoint.addObserver(img);
         window.add(img);
      }
      catch (IOException e)
      {
         System.out.println(e.getMessage());
      }

      window.addKeyListener(controller);
      window.pack();
      window.setVisible(true);
   }
}
