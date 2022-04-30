public class Driver
{
    public static void main(String[] args)
    {  
        Plot2D p = new Plot2D();
        Random2D f = new Random2D(-3, 3);
        p.plot(f);
        try{
			p.saveImage("random.png");
		}catch(Exception e)
		{
			System.out.println("Caught an IOException");
		}
    }  
}
