package 프로그래머스.코딩테스트_연습.레벨2.삼각_달팽이;

public class Snail2 {

    public int[] solution(int n) {
        int[][] arr = new int[n][n];

        int lastWidth = 0;
        int lastHeight = -1;

        int num = 1;
        int count = 0;

        while (true){
            if (count < n) {
                lastHeight++;
                for (int i = 0; i < n-count; i++) {
                    arr[lastHeight][lastWidth] = num++;
                    if (i != n-count-1) lastHeight++;
                }
                count++;
            } else break;

            if (count < n) {
                lastWidth++;
                for (int i = 0; i < n-count; i++) {
                    arr[lastHeight][lastWidth] = num++;
                    if (i != n-count-1) lastWidth++;
                }
                count++;
            } else break;

            if (count < n) {
                lastHeight--;
                lastWidth--;
                for (int i = 0; i < n-count; i++) {
                    arr[lastHeight][lastWidth] = num++;
                    if (i != n-count-1) {
                        lastHeight--;
                        lastWidth--;
                    }
                }
                count++;
            } else break;
        }

        int i = 0;
        int[] answer = new int[num-1];
        for (int height = 0; height < n; height++) {
            for (int width = 0; width < height+1; width++) {
                answer[i++] = arr[height][width];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Snail2 snail2 = new Snail2();
        snail2.solution(5);
    }
}
