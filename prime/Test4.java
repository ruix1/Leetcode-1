package prime;

import java.util.Scanner;

public class Test4 {

	
	
	    public static long getPrime(long L, long R) {
	        long count = R - L + 1;
	       
	        boolean[] isPrime=new boolean[1000000000];
	        if (L == 1){
	            count --;
	        }
	        
	        
	        for (int i = 0;i < R - L + 1; i++){
	            isPrime[i] = true;
	        }

	        for (long i = 2; i*i <= R; i++){
	            long start = L;
	            
	            if (start % i != 0){
	                start = ((start / i) + 1) * i;//大于L的最小的i的倍数
	            }

	            if (start < (i + 1)){
	                start = i*2;   //start最小应该从i * 2开始
	            }
	            
	            for (long j = start; j <= R; j += i){
	                if (isPrime[(int)(j - L)]){
	                	count--;
	                    isPrime[(int)(j - L)] = false;
	                }
	                else{
	                    continue;
	                }
	            }

	        }
	        
	        
	        return count;
	      //long count = 0;
			
			//for (long  i = L; i <=R; i++)
			//{
				//if (isPrime[(int)( i-L)]) 
				//	count++;
				//}

	    }


	    public static void  main(String[] args)
	    {
	        while (true){
	           
	            Scanner s = new Scanner(System.in);
	            long start = s.nextLong();
	            long end = s.nextLong();
	            System.out.println(getPrime(start, end));
	        }

	    }

	}


