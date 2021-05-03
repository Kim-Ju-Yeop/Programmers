package 프로그래머스.코딩테스트_연습.레벨2.JadenCase_문자열_만들기;

public class JadenCase2 {

    public String solution(String s) {
        String answer = "";
        String[] sp = s.toLowerCase().split("");
        boolean flag = true;

        for(String ss : sp) {
            answer += flag ? ss.toUpperCase() : ss;
            flag = ss.equals(" ");
        }
        return answer;
    }

    public static void main(String[] args) {
        JadenCase2 jadenCase2 = new JadenCase2();
        jadenCase2.solution("3people unFollowed me");
    }
}