public class problem134
{

    public static long match(int p1, int p2)
    {
	int mult = (int)Math.pow(10,Math.ceil(Math.log10(p1)));
	long start = 1;
	long number = start*mult + p1;
	while (!(number % p2 == 0))
	    {
		start++;
		number = start*mult+p1;
	    }

	return number;
    }

    public static void main(String[] args)
    {
	boolean[] primes = new boolean[1000001];
	for(int i = 2; i < primes.length ; i++)
	    {
		if (!primes[i])
		    {
			for(int j = 2*i; j < primes.length ; j+=i)
			    primes[j] = true;
		    }
	    }

	int cPrime = 5;
	long sum = 0;
	for (int i = 6 ; i < primes.length ; i++)
	    {
		if (!primes[i])
		    {
			long matcher = match(cPrime,i);
			sum += matcher;
			cPrime = i;
			System.out.println((i+0.0)/primes.length);
		    }
	    }
	System.out.println(sum);
    }

}