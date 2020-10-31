package example22;

public class Solution2 {

    public String solution(String s) {
        String answer = "";
        int cnt = 0;
        String[] array = s.split("");

        for (String ss : array) {
            cnt = ss.contains(" ") ? 0 : cnt + 1;
            answer += cnt % 2 == 0 ? ss.toUpperCase() : ss.toLowerCase();
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        solution2.solution("try hello world");
    }
}
