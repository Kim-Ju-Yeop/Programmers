package 프로그래머스.코딩테스트_연습.레벨2.괄호_변환;

import java.util.Stack;

public class Bracket {

    public String solution(String p) {
        if (isCorrectBracket(p)) return p;
        else return secondStage(p);
    }

    private boolean isCorrectBracket(String bracket) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < bracket.length(); i++) {
            if (bracket.charAt(i) == '(') stack.push(0);
            else stack.push(1);
        }

        for (int i = 0; i < stack.size()-1; i++) {
            int firstElement = stack.get(i);
            int secondElement = stack.get(i+1);

            if (firstElement == 0 && secondElement == 1) {
                stack.remove(i);
                stack.remove(i);
                i = -1;
            }
        }
        return stack.isEmpty();
    }

    private String firstStage(String str) {
        if (str.isEmpty()) return "";
        else return secondStage(str);
    }

    private String secondStage(String w) {
        String u = "";
        String v = "";

        int leftCount = 0;
        int rightCount = 0;

        for (int i = 0; i < w.length(); i++) {
            if (w.charAt(i) == '(') leftCount++;
            else rightCount++;

            if (leftCount == rightCount) {
                u = w.substring(0, i+1);
                v = w.substring(i+1);
                break;
            }
        }

        if (isCorrectBracket(u)) return thirdStage(u, v);
        else return fourthStage(u, v);
    }

    private String thirdStage(String u, String v) {
        return u + firstStage(v);
    }

    private String fourthStage(String u, String v) {
        String temp = "(" + firstStage(v) + ")";

        if (u.length() < 3) return temp;
        else {
            String seperateU = "";
            for (int i = 1; i < u.length()-1; i++) {
                if (u.charAt(i) == '(') seperateU += ")";
                else seperateU += "(";
            }
            return temp + seperateU;
        }
    }

    public static void main(String[] args) {
        Bracket bracket = new Bracket();
        bracket.solution("()))((()");
    }
}