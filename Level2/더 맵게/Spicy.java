package 프로그래머스.코딩테스트_연습.레벨2.더_맵게;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Spicy {

    int count = 0;
    ArrayList<Integer> scovilleList = new ArrayList<>();

    public int solution(int[] scoville, int K) {
        Arrays.sort(scoville);
        for (int s : scoville) scovilleList.add(s);

        mixScoville(K);
        return count;
    }

    private void mixScoville(int K) {
        while (true) {
            if (scovilleList.size() >= 2 && scovilleList.get(0) < K) {
                int firstElement = scovilleList.get(0);
                int secondElement = scovilleList.get(1) * 2;
                int calculateElement = firstElement + secondElement;

                scovilleList.remove(0);
                scovilleList.remove(0);
                scovilleList.add(calculateElement);

                Collections.sort(scovilleList);
                count++;
            } else if (scovilleList.get(0) < K) {
                count = -1;
                break;
            } else break;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 0, 0, 3, 9, 30, 32 };

        Spicy spicy = new Spicy();
        spicy.solution(arr, 26);
    }
}