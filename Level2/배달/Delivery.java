package 프로그래머스.코딩테스트_연습.레벨2.배달;

import java.util.Arrays;
import java.util.Comparator;

public class Delivery implements Comparator<int[]> {

    public int solution(int N, int[][] road, int K) {
        sortRoad(road);
        int[] timeRoad = setTimeRoad(N, road);
        return findVillageCount(timeRoad, K);
    }

    private void sortRoad(int[][] road) {
        for (int[] r : road) {
            int a = r[0];
            int b = r[1];

            if (b < a) {
                r[0] = b;
                r[1] = a;
            }
        }
        Arrays.sort(road, this);
    }

    private int[] setTimeRoad(int N, int[][] road) {
        int[] timeRoad = new int[N];
        for (int i = 0; i < road.length; i++) {
            int[] r = road[i];
            int prevData = timeRoad[r[0]-1];
            int curData = timeRoad[r[1]-1];
            timeRoad[r[1]-1] = curData == 0 ? prevData + r[2] : Math.min(curData, prevData + r[2]);
        }
        return timeRoad;
    }

    private int findVillageCount(int[] timeRoad, int K) {
        int village = 0;
        for (int time : timeRoad) {
            if (time <= K) village++;
        }
        return village;
    }

    @Override
    public int compare(int[] a, int[] b) {
        if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
        else return Integer.compare(a[0], b[0]);
    }

    public static void main(String[] args) {
        int N = 6;
        int[][] road = {{1,2,1}, {1,3,2}, {2,3,2}, {3,4,3}, {3,5,2}, {3,5,3}, {5,6,1}};
        int K = 4;

        Delivery delivery = new Delivery();
        delivery.solution(N, road, K);
    }
}