/*
*Class defines a circle in 2D
*/

public class Circle2D{

	private Point2D center;
	private double radius;
	
	public Circle2D(){
		this.center = new Point2D();
		this.radius = 0;
	}
	
	public Circle2D(Point2D s, double r){
		this.center = new Point2D(s.getX(), s.getY());
		this.radius = r;
	}
	
	public String toString(){
	
		String val = "Circle with radius " + radius + " centered at " + center.toString();
		
		return val;
	}
}
