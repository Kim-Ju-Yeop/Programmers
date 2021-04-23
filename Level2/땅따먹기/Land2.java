package 프로그래머스.코딩테스트_연습.레벨2.땅따먹기;

import java.util.Arrays;

public class Land2 {

    public int solution(int[][] land) {
        for (int row = 1; row < land.length; row++) {
            land[row][0] += Math.max(land[row-1][1], Math.max(land[row-1][2], land[row-1][3]));
            land[row][1] += Math.max(land[row-1][0], Math.max(land[row-1][2], land[row-1][3]));
            land[row][2] += Math.max(land[row-1][0], Math.max(land[row-1][1], land[row-1][3]));
            land[row][3] += Math.max(land[row-1][0], Math.max(land[row-1][1], land[row-1][2]));
        }

        Arrays.sort(land[land.length-1]);
        return land[land.length-1][3];
    }

    public static void main(String[] args) {
        int[][] land = {{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}};

        Land2 land2 = new Land2();
        land2.solution(land);
    }
}
