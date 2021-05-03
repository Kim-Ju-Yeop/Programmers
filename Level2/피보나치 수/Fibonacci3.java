package 프로그래머스.코딩테스트_연습.레벨2.피보나치_수;

public class Fibonacci3 {

    public long solution(int n) {
        long[] dp = new long[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            dp[i] = ((dp[i-1] % 1234567) + (dp[i-2] % 1234567)) % 1234567;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Fibonacci3 fibonacci3 = new Fibonacci3();
        fibonacci3.solution(5);
    }
}