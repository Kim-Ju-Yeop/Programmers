package example33;

public class Solution2 {

    public boolean solution(int x) {
        String[] temp = String.valueOf(x).split("");

        int sum = 0;
        for (String t : temp) {
            sum += Integer.parseInt(t);
        }
        return x % sum == 0;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        solution2.solution(10);
    }
}
