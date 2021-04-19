package 프로그래머스.코딩테스트_연습.레벨2.올바른_괄호;

public class CorrectBracket2 {

    public boolean solution(String s) {
        return compare(s);
    }

    private boolean compare(String str) {
        for (int i = 0; i < str.length()-1; i++) {
            char firstData = str.charAt(i);
            char secondData = str.charAt(i+1);

            if (firstData == '(' && secondData == ')') {
                str = str.replaceFirst("[(]", "");
                str = str.replaceFirst("[)]", "");

                if (i != 0) i -= 2;
                else i -= 1;
            } else if (firstData == ')') return false;
        }
        return str.isEmpty();
    }

    public static void main(String[] args) {
        CorrectBracket2 correctBracket2 = new CorrectBracket2();
        correctBracket2.solution("()()");
    }
}