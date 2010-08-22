package uk.co.brotherlogic.euler;

/**
 * Hello world!
 *
 */
public class App 
{
	public double testNumber(int p1, int p2)
	{
		int base = ((int)Math.log10(p1))+1;
		
		int start = 1;
		double mult = Math.pow(10, base);
		double val = mult+p1;
		while (val % p2 != 0)
			val+=mult;
		
		return start ;
	}
	
	public int[] generatePrimes()
	{
		int pCount = 0;
		boolean[] arr = new boolean[1000001];
		
		//Pre fill
		for(int i = 2 ; i < arr.length ; i++)
			if  (!arr[i])
			{
				pCount++;
				for(int j = 2*i ; j < arr.length ; j+= i)
					arr[j] = true;
			}
		
		int[] pArr = new int[pCount-2];
		int pointer = 0;
		for(int i = 5 ; i < arr.length ; i++)
			if (!arr[i])
				pArr[pointer++] = i;
		
		return pArr;
	}	
	
    public static void main( String[] args )
    {
    	long sTime = System.currentTimeMillis();
      App app = new App();
      int[] pArr = app.generatePrimes();
      int count = 0;
      for(int i = 0 ; i < pArr.length-1 ; i++)
      {
    	  System.out.println((i+0.0)/pArr.length);
    	  count +=  app.testNumber(pArr[i],pArr[i+1]);
      }
      System.out.println(count);
      System.out.println("Time = " + (System.currentTimeMillis() - sTime)/1000);
    }
}
