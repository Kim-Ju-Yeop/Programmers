package 프로그래머스.코딩테스트_연습.레벨2.올바른_괄호;

public class CorrectBracket4 {

    public boolean solution(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') count++;
            else if (s.charAt(i) == ')') count--;
            if (count < 0) return false;
        }
        return count == 0;
    }

    public static void main(String[] args) {
        CorrectBracket4 correctBracket4 = new CorrectBracket4();
        correctBracket4.solution("()()");
    }
}
