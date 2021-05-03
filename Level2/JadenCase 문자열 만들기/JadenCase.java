package 프로그래머스.코딩테스트_연습.레벨2.JadenCase_문자열_만들기;

public class JadenCase {

    public String solution(String s) {
        String answer = "";
        boolean prevIsBlank = true;

        for (char charS : s.toCharArray()) {
            String temp = String.valueOf(charS);

            if (temp.equals(" ")) {
                answer += temp;
                prevIsBlank = true;
            }
            else if (prevIsBlank) {
                answer += temp.toUpperCase();
                prevIsBlank = false;
            }
            else if (!prevIsBlank) {
                answer += temp.toLowerCase();
                prevIsBlank = false;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        JadenCase jadenCase = new JadenCase();
        jadenCase.solution("3people unFollowed me");
    }
}