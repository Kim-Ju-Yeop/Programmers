package example43;

public class Solution1 {

    public int solution(int[] a, int[] b) {
        int total = 0;

        for (int i = 0; i < a.length; i++) {
            int multiple = a[i] * b[i];
            total += multiple;
        }
        return total;
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4 };
        int[] b = { -3, -1, 0, 2 };

        Solution1 solution1 = new Solution1();
        solution1.solution(a, b);
    }
}
