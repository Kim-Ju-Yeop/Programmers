package example10;

public class Solution2 {
    public long solution(int a, int b) {
        return sumAtoB(Math.min(a, b), Math.max(a, b));
    }

    public long sumAtoB(long a, long b) {
        return (b - a + 1) * (a + b) / 2;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.solution(5, 3));
    }
}
