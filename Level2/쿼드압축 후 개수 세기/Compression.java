package 프로그래머스.코딩테스트_연습.레벨2.쿼드압축_후_개수_세기;

import java.util.ArrayList;

public class Compression {

    boolean[][] stateArr;
    ArrayList<Integer> sameList = new ArrayList<>();

    public int[] solution(int[][] arr) {
        int length = arr.length;
        int halfLength = length/2;
        stateArr = new boolean[length][length];

        if (isAllSame(arr)) {
            if (arr[0][0] == 0) return new int[]{1, 0};
            else return new int[]{0,1};
        }

        compression(arr, 0, halfLength, 0, halfLength);
        compression(arr, halfLength, length, 0, halfLength);
        compression(arr, 0, halfLength, halfLength, length);
        compression(arr, halfLength, length, halfLength, length);

        return countData(arr);
    }

    private boolean isAllSame(int[][] arr) {
        int value = arr[0][0];

        for (int height = 0; height < arr.length; height++) {
            for (int width = 0; width < arr[height].length; width++) {
                if (arr[height][width] != value) return false;
            }
        }
        return true;
    }

    private void compression(int[][] arr, int startWidthIdx, int endWidthIdx, int startHeightIdx, int endHeightIdx) {
        boolean isSame = true;
        int value = arr[startHeightIdx][startWidthIdx];

        for (int height = startHeightIdx; height < endHeightIdx; height++) {
            for (int width = startWidthIdx; width < endWidthIdx; width++) {
                if (arr[height][width] != value) {
                    isSame = false;
                    break;
                }
            }
            if (!isSame) break;
        }

        if (isSame) {
            sameList.add(value);
            for (int height = startHeightIdx; height < endHeightIdx; height++) {
                for (int width = startWidthIdx; width < endWidthIdx; width++) stateArr[height][width] = true;
            }
        }
        else if (!isSame && endWidthIdx-startWidthIdx != 2) {
            int halfWidthIdx = (startWidthIdx+endWidthIdx)/2;
            int halfHeightIdx = (startHeightIdx+endHeightIdx)/2;

            compression(arr, startWidthIdx, halfWidthIdx, startHeightIdx, halfHeightIdx);
            compression(arr, halfWidthIdx, endWidthIdx, startHeightIdx, halfHeightIdx);
            compression(arr, startWidthIdx, halfWidthIdx, halfHeightIdx, endHeightIdx);
            compression(arr, halfWidthIdx, endWidthIdx, halfHeightIdx, endHeightIdx);
        }
    }

    private int[] countData(int[][] arr) {
        int zeroCount = 0;
        int oneCount = 0;

        for (int s : sameList) {
            if (s == 0) zeroCount++;
            else oneCount++;
        }

        for (int height = 0; height < stateArr.length; height++) {
            for (int width = 0; width < stateArr[height].length; width++) {
                if (!stateArr[height][width]) {
                    if (arr[height][width] == 0) zeroCount++;
                    else oneCount++;
                }
            }
        }
        return new int[]{zeroCount, oneCount};
    }

    public static void main(String[] args) {
        int[][] arr = { {1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1} };

        Compression compression = new Compression();
        compression.solution(arr);
    }
}