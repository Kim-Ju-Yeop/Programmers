package example42;

public class Solution2 {

    public int solution(int n) {
        int answer = 0;

        String third = Integer.toString(n, 3);
        StringBuffer sb = new StringBuffer(third);

        String reversed = sb.reverse().toString();

        int exp = 0;
        for (int i = reversed.length() - 1; i >= 0; i--) {
            answer += Integer.parseInt(String.valueOf(reversed.charAt(i))) * Math.pow(3, exp);
            exp++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        solution2.solution(45);
    }
}
