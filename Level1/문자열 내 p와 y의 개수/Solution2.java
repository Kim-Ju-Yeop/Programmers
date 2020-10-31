package example12;

public class Solution2 {

    public boolean solution(String s) {
        s = s.toUpperCase();
        return s.chars().filter(p -> 'P' == p).count() == s.chars().filter(y -> 'Y' == y).count();
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        solution2.solution("pPoooyY");
    }
}
