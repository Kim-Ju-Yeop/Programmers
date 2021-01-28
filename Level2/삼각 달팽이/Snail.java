package 프로그래머스.코딩테스트_연습.레벨2.삼각_달팽이;

public class Snail {

    private void toClockWise(int[][] arr) {
        int maxWidth = arr[0].length;
        int maxHeight = arr.length;

        int lastWidth = -1;
        int lastHeight = 0;

        int num = 1;

        for (int count = 0; count < maxWidth; count++) {
            if (count % 2 == 0) {
                lastWidth++;
                for (int i = 0; i < maxWidth-count; i++) {
                    arr[lastHeight][lastWidth] = num++;
                    if (i != maxWidth-count-1) lastWidth++;
                }

                lastHeight++;
                for (int i = 0; i < maxHeight-count-1; i++) {
                    arr[lastHeight][lastWidth] = num++;
                    if (i != maxHeight-count-2) lastHeight++;
                }
            } else {
                lastWidth--;
                for (int i = 0; i < maxWidth-count; i++) {
                    arr[lastHeight][lastWidth] = num++;
                    if (i != maxWidth-count-1) lastWidth--;
                }

                lastHeight--;
                for (int i = 0; i < maxHeight-count-1; i++) {
                    arr[lastHeight][lastWidth] = num++;
                    if (i != maxHeight-count-2) lastHeight--;
                }
            }
        }
        showArr(arr);
    }

    private void toCounterClockWise(int[][] arr) {
        int maxWidth = arr[0].length;
        int maxHeight = arr.length;

        int lastWidth = 0;
        int lastHeight = -1;

        int num = 1;

        for (int count = 0; count < maxWidth; count++) {
            if (count % 2 == 0) {
                lastHeight++;
                for (int i = 0; i < maxHeight-count; i++) {
                    arr[lastHeight][lastWidth] = num++;
                    if (i != maxHeight-count-1) lastHeight++;
                }

                lastWidth++;
                for (int i = 0; i < maxWidth-count-1; i++) {
                    arr[lastHeight][lastWidth] = num++;
                    if (i != maxWidth-count-2) lastWidth++;
                }
            } else {
                lastHeight--;
                for (int i = 0; i < maxHeight-count; i++) {
                    arr[lastHeight][lastWidth] = num++;
                    if (i != maxHeight-count-1) lastHeight--;
                }

                lastWidth--;
                for (int i = 0; i < maxWidth-count-1; i++) {
                    arr[lastHeight][lastWidth] = num++;
                    if (i != maxWidth-count-2) lastWidth--;
                }
            }
        }
        showArr(arr);
    }

    private void showArr(int[][] arr) {
        for (int height = 0; height < arr.length; height++) {
            for (int width = 0; width < arr[height].length; width++) {
                System.out.printf("%3d", arr[height][width]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] arr1 = new int[5][5];
        int[][] arr2 = new int[6][2];

        Snail snail = new Snail();
        snail.toClockWise(arr1);
        snail.toCounterClockWise(arr1);

        snail.toClockWise(arr2);
        snail.toCounterClockWise(arr2);
    }
}