package example28;

public class Solution1 {
    public String solution(int num) {
        if (num % 2 == 0) return "Even";
        else return "Odd";
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        solution1.solution(3);
    }
}
