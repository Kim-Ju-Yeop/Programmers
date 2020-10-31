package example23;

public class Solution2 {

    public int solution(int n) {
        int answer = 0;

        while(true) {
            answer += n % 10;

            if (n < 10) break;

            n /= 10;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        solution2.solution(987);
    }
}
