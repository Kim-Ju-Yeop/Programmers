package 프로그래머스.코딩테스트_연습.레벨1.음양_더하기;

public class Sign2 {

    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int i=0; i<signs.length; i++)
            answer += absolutes[i] * (signs[i]? 1: -1);
        return answer;
    }

    public static void main(String[] args) {
        int[] absolutes = {4, 7, 12};
        boolean[] signs = {true, false, true};

        Sign2 sign2 = new Sign2();
        sign2.solution(absolutes, signs);
    }
}
