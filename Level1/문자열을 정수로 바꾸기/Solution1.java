package example18;

public class Solution1 {

    public int solution(String s) {
        int answer = 0;

        if (String.valueOf(s.charAt(0)).equals("+")) answer = Integer.parseInt(s.substring(1));
        else answer = Integer.parseInt(s);

        return answer;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        solution1.solution("+1234");
    }
}
