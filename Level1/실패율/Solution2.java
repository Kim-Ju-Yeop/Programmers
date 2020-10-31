package example40;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution2 {

    public static class Stage implements Comparable<Stage> {
        int id;
        double failure;

        public Stage(int id, double failure) {
            this.id = id;
            this.failure = failure;
        }

        @Override
        public int compareTo(Stage o) {
            return Double.compare(failure, o.failure);
        }
    }

    public int[] solution(int N, int[] lastStages) {
        int nPlayers = lastStages.length;
        int[] nStagePlayers = new int[N+2];

        for (int stage : lastStages) {
            nStagePlayers[stage] += 1;
        }

        int remainingPlayers = nPlayers;
        List<Stage> stages = new ArrayList<>();
        for (int id = 1; id <= N; id++) {
            double failure = (double) nStagePlayers[id] / remainingPlayers;
            remainingPlayers -= nStagePlayers[id];

            Stage s = new Stage(id, failure);
            stages.add(s);
        }
        stages.sort(Collections.reverseOrder());

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = stages.get(i).id;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] stages = { 2, 1, 2, 6, 2, 4, 3, 3 };

        Solution2 solution2 = new Solution2();
        solution2.solution(5, stages);
    }
}
