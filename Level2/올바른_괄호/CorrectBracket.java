package 프로그래머스.코딩테스트_연습.레벨2.올바른_괄호;

import java.util.Stack;

public class CorrectBracket {

    int firstCount = 0;
    int secondCount = 0;
    Stack<Integer> stack = new Stack();

    public boolean solution(String s) {
        addData(s);
        compareData();
        return stack.isEmpty();
    }

    private void addData(String str) {
        for (char s : str.toCharArray()) {
            if (s == '(') {
                firstCount++;
                stack.add(0);
            } else {
                secondCount++;
                stack.add(1);
            }
        }
    }

    private void compareData() {
        if (firstCount != secondCount) return;
        for (int i = 0; i < stack.size()-1; i++) {
            int firstData = stack.get(i);
            int secondData = stack.get(i+1);

            if (firstData == 0 && secondData == 1) {
                stack.remove(i);
                stack.remove(i);

                if (i != 0) i -= 2;
                else i -= 1;
            } else if (firstData == 1) return;
        }
    }

    public static void main(String[] args) {
        CorrectBracket correctBracket = new CorrectBracket();
        correctBracket.solution("()()");
    }
}