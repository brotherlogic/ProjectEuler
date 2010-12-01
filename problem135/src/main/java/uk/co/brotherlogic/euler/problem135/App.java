package uk.co.brotherlogic.euler.problem135;

/**
 * Hello world!
 * 
 */
public class App
{

   public static void main(String[] args) throws Exception
   {
      long sTime = System.currentTimeMillis();
      App app = new App();
      int count = 0;
      for (int i = 1; i < 100000; i++)
      {
         if (app.getCount(i) == 1155)
            count++;
      }
      System.out.println(count);
   }

   public int[][] buildMatrix(int maxX, int maxAdd)
   {
      int[][] ret = new int[maxX][maxAdd];

      for (int x = 0; x < maxX; x++)
         for (int add = 0; add < maxAdd; add++)
            ret[x][add] = (x + 2 * add) * (x + 2 * add) - (x + add) * (x + add) - x * x;

      return ret;
   }

   public double[] computeRoot(long a, long b, long c)
   {
      double val = Math.sqrt(b * b - 4 * a * c);
      // System.out.println(a + "," + b + "," + c);
      // System.out.println("VAL = " + val + " given " + (b * b - 4 * a * c));

      return new double[]
      { (-b + val) / (2 * a), (-b - val) / (2 * a) };
   }

   public int getCount(int n)
   {
      int count = 0;

      for (int y = 1; y < 10000; y++)
      {
         double[] rts = computeRoot(1, -2 * y, -(3 * y * y - n));
         for (double rt : rts)
         {
            if (rt < Double.MAX_VALUE && rt > 0)
               if (((int) (Math.floor(rt)) == ((int) Math.ceil(rt))))
               {

                  count++;
               }
         }
      }
      return count;
   }
}
