package AbundantNumbers;

public class Problem23 {

    public static void main(String[] args) {
        AbundantNumbers an = new AbundantNumbers();
        
        int sum = 0;
        for (int i = 1; i < AbundantNumbers.MAXNUM; i++)
            if ( ! an.IsSumOfTwoAbundantNumbers(i) )
                sum += i;
        
        System.out.println(sum);
    }

    
}
