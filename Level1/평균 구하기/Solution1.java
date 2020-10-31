package example32;

public class Solution1 {

    public double solution(int[] arr) {
        int sum = 0;

        for (int a : arr) {
            sum += a;
        }
        return (double) sum / arr.length;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };

        Solution1 solution1 = new Solution1();
        solution1.solution(arr);
    }
}
