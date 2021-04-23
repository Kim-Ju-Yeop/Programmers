package 프로그래머스.코딩테스트_연습.레벨2.땅따먹기;

import java.util.ArrayList;
import java.util.Arrays;

public class Land {

    int prevMaxLandIdx = -1;
    int totalLand = 0;

    public int solution(int[][] land) {
        for (int row = 0; row < land.length-1; row++) findMaxLand(land[row].clone(), land[row + 1].clone());
        findLastMaxLand(land[land.length-1].clone());
        return totalLand;
    }

    private void findMaxLand(int[] currentLand, int[] nextLand) {
        ArrayList<Integer> currentLandList = new ArrayList<>();
        ArrayList<Integer> nextLandList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            currentLandList.add(currentLand[i]);
            nextLandList.add(nextLand[i]);
        }

        Arrays.sort(currentLand);
        Arrays.sort(nextLand);

        int currentMaxLandIdx = currentLandList.indexOf(currentLand[3]);
        int nextMaxLandIdx = nextLandList.indexOf(nextLand[3]);

        // 1) prevMaxLandIdx와 값이 같을 경우
        boolean isSame = false;
        boolean isDupplicate = false;
        if (currentMaxLandIdx == prevMaxLandIdx) {
            if (currentMaxLandIdx != currentLandList.lastIndexOf(currentLand[3])) {
                currentMaxLandIdx = currentLandList.lastIndexOf(currentLand[3]);
                isDupplicate = true;
            }
            else {
                currentMaxLandIdx = currentLandList.indexOf(currentLand[2]);
                isSame = true;
            }
        }

        // 2) currentMaxLandIdx와 nextMaxLandIdx가 다를 경우
        if (currentMaxLandIdx != nextMaxLandIdx) {
            prevMaxLandIdx = currentMaxLandIdx;
            totalLand += currentLandList.get(currentMaxLandIdx);
            return;
        }

        int currentLandIdx = currentLandList.indexOf(currentLand[2]);
        int nextLandIdx = nextLandList.indexOf(nextLand[2]);
        if (isSame) {
            currentLandIdx = currentLandList.indexOf(currentLand[1]);
            nextLandIdx = nextLandList.indexOf(nextLand[1]);
        }

        // 3) A행의 최댓값 < B행의 최댓값
        if ((currentLandList.get(currentMaxLandIdx) - currentLandList.get(currentLandIdx)) < (nextLandList.get(nextMaxLandIdx) - nextLandList.get(nextLandIdx))) {
            if (isSame) {
                if (currentMaxLandIdx != currentLandList.lastIndexOf(currentLand[2])) currentMaxLandIdx = currentLandList.lastIndexOf(currentLand[2]);
                else currentMaxLandIdx = currentLandList.indexOf(currentLand[1]);
            } else {
                if (currentMaxLandIdx != currentLandList.lastIndexOf(currentLand[3])) currentMaxLandIdx = currentLandList.lastIndexOf(currentLand[3]);
                else currentMaxLandIdx = currentLandList.indexOf(currentLand[2]);
            }

            prevMaxLandIdx = currentMaxLandIdx;
            totalLand += currentLandList.get(currentMaxLandIdx);
            return;
        }

        // 4) A행의 최댓값 > B행의 최댓값
        if (isSame) {
            if (currentMaxLandIdx != currentLandList.lastIndexOf(currentLand[2])) currentMaxLandIdx = currentLandList.lastIndexOf(currentLand[2]);
        } else {
            if (currentMaxLandIdx != currentLandList.lastIndexOf(currentLand[3])) currentMaxLandIdx = currentLandList.lastIndexOf(currentLand[3]);
        }

        prevMaxLandIdx = currentMaxLandIdx;
        totalLand += currentLandList.get(currentMaxLandIdx);
    }

    private void findLastMaxLand(int[] land) {
        ArrayList<Integer> landList = new ArrayList<>();
        for (int i = 0; i < 4; i++) landList.add(land[i]);

        Arrays.sort(land);

        int maxLandIdx = landList.indexOf(land[3]);
        if (maxLandIdx == prevMaxLandIdx) maxLandIdx = landList.indexOf(land[2]);

        prevMaxLandIdx = maxLandIdx;
        totalLand += landList.get(maxLandIdx);
    }

    public static void main(String[] args) {
        int[][] landArr = {{50, 2, 1, 17}, {150, 3, 1, 5}};

        Land land = new Land();
        land.solution(landArr);
    }
}