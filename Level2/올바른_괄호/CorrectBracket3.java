package 프로그래머스.코딩테스트_연습.레벨2.올바른_괄호;

public class CorrectBracket3 {

    public boolean solution(String s) {
        return compare(s);
    }

    private boolean compare(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (count == 0) {
                if (c == '(') count++;
                else return false;
            } else {
                if (c == ')') count--;
                else count++;
            }
            if (count > s.length()-1) return false;
        }
        return count == 0;
    }

    public static void main(String[] args) {
        CorrectBracket3 correctBracket3 = new CorrectBracket3();
        correctBracket3.solution("()()");
    }
}