package example22;

public class Solution1 {

    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int index = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                index = 0;
                answer.append(" ");
                continue;
            }

            if (index % 2 == 0) answer.append(String.valueOf(s.charAt(i)).toUpperCase());
            else answer.append(String.valueOf(s.charAt(i)).toLowerCase());

            index++;
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        solution1.solution("try hello world");
    }
}
