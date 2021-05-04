package 프로그래머스.코딩테스트_연습.레벨2.짝지어_제거하기;

import java.util.Stack;

public class Group4 {

    public int solution(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (stack.size() == 0) stack.push(c);
            else if (stack.peek() == c) stack.pop();
            else stack.push(c);
        }
        return stack.isEmpty() ? 0 : 1;
    }

    public static void main(String[] args) {
        Group4 group4 = new Group4();
        group4.solution("baabaa");
    }
}