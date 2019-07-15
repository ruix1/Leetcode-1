package prime;

public class Pow {

	public static double myPow(double x, int n) {
        if (n < 0) return 1 / power(x, -n);
        return power(x, n);
    }
    public static double power(double x, int n) {
        if (n == 0) return 1;
        double half = power(x, n / 2);
        if (n % 2 == 0)
        	return half * half;
        return x * half * half;
    }
public static void main(String[] args) {
		
		double div = power(2, 10);
		System.out.println("：" + div);
	}
}
