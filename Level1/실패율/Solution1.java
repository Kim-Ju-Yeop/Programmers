package example40;

import java.util.ArrayList;
import java.util.Comparator;

public class Solution1 {

    public int[] solution(int N, int[] stages) {
        ArrayList<Double> failureRateList = checkFailureRate(N, stages);
        int[] resultStages = reverseStages(failureRateList);
        return resultStages;
    }

    // 각 스테이지 별 실패율 조사
    public ArrayList<Double> checkFailureRate(int N, int[] stages) {
        ArrayList<Double> failureRateList = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            int notCompletePlayer = 0;
            int reachPlayer = 0;

            for (int j = 0; j < stages.length; j++) {
                if (stages[j] == i) notCompletePlayer++;
                if (stages[j] >= i) reachPlayer++;
            }
            if (notCompletePlayer == 0) failureRateList.add((double) 0);
            else failureRateList.add(((double) notCompletePlayer / reachPlayer));
        }
        return failureRateList;
    }

    // 실패율이 높은 스테이지 별 내림차순 정렬
    public int[] reverseStages(ArrayList<Double> failureRateList) {
        int[] resultStages = new int[failureRateList.size()];

        ArrayList<Double> descFailureRateList = (ArrayList<Double>) failureRateList.clone();
        descFailureRateList.sort(Comparator.reverseOrder());

        for (int i = 0; i < failureRateList.size(); i++) {
            resultStages[i] = failureRateList.indexOf(descFailureRateList.get(i))+1;
            failureRateList.set(failureRateList.indexOf(descFailureRateList.get(i)), (double) -1);
        }
        return resultStages;
    }

    public static void main(String[] args) {
        int[] stages = { 2, 1, 2, 6, 2, 4, 3, 3 };

        Solution1 solution1 = new Solution1();
        solution1.solution(5, stages);
    }
}
