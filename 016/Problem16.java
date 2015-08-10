public class Problem16 {
    
    static String product(String a, int b) {
        String product = "";
        int rest = 0;
        for (int i = a.length(); i > 0; i--) {
            int n = Character.getNumericValue(a.charAt(i-1));
            int d1 = (n*b)%10;
            product = (d1 + rest) + product;
            rest = (n*b-d1)/10;
        }
        return rest == 0 ? product : rest + "" + product;
    }
    
    static int sumOfDigits(String a) {
        int sum = 0;
        for (int i = 0; i < a.length(); i++)
            sum += Character.getNumericValue(a.charAt(i));
        return sum;
    }
    
    static String power(int n, int exponent) {
        String retVal = String.valueOf(n);
        for (int i = 1; i < exponent; i++) 
            retVal = product(retVal, n);
        return retVal;
    }

    public static void main(String[] args) {
        System.out.println(sumOfDigits(power(2, 1000)));
    }
    
}

