package 프로그래머스.코딩테스트_연습.레벨2.쿼드압축_후_개수_세기;

public class Compression2 {

    int zero, one = 0;

    public int[] solution(int[][] arr) {
        press(arr, 0, arr.length, 0, arr.length);
        return new int[]{zero, one};
    }

    private void press(int[][] arr, int xs, int xe, int ys, int ye) {
        int oneCnt = 0, max = (int)Math.pow(xe-xs, 2);
        for (int i = ys; i < ye; i++) {
            for (int j = xs; j < xe; j++) {
                oneCnt += arr[i][j];
            }
        }
        if (oneCnt == 0) zero++;
        else if (oneCnt == max) one++;
        else {
            int xm = (xs+xe)/2;
            int ym = (ys+ye)/2;
            press(arr, xs, xm, ys,ym);
            press(arr, xm, xe, ys, ym);
            press(arr, xs, xm, ym, ye);
            press(arr, xm, xe, ym, ye);
        }
    }

    public static void main(String[] args) {
        int[][] arr = { {1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1} };

        Compression2 compression2 = new Compression2();
        compression2.solution(arr);
    }
}