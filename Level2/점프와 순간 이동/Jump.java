package 프로그래머스.코딩테스트_연습.레벨2.점프와_순간_이동;

public class Jump {

    public int solution(int n) {
        int answer = 0;
        while (n != 0) {
            if (n % 2 != 0) answer++;
            n /= 2;
        }
        return answer;
    }

    public static void main(String[] args) {
        Jump jump = new Jump();
        jump.solution(5000);
    }
}