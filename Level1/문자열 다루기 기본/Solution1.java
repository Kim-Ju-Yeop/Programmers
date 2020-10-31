package example14;

public class Solution1 {

    public boolean solution(String s) {
        if (s.length() == 4 || s.length() == 6) {
            for (int i = 0; i < s.length(); i++) {
                if (!Character.isDigit(s.charAt(i))) return false;
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        solution1.solution("a234");
    }
}
