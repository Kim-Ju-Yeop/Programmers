package 프로그래머스.코딩테스트_연습.레벨2.H_Index;

import java.util.Arrays;

public class HIndex2 {

    private int solution(int[] citations) {
        Arrays.sort(citations);

        int max = 0;
        for (int i = citations.length-1; i > -1; i--) {
            int min = Math.min(citations[i], citations.length-i);
            if (max < min) max = min;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 0, 6, 1, 5 };

        HIndex2 hIndex2 = new HIndex2();
        hIndex2.solution(arr);
    }
}