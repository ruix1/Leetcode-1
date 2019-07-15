package prime;

public class CalculatePrime {
	public static int calculateNumber(int Nmax){
		boolean[] isPrime=new boolean[Nmax+1];
		for(int i=3;i<Nmax;i+=2){//奇数
			isPrime[i]=true;
			isPrime[2]=true;
		}
		for(int i=3;i<=Math.sqrt(Nmax);i+=2){//sqrtn
			if(isPrime[i]){
				for(int j=i*i;j<=Nmax;j+=2*i){//log2n
					isPrime[j]=false;
				}
			}
			
		}
		int primeNum=0;
		for(int i=2;i<=Nmax;i++){
			if(isPrime[i]){
				primeNum++;
			}
			}
		return primeNum;
	}
	public static void main(String[] args){
		final int Nmax=10;
		int primeNum=CalculatePrime.calculateNumber(Nmax);
		System.out.println("the prime numbers from 1 to "+ Nmax +" is "+primeNum);
	}
	
}
