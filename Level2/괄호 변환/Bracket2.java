package 프로그래머스.코딩테스트_연습.레벨2.괄호_변환;

public class Bracket2 {

    public String solution(String balancedParenthesis) {
        return getCorrectParenthesis(balancedParenthesis);
    }

    private String getCorrectParenthesis(String balancedParenthesis) {
        if (balancedParenthesis.length() == 0) return balancedParenthesis;

        int open = 0;
        int close = 0;
        for (char c : balancedParenthesis.toCharArray()) {
            if (c == '(') open++;
            else close++;
            if (open == close) break;
        }

        int uLen = open + close;
        String u = balancedParenthesis.substring(0, uLen);
        String v = balancedParenthesis.substring(uLen);

        if (isCorrectParenthesis(u)) {
            return u + getCorrectParenthesis(v);
        } else {
            String uDash = "(" + getCorrectParenthesis(v) + ")";

            for (int i = 1; i < uLen-1; i++) {
                if (u.charAt(i) == '(') uDash += ")";
                else uDash += "(";
            }
            return uDash;
        }
    }

    private boolean isCorrectParenthesis(String balancedParenthesis) {
        int strLen = balancedParenthesis.length();
        int open = 0;

        for (int i = 0; i < strLen; i++) {
            if (balancedParenthesis.charAt(i) == '(') open++;
            else {
                if (open == 0) return false;
                open--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Bracket2 bracket2 = new Bracket2();
        bracket2.solution("()))((()");
    }
}