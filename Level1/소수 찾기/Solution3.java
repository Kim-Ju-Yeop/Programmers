package example16;

public class Solution3 {

    public int solution(int n) {
        int answer = 0;

        for (int i = 2; i <= n; i++) {
            boolean check = true;

            for (int j = 2; (j*j) <= i; j++) {
                if (i % j == 0) {
                    check = false;
                    break;
                }
            }

            if (check) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        solution3.solution(1000000);
    }
}
