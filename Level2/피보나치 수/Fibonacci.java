package 프로그래머스.코딩테스트_연습.레벨2.피보나치_수;

import java.util.HashMap;

public class Fibonacci {

    HashMap<Integer, Integer> map = new HashMap<>();

    public int solution(int n) {
        map.put(0, 0);
        map.put(1, 1);

        int fibonacciN = fibonacci(n);
        return fibonacciN;
    }

    private int fibonacci(int n) {
        if (map.get(n) != null) return map.get(n);
        else {
            int firstValue = fibonacci(n-1) % 1234567;
            int secondValue = fibonacci(n-2) % 1234567;
            int totalValue = (firstValue + secondValue) % 1234567;

            map.put(n, totalValue);
            return totalValue;
        }
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        fibonacci.solution(100000);
    }
}
