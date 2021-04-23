package 프로그래머스.코딩테스트_연습.레벨1.음양_더하기;

public class Sign {

    public int solution(int[] absolutes, boolean[] signs) {
        int total = 0;
        int length = absolutes.length;

        for (int i = 0; i < length; i++) {
            if (!signs[i]) total += -absolutes[i];
            else total += absolutes[i];
        }
        return total;
    }

    public static void main(String[] args) {
        int[] absolutes = {4, 7, 12};
        boolean[] signs = {true, false, true};

        Sign sign = new Sign();
        sign.solution(absolutes, signs);
    }
}
