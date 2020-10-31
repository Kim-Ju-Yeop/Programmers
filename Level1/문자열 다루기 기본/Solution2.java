package example14;

public class Solution2 {

    public boolean solution(String s) {
        if (s.length() == 4 || s.length() == 6) {
            try {
                int x = Integer.parseInt(s);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        solution2.solution("a234");
    }
}
