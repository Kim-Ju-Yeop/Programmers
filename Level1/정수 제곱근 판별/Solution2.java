package example26;

public class Solution2 {

    public long solution(long n) {
        if (Math.pow((int) Math.sqrt(n), 2) == n) {
            return (long) Math.pow((Math.sqrt(n) + 1), 2);
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        solution2.solution(121);
    }
}
