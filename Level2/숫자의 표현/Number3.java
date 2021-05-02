package 프로그래머스.코딩테스트_연습.레벨2.숫자의_표현;

public class Number3 {

    public int solution(int n) {
        int answer = 0;
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum = 0;
            for (int j = i; j <= n; j++) {
                sum += j;
                if (sum > n) break;
                else if (sum == n) {
                    answer++;
                    j = n;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Number3 number3 = new Number3();
        number3.solution(15);
    }
}
