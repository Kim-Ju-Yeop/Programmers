package example7;

public class Solution2 {
    public String solution(String s) {
        return s.substring((s.length()-1) / 2, (s.length() / 2) + 1);
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        solution2.solution("abcde");
    }
}
