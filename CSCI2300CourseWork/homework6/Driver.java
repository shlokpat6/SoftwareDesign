public class Driver
{
    public static void main(String[] args)
    {  
        Plot2D myPlot = new Plot2D();
        Random2D r = new Random2D(-6, 0);
        Constant2D c = new Constant2D(5);
        double []coeff = {1};
        int []exponent = {2};
        Polynomial p = new Polynomial(coeff, exponent);
        myPlot.plot(p);
        myPlot.plot(c);
        myPlot.plot(r);
        try{
			myPlot.saveImage("functions2D.png");
		}catch(Exception e)
		{
			System.out.println("Caught an IOException");
		}
		myPlot.close();
    }  
}
