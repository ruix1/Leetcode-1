package prime;

import java.util.Scanner;

public class Test3 {
	static long two = 2;
	
	public static int makeTable(long L, long R)
	{
		
	    boolean[] isPrime=new boolean[1000000000];
	    boolean[] isPrimeSmall=new boolean[100000000];
	    long sqrtR = (long) Math.sqrt(R);
	    
	    for(int i=0;i<=sqrtR;i++){
	    	isPrimeSmall[i]=true;
	    }
	    
		for (int i = 0;i <= R - L;i++)
			isPrime[i] = true;
			
		for ( int i = 2; i <=sqrtR;i++){ 
			if(isPrimeSmall[i]){
			    for(int j=2*i;j<=sqrtR;j+=i){
			    	isPrimeSmall[j]=false;
			    }
			    for (long j = Math.max(two,(L+i-1)/i)*i; j <=R; j += i)
			    {
				isPrime[(int) (j - L)] = false;
			   }
		     }
		}
		
		long count = 0;
			
		for (long  i = 0; i <=R-L+1; i++)
		{
			if (isPrime[(int) i]) 
					count++;
			}
		if(L==1){
			count--;
		}
			
			return (int) count;
		
	}

	public static void  main(String[] args)
	{ 
		while (true){
			Scanner s = new Scanner(System.in);
			long L = s.nextLong();
			long R = s.nextLong();
			System.out.print(makeTable(L, R));
		}
	}

}
	
