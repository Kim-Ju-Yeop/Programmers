package 프로그래머스.코딩테스트_연습.레벨2.H_Index;

import java.util.Arrays;

public class HIndex {

    private int solution(int[] citations) {
        Arrays.sort(citations);

        int startJ = 0;
        int max = citations[citations.length-1];
        int answer = -1;

        for (int i = 0; i <= max; i++) {
            for (int j = startJ; j < citations.length; j++) {
                if (citations[j] >= i) {
                    startJ = j;
                    break;
                }
            }

            int h = i;
            int hMore = citations.length - startJ;
            int hBelow = startJ == 0 ? startJ : startJ+1;

            if (hMore >= h && hBelow <= h && answer < h) {
                answer = h;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 0, 6, 1, 5 };

        HIndex hIndex = new HIndex();
        hIndex.solution(arr);
    }
}