package AbundantNumbers;

public class AbundantNumbers {
    
    public static final int MAXNUM = 28123;
    
    private  static int sumOfDivisors(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++)
            if (n % i == 0) sum += i;
        return sum;
    }
    
    private final int[] abundantNumbersIfNotZero;   // A sparse array where every element !=0 will be an abundant number
    private final int[] abundantNumbers;            // A dense array with only the abundant numbers
    private final int   maxSumOfDivisors;

    public AbundantNumbers() {
        abundantNumbersIfNotZero = new int[MAXNUM+1];
        int abundantNumbersCounter = 0;
        int max = 0;
        for (int i = 1; i < abundantNumbersIfNotZero.length; i++) {
            int sod = sumOfDivisors(i);
            if (sod > 2*i) {
                abundantNumbersIfNotZero[i] = sod;
                abundantNumbersCounter++;
                if (sod > max) max = sod;
            }
        }
        maxSumOfDivisors = max;
        
        abundantNumbers = new int[abundantNumbersCounter];
        int idx = 0;
        for (int i = 0; i < abundantNumbersIfNotZero.length; i++)
            if (abundantNumbersIfNotZero[i] != 0)
                abundantNumbers[idx++] = i;
    }
    
    private boolean IsAbundantNumber(int n) {
        return abundantNumbersIfNotZero[n] != 0;
    }
    
    public boolean IsSumOfTwoAbundantNumbers(int n) {
        if (n > MAXNUM) return true;
        
        for (int i = 0; i < abundantNumbers.length && abundantNumbers[i] < n; i++)
            if (IsAbundantNumber(n - abundantNumbers[i])) return true;
            
        return false;
    }
    
}
