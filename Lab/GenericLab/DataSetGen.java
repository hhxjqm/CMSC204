/**
   Computes the average of a set of data values.
*/
public class DataSetGen <T extends Measurable>
{
   private double sum;
   private T maximum;
   private int count;

   /**
      Constructs an empty data set.
   */
   public DataSetGen()
   {
      sum = 0;
      count = 0;
      maximum = null;
   }

   /**
      Adds a data value to the data set.
      @param x a data value
   */
   public void add(T x)
   {
      sum = sum + x.getMeasure();
      if (count == 0 || maximum.getMeasure() < x.getMeasure())
         maximum = x;
      count++;
   }

   /**
      Gets the average of the added data.
      @return the average or 0 if no data has been added
   */
   public double getAverage()
   {
      if (count == 0) return 0;
      else return sum / count;
   }

   /**
      Gets the largest of the added data.
      @return the maximum or 0 if no data has been added
   */
   public T getMaximum()
   {
      return maximum;
   }
}