package 프로그래머스.코딩테스트_연습.레벨2.카펫;

public class Carpet2 {

    public int[] solution(int brown, int yellow) {
        int width = 0;
        int height = 0;

        for (int i = 1; i <= Math.sqrt(yellow); i++) {
            if (yellow % i != 0) continue;

            int yWidth = yellow / i;
            int yHeight = i;

            if (isBrown(yWidth, yHeight, brown)) {
                width = yWidth+2;
                height = yHeight+2;
            }
        }
        return new int[] { width, height };
    }

    private boolean isBrown(int yWidth, int yHeight, int brown) {
        int width = yWidth+2;
        int height = yHeight+2;
        return (2 * (width+height)-4) == brown;
    }

    public static void main(String[] args) {
        Carpet2 carpet2 = new Carpet2();
        carpet2.solution(10, 2);
    }
}