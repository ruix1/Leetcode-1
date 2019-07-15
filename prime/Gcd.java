package prime;

//(n)

public class Gcd {
	public static int getGCD(int m, int n) {
		if (n == 0) {
			return m;
		} else {
			return getGCD(n, m % n);
		}
	}
	public static void main(String[] args) {
		
		int div = getGCD(90, 60);
		System.out.println("最大公约数为：" + div);
	}
	

}
