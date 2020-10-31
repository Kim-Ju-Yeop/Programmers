package example7;

public class Solution1 {
    public String solution(String s) {
        String answer = "";

        if (s.length() % 2 != 0) {
            int middleIndex = (s.length() / 2);
            answer = String.valueOf(s.charAt(middleIndex));
        } else {
            int firstIndex = (s.length() / 2) -1;
            int secondIndex = (s.length() / 2);

            answer = String.valueOf(s.charAt(firstIndex)) + String.valueOf(s.charAt(secondIndex));
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        solution1.solution("abcde");
    }
}
