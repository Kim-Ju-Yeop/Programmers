package 프로그래머스.코딩테스트_연습.레벨2.예상_대진표;

public class Expectation2 {

    public int solution(int n, int a, int b) {
        return Integer.toBinaryString((a-1)^(b-1)).length();
    }

    public static void main(String[] args) {
        int n = 8;
        int a = 4;
        int b = 7;

        Expectation2 expectation2 = new Expectation2();
        expectation2.solution(n, a, b);
    }
}