public class MilesToKilometers extends Converter
{
    public void setFrom(double from)
    {
        super.setFrom(from);
    }
    
    public void convert()
    {
        to = from * 1.609;
    }
    
    public double getConversionResult()
    {
        return super.getConversionResult();
    }
}
