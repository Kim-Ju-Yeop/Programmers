package example12;

public class Solution1 {

    public boolean solution(String s) {
        int p = 0;
        int y = 0;
        boolean answer = false;

        for (int i = 0; i < s.length(); i++) {
            if (String.valueOf(s.charAt(i)).equalsIgnoreCase("p")) p++;
            else if (String.valueOf(s.charAt(i)).equalsIgnoreCase("y")) y++;
        }

        if (p == y) answer = true;
        return answer;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        solution1.solution("pPoooyY");
    }
}
