import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Problem22 {

    public static int score(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++)
            sum += s.charAt(i) - 'A' + 1;
        return sum;
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scn = new Scanner(new File(args[0]));
        String input = scn.nextLine();
        input = input.substring(1, input.length() - 1);
        
        String[] names = input.split("\",\"");
        Arrays.sort(names);

        int total = 0;
        for (int i = 0; i < names.length; i++)
            total += (i+1) * score(names[i]);

        System.out.println(total);

    }
    
}

