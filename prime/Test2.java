package prime;

import java.util.Scanner;

public class Test2 {
	/**
	 * @author ruihan
	 * @param L
	 * @param R
	 * @return
	 */
	

	public static int getPrime(long L, long R)
	{
		long count = R - L+1 ;
	    boolean[] isPrime=new boolean[1000000000];
	   
		
		for (int i = 0;i <R - L+1; i++)
			isPrime[i] = true;
			
		//int sqrtR = (int)Math.sqrt(R);
		
		for (long  i = 2; i*i <=R; i++)
		{
		    long start = L;
			if (L % i != 0)
			{
				start = ((L / i) + 1) * i; 
				//start = ((L+i-1)/i)*i;//大于L的最小的i的倍数
			}
			if (start <i+1){ 
				start = i*2;
				} //start最小应该从i * 2开始
			
			for (long j = start; j <= R; j += i)
			{
				 if (isPrime[(int)(j - L)]){
	                     count--;
	                    isPrime[(int)(j - L)] = false;
	                }
	                else{
	                    continue;
	                }
				
				
			}
		}
		if (L == 1){
			            count --;
			        }
		
		//long count = 0;
		
		//for (long  i = L; i <=R; i++)
		//{
			//if (isPrime[(int)( i-L)]) 
			//	count++;
			//}
		//if(L==1){
		//	count--;
		//}
		
		
	//	for (long  i = 0; i <=R-L+1; i++)
		//{
		//	if (isPrime[(int) i]) 
			//		count++;
			//}
		
			
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
