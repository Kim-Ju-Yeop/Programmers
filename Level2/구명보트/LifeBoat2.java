package 프로그래머스.코딩테스트_연습.레벨2.구명보트;

import java.util.Arrays;

public class LifeBoat2 {

    public int solution(int[] people, int limit) {
        Arrays.sort(people);

        int answer = 0;
        int remainPeople = people.length;
        int startIdx = 0;
        int endIdx = people.length-1;

        while (remainPeople >= 2) {
            int firstPeople = people[startIdx];

            boolean isSuccess = false;
            for (int i = endIdx; i > startIdx; i--) {
                int secondPeople = people[i];

                if (firstPeople + secondPeople <= limit) {
                    people[startIdx] = -1;
                    people[i] = -1;

                    answer++;
                    startIdx += 1;
                    endIdx = i-1;
                    remainPeople -= 2;
                    isSuccess = true;
                    break;
                }
            }

            if (!isSuccess) break;
        }

        for (int p : people) if (p != -1) answer++;
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };

        LifeBoat2 lifeBoat2 = new LifeBoat2();
        lifeBoat2.solution(arr, 100);
    }
}
