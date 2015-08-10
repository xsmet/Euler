import java.math.BigInteger;

public class Problem15 {
    
    public static BigInteger bigBinomialCoefficient(int n, int m) {
        n = Math.max(n,m);
        m = Math.min(n,m);
        
        BigInteger [][] matrix = new BigInteger[n][m];
        
        for (int i = 0; i < n; i++)
            for (int j = 0; j < Math.min(i+1, m); j++)
                if (j == 0)
                    matrix[i][0] = BigInteger.ONE;
                else if (i == j)
                    matrix[i][j] = matrix[i][j-1].multiply(BigInteger.valueOf(2));
                else
                    matrix[i][j] = matrix[i-1][j].add(matrix[i][j-1]);
        
        return matrix[n-1][m-1];
    }

    public static BigInteger numPaths(int n) {
        return bigBinomialCoefficient(n,n);
    }
    
    public static void main(String[] args) {
        // in a 1x1 grid: 2 paths --> numPaths(2)
        //      2x2 grid: 6 paths --> numPaths(3)
        //      NxN grid:         --> numPaths(N+1)
        //      20x20   : 137846528820 paths --> numPaths(21)
        System.out.println(numPaths(21));
    }
    
}

