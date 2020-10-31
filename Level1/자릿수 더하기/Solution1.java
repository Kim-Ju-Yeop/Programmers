package example23;

public class Solution1 {

    public int solution(int n) {
        String stringN = String.valueOf(n);
        int sum = 0;

        for (int i = 0; i < stringN.length(); i++) {
            sum += Integer.parseInt(String.valueOf(stringN.charAt(i)));
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        solution1.solution(987);
    }
}
