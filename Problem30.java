import java.util.ArrayList;

public class Problem30 {

    private int[] nums;

    public Problem30(int exponent) {
        nums = new int[10];
        for (int i = 0; i < 10; i++)
            nums[i] = (int) Math.pow(i, exponent);
    }

    public int solve() {
        ArrayList<Integer> solutions = new ArrayList<>();

        for (int i = 2; i < 1e6; i++) // 1e6 is sufficiently large (estimated; verified experimentally)
            if (test(i)) solutions.add(i);

        int sum = 0;
        for (int i = 0; i < solutions.size(); i++)
            sum += solutions.get(i);
        return sum;
    }

    private boolean test(int n) {
        char[] num = new Integer(n).toString().toCharArray();
        int sum = 0;
        for (int i = 0; i < num.length && sum <= n; i++) {
            sum += nums[num[i]-'0'];
        }
        return sum == n;
    }

    public static void main(String[] args) {
        Problem30 problem = new Problem30(5); // Calculate powers of 5
        int answer = problem.solve();
        System.out.println(answer);
    }
}
