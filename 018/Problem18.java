import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem18 {

    public static int[][] triangleFromFile(String file) throws FileNotFoundException {
        Scanner scn = new Scanner(new File(file));
        
        int lineCounter = 0;
        while(scn.hasNextLine()) {
            scn.nextLine();
            lineCounter++;
        }

        int[][] triangle = new int[lineCounter][lineCounter];

        scn = new Scanner(new File(file));
        int i = 0;
        while(scn.hasNextLine()) {
            String[] line = scn.nextLine().split(" ");
            for (int j = 0; j < line.length; j++)
                triangle[i][j] = Integer.valueOf(line[j]);
            i++;
        }
        return triangle;
    }

    public static void printTriangle(int[][] triangle) {
        for (int i = 0; i < triangle.length; i++) {
            for (int j = 0; j <= i; j++)
                System.out.print((triangle[i][j] < 10 ? "0" : "") + triangle[i][j] +" ");
            System.out.println();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        String triangleFile = args[0];
        
        int[][] triangle = triangleFromFile(triangleFile);
        int n = triangle.length;
        //printTriangle(triangle);
        
        int[][] maxsum = new int[n][n];
        maxsum[0][0] = triangle[0][0];
        for (int i = 1; i < n; i++)
            for (int j = 0; j <= i; j++)
            {
                int valL = (j != 0) ? maxsum[i-1][j-1] : 0;
                int valR = (j != i) ? maxsum[i-1][j] : 0;
                maxsum[i][j] = triangle[i][j] + Math.max(valL, valR);
            }
        //printTriangle(maxsum);
        
        int max = 0;
        for (int i = 0; i < n; i++)
            if (maxsum[n-1][i] > max) max = maxsum[n-1][i];
        
        System.out.println(max);
    }
    
}

