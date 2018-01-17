package flail;

import java.math.BigInteger;

public class Flail {

	public static BigInteger factorial(int n) {
		final BigInteger f = BigInteger.valueOf(n);
		if (n == 0) {
			return BigInteger.valueOf(1);
		} else if (n > 0) {
			return f.multiply(factorial(n - 1));
		} else {
			return BigInteger.valueOf(0);
		}
	}

	public static void main(String[] args) {
		System.out.println(factorial(16000));
	}

}
