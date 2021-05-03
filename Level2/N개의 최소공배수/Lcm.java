package 프로그래머스.코딩테스트_연습.레벨2.N개의_최소공배수;

import java.util.Stack;

public class Lcm {

    public int solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int a : arr) stack.add(a);

        while(stack.size() != 1) {
            int a = stack.pop();
            int b = stack.pop();
            int l = lcm(a, b);
            stack.push(l);
        }
        return stack.pop();
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }

    private int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public static void main(String[] args) {
        int[] arr = {2, 6, 8, 14};

        Lcm lcm = new Lcm();
        lcm.solution(arr);
    }
}