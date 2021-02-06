package 프로그래머스.코딩테스트_연습.레벨2.큰_수_만들기;

import java.util.Stack;

public class HighNumber3 {

    public String solution(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        for (int i=0; i<result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }

    public static void main(String[] args) {
        HighNumber3 highNumber3 = new HighNumber3();
        highNumber3.solution("1231234", 3);
    }
}