import java.util.Random;
public class Random2D implements Function2D
{
   private double min;
   private double max;
   Random randomGenerator;   
   public Random2D(double min, double max)
   {
      randomGenerator = new Random();
      this.min = min;
      this.max = max;
   }
   
   public double eval(double x)
   {
	   double scaledValue = 0;
	   boolean bool = randomGenerator.nextBoolean();
	   double value = randomGenerator.nextDouble();
	   if(bool == true)
	   {
		   scaledValue = value*this.max;
	   }
	   else
	   {
		   scaledValue = value*this.min;
       }
       return scaledValue;
   }


}
