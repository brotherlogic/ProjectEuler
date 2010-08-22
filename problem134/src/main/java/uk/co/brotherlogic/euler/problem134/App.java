package uk.co.brotherlogic.euler.problem134;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {
		long sTime = System.currentTimeMillis();
		App app = new App();
		int[] pArr = app.generatePrimes();
		long count = 0;
		for (int i = 0; i < pArr.length - 1; i++) {
			count += app.testNumber(pArr[i], pArr[i + 1]);
			System.out.println(count + " " + Long.MAX_VALUE + " and " + pArr[i]
					+ ", " + pArr[i + 1]);
		}
		System.out.println(count);
		System.out.println("Time = " + (System.currentTimeMillis() - sTime)
				/ 1000);
	}

	public int[] generatePrimes() {
		int pCount = 0;
		boolean[] arr = new boolean[1000005];

		// Pre fill
		for (int i = 2; i < arr.length; i++)
			if (!arr[i]) {
				pCount++;
				for (int j = 2 * i; j < arr.length; j += i)
					arr[j] = true;
			}

		int[] pArr = new int[pCount - 2];
		int pointer = 0;
		for (int i = 5; i < arr.length; i++)
			if (!arr[i])
				pArr[pointer++] = i;

		return pArr;
	}

	public long testNumber(int p1, int p2) {

		long mult = (long) Math.pow(10, ((int) Math.log10(p1)) + 1);
		long val = mult + p1;
		while (val % p2 != 0)
			val += mult;

		if (val < 0) {
			System.err.println("OVERFLOW: " + p1 + " and " + p2);
			System.exit(1);
		}
		return val;
	}
}
