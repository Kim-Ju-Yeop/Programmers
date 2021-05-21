package 프로그래머스.코딩테스트_연습.레벨2.예상_대진표;

public class Expectation3 {

    public int solution(int n, int a, int b) {
        int round = 0;
        while(a != b) {
            a = a / 2 + a % 2;
            b = b / 2 + b % 2;
            round++;
        }
        return round;
    }

    public static void main(String[] args) {
        int n = 8;
        int a = 4;
        int b = 7;

        Expectation3 expectation2 = new Expectation3();
        expectation2.solution(n, a, b);
    }
}