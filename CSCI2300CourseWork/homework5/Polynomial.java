import java.lang.Math;
public class Polynomial implements Function2D
{
	//Array, whose indices(degrees) are linked to coefficients
	private double[] arrayOfCoefficients;
	
	//Constructor
	public Polynomial(double[] coefficients, int []exponents)
	{
		int max = 0;
		for (int i = 0; i < exponents.length; i++)
		{
			if (max < exponents[i])
			{
				max = exponents[i];
			}
		}
		
		arrayOfCoefficients = new double[max+1];
		
		for (int i =0; i < exponents.length; i++)
		{
			arrayOfCoefficients[exponents[i]] = coefficients[i];
		}
	}
	
	//Evaluates and returns the polynomial with the given x
	public double eval(double x)
	{
		double sum = 0;
		for(int i = 0; i < arrayOfCoefficients.length; i++)
		{
			sum += arrayOfCoefficients[i] * Math.pow(x,i);
		}
		return sum;
	}
	
	//Returns the coefficient paired with the given degree
	public double getCoefficient(int degree)
	{
		return arrayOfCoefficients[degree];
	}
	
	//Returns the highest degree not paired with a coefficient of zero
	public int getMaxDegree()
	{
		int maxDegree = 0;
		for (int i = (arrayOfCoefficients.length-1); i >= 0; i--)
		{
			if(arrayOfCoefficients[i] != 0)
			{
				maxDegree = i;
				break;
			}
		}
		return maxDegree;
	}
}
