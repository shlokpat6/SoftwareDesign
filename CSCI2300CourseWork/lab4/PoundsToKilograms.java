public class PoundsToKilograms extends Converter
{
    public void setFrom(double from)
    {
        super.setFrom(from);
    }
    
    public void convert()
    {
        to = from/2.205;
    }
    
    public double getConversionResult()
    {
        return super.getConversionResult();
    }
}
