package example24;

public class Solution2 {

    public int[] solution(int n) {
        String s = "" + n;
        int[] answer = new int[s.length()];
        int cnt = 0;

        while (n > 0) {
            answer[cnt] = n % 10;
            n /= 10;
            cnt++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        solution2.solution(12345);
    }
}
