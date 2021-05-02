package 프로그래머스.코딩테스트_연습.레벨2.숫자의_표현;

public class Number2 {

    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i += 2) {
            if (n % i == 0) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Number2 number2 = new Number2();
        number2.solution(15);
    }
}