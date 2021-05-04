package 프로그래머스.코딩테스트_연습.레벨2.짝지어_제거하기;

import java.util.Stack;

public class Group2 {

    public int solution(String s) {
        Stack<Integer> stack = new Stack<>();
        if (isFinish(s, stack)) return 0;

        int prev = 0;
        for (int i = 0; i < stack.size(); i++) {
            int cur = stack.get(i);
            if (prev == cur) {
                stack.remove(i-1);
                stack.remove(i-1);
                prev = 0;
                i = -1;
                continue;
            }
            prev = cur;
        }
        return stack.isEmpty() ? 1 : 0;
    }

    private boolean isFinish(String s, Stack<Integer> stack) {
        if (s.length() % 2 != 0) return true;
        else {
            int[] alphabet = new int[36];
            for (char c : s.toCharArray()) {
                alphabet[(int)c - 97] += 1;
                stack.add((int)c);
            }
            for (int i = 0; i < alphabet.length; i++) if (!(alphabet[i] == 0 || alphabet[i] % 2 == 0)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Group2 group2 = new Group2();
        group2.solution("baabaa");
    }
}