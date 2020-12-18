package programmers.question6;

import java.util.ArrayList;

public class Book {

    public int[] solution(int m, int n, int[][] picture) {
        int areaCount = 0;
        int maxAreaIdx = -1;
        ArrayList<Integer> maxAreaList = new ArrayList<>();

        for (int height = 0; height < m; height++) {
            for (int width = 0; width < n; width++) {
                if (picture[height][width] != 0) {
                    boolean isFirst = true;

                    if (height != 0 && -picture[height][width] == picture[height - 1][width]) {
                        isFirst = false;
                        picture[height][width] = -picture[height][width];
                    } else if (height != m - 1 && -picture[height][width] == picture[height + 1][width]) {
                        isFirst = false;
                        picture[height][width] = -picture[height][width];
                    } else if (width != 0 && -picture[height][width] == picture[height][width - 1]) {
                        isFirst = false;
                        picture[height][width] = -picture[height][width];
                    } else if (width != n - 1 && -picture[height][width] == picture[height][width + 1]) {
                        isFirst = false;
                        picture[height][width] = -picture[height][width];
                    }

                    if (isFirst) {
                        areaCount++;
                        maxAreaIdx++;
                        maxAreaList.add(1);
                        picture[height][width] = -picture[height][width];
                    } else {
                        int currentArea = maxAreaList.get(maxAreaIdx);
                        maxAreaList.remove(maxAreaIdx);
                        maxAreaList.add(maxAreaIdx, ++currentArea);
                    }
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = areaCount;
        answer[1] = maxAreaList.get(0);

        for (Integer maxArea : maxAreaList) {
            if (answer[1] < maxArea) {
                answer[1] = maxArea;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int m = 13;
        int n = 16;
        int[][] picture = {{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
                {0, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 0}, {0, 1, 1, 1, 2, 1, 2, 1, 1, 2, 1, 2, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0}, {0, 1, 3, 3, 3, 1, 1, 1, 1, 1, 1, 3, 3, 3, 1, 0},
                {0, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 0}, {0, 0, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 0, 0},
                {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0}};

        Book book = new Book();
        book.solution(m, n, picture);
    }
}