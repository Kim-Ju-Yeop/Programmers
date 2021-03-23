package 프로그래머스.코딩테스트_연습.레벨2.카펫;

public class Carpet3 {

    public int[] solution(int brown, int yellow) {
        int a = (brown+4)/2;
        int b = yellow+2*a-4;
        int[] answer = {(int)(a+Math.sqrt(a*a-4*b))/2,(int)(a-Math.sqrt(a*a-4*b))/2};
        return answer;
    }

    public static void main(String[] args) {
        Carpet3 carpet3 = new Carpet3();
        carpet3.solution(10, 2);
    }
}