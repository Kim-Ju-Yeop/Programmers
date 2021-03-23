package 프로그래머스.코딩테스트_연습.레벨2.카펫;

public class Carpet {

    int yWidth = 0;
    int yHeight = 0;

    public int[] solution(int brown, int yellow) {
        analyzeYellow(brown, yellow);

        int width = yWidth+2;
        int height = yHeight+2;

        return new int[] { width, height };
    }

    private void analyzeYellow(int brown, int yellow) {
        if ((yellow * 2) + 6 == brown) {
            yWidth = yellow;
            yHeight = 1;
            return;
        }

        for (int i = 1; i <= yellow; i++) {
            if (yellow % i != 0) continue;
            else {
                int divideValue = yellow / i;
                if (i <= divideValue) {
                    yWidth = divideValue;
                    yHeight = i;
                } else break;
            }
        }
    }

    public static void main(String[] args) {
        Carpet carpet = new Carpet();
        carpet.solution(10, 2);
    }
}