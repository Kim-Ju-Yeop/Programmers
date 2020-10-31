package example28;

public class Solution2 {
    public String solution(int num) {
        return (num % 2 == 0) ? "Even" : "Odd";
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        solution2.solution(3);
    }
}
