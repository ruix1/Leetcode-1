package prime;
import java.util.Scanner;
public class Test5 {
	

	

	
		/**
		 * @author ruihan
		 * @param L
		 * @param R
		 * @return
		 */
		

		public static int getPrime(long L, long R)
		{
			
		    boolean[] isPrime=new boolean[1000000000];
			for (int i = 0;i <= R - L; ++i)
				isPrime[i] = true;
				
			//int sqrtR = (int)Math.sqrt(R);
			
			for (long  i = 2; i*i <= R; ++i)
			{
			    long start = L;
				if (L % i != 0)
				{
					start = ((L / i) + 1) * i; 
					//start = ((L+i-1)/i)*i;//大于L的最小的i的倍数
				}
				if (start < i ){ 
					start = i*2;
					} //start最小应该从i * 2开始
				
				for (long j = start; j < R; j += i)
				{
					isPrime[(int) (j - L)] = false;
				}
			}
			long count = 0;
				
			for (long  i = L; i <= R; ++i)
			{
				if (isPrime[(int) (i-L)]) 
						++count;
				}
				
				return (int) count;
			
		}

		public static void  main(String[] args)
		{ 
			while (true){
				Scanner s = new Scanner(System.in);
				long start = s.nextLong();
				long end = s.nextLong();
				System.out.print(getPrime(start, end));
			}	
			
		}

	}


