/*
 * This is the driver class that utilizes the Circle2D and Point2D classes
*/
public class Driver{
	public static void main(String []args){
	
		Point2D s = new Point2D(1,2);
		
		double radiusVal = 4;
		
		Circle2D circle = new Circle2D(s, radiusVal);
		
		System.out.println(circle);
	}
}
