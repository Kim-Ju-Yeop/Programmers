package 프로그래머스.코딩테스트_연습.레벨2.예상_대진표;

public class Expectation {

    public int solution(int n, int a, int b) {
        int count = 0;

        while (n != 1) {
            count++;
            n /= 2;

            if (a % 2 == 0 && b == a-1) break;
            else if (b % 2 == 0 && a == b-1) break;

            if (a % 2 != 0) a = a / 2 + 1;
            else a /= 2;

            if (b % 2 != 0) b = b / 2 + 1;
            else b /= 2;
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 8;
        int a = 4;
        int b = 7;

        Expectation expectation = new Expectation();
        expectation.solution(n, a, b);
    }
}