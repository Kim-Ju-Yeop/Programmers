package 프로그래머스.코딩테스트_연습.레벨2.피보나치_수;

public class Fibonacci2 {

    public int solution(int n) {
        int fibonacciN = fibonacci(n);
        return fibonacciN;
    }

    private int fibonacci(int n) {
        int a = 0, b = 1, c = 0;

        for (int i = 2; i <= n; i++) {
            c = (a+b) % 1234567;
            a = b % 1234567;
            b = c % 1234567;
        }
        return c;
    }

    public static void main(String[] args) {
        Fibonacci2 fibonacci2 = new Fibonacci2();
        fibonacci2.solution(5);
    }
}