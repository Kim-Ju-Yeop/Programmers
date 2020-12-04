package programmers.question4;

import java.util.ArrayList;

public class Function {

    public int[] solution(int[] progresses, int[] speeds) {
        int[] requireDay = new int[progresses.length];
        ArrayList<Integer> distributionCount = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            int day = 0;
            while (progresses[i] < 100) {
                day++;
                progresses[i] += speeds[i];
            }
            requireDay[i] = day;
        }

        for (int i = 0; i < requireDay.length; i++) {
            if (i != requireDay.length-1) {
                if (requireDay[i] < requireDay[i+1]) {
                    distributionCount.add(1);
                } else if (requireDay[i] == requireDay[i+1]) {
                    int count = 1;
                    int j = i+1;

                    for (; j < requireDay.length; j++) {
                        if (requireDay[i] != requireDay[j]) break;
                        else count++;
                    }

                    distributionCount.add(count);
                    i = j-1;
                } else if (requireDay[i] > requireDay[i+1]){
                    int count = 1;
                    int j = i+1;

                    for (; j < requireDay.length; j++) {
                        if (requireDay[i] < requireDay[j]) break;
                        else count++;
                    }

                    distributionCount.add(count);
                    i = j-1;
                }
            } else {
                distributionCount.add(1);
            }
        }

        int[] result = new int[distributionCount.size()];
        for (int i = 0; i < distributionCount.size(); i++) {
            result[i] = distributionCount.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] progresses = { 93, 30, 55 };
        int[] speeds = { 1, 30, 5 };

        Function function = new Function();
        function.solution(progresses, speeds);
    }
}
