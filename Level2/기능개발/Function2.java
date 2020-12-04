package programmers.question4;

import java.util.Arrays;

public class Function2 {

    public int[] solution(int[] progresses, int[] speeds) {
        int[] dayOfend = new int[100];
        int day = -1;

        for(int i = 0; i < progresses.length; i++) {
            while(progresses[i] + (day*speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;
        }
        return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
    }

    public static void main(String[] args) {
        int[] progresses = { 93, 30, 55 };
        int[] speeds = { 1, 30, 5 };

        Function2 function2 = new Function2();
        function2.solution(progresses, speeds);
    }
}
