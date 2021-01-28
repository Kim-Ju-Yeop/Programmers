package 프로그래머스.코딩테스트_연습.레벨1.신규_아이디_추천;

public class Solution2 {

    public String solution(String new_id) {
        String answer = "";

        // 1단계
        String temp = new_id.toLowerCase();

        // 2단계
        temp = temp.replaceAll("[^-_.a-z0-9]","");

        // 3단계
        temp = temp.replaceAll("[.]{2,}",".");

        // 4단계
        temp = temp.replaceAll("^[.]|[.]$","");

        // 5단계
        if(temp.equals(""))
            temp += "a";

        // 6단계
        if(temp.length() >= 16){
            temp = temp.substring(0,15);
            temp = temp.replaceAll("^[.]|[.]$","");
        }

        // 7단계
        if(temp.length() <= 2)
            while(temp.length() < 3)
                temp += temp.charAt(temp.length()-1);

        answer = temp;
        return answer;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        solution2.solution("...!@BaT#*..y.abcdefghijklm");
    }
}