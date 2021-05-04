package 프로그래머스.코딩테스트_연습.레벨2.짝지어_제거하기;

import java.util.Stack;

public class Group3 {

    public int solution(String s) {
        if (s.length() % 2 != 0) return 0;

        int sIdx = -1;
        int stackIdx = -1;
        Stack<Integer> stack = new Stack<>();

        while (sIdx != s.length()-1) {
            if (stackIdx == -1) {
                stack.add((int)s.charAt(++sIdx));
                stackIdx++;
            }
            else {
                if (stack.get(stackIdx) == (int)s.charAt(sIdx+1)) {
                    stack.remove(stackIdx--);
                    sIdx++;
                } else {
                    stack.add((int)s.charAt(++sIdx));
                    stackIdx++;
                }
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        Group3 group3 = new Group3();
        group3.solution("baabaa");
    }
}