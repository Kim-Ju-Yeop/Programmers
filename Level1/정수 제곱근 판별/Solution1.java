package example26;

public class Solution1 {

    public long solution(long n) {
        for (int i = 1; i <= n; i++) {
            if (n == Math.pow(i, 2)) {
                return (long) Math.pow(i+1, 2);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        solution1.solution(121);
    }
}
