package prime;

public class Gcd2 {

	public static int getGCD(int a, int b) {
		while(b!=0){
			int temp=b;
			b=a%b;
			a= temp;
			
		}
		 return a;
	}
	public static void main(String[] args) {
		
		int div = getGCD(90, 60);
		System.out.println("最大公约数为：" + div);
	}
	
	
}
