import java.math.BigInteger;

public class Problem25 {

    public static String Fib(int n) {
        BigInteger[] fib = new BigInteger[n];
        fib[0] = BigInteger.ONE;
        fib[1] = BigInteger.ONE;
        for (int i = 2; i < n; i++) {
            fib[i] = fib[i-1].add(fib[i-2]);
        }
        return fib[n-1].toString();
    }
    
    public static void main(String[] args) {
        for (int i = 3; ; i++)
            // Not optimal because it rebuilds the array in Fib() every time...
            // ... but fast enough on my laptop :-)
            if (Fib(i).length() == 1000) {
                System.out.println(i);
                break;
            }
    }
    
}

