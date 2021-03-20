package 프로그래머스.코딩테스트_연습.레벨2.구명보트;

import java.util.ArrayList;
import java.util.Arrays;

public class LifeBoat {

    private int solution(int[] people, int limit) {
        Arrays.sort(people);
        ArrayList<Integer> peopleList = new ArrayList<>();
        for (int p : people) peopleList.add(p);

        int answer = 0;
        int endIdx = peopleList.size()-1;
        while (peopleList.size() >= 2) {
            int firstPeople = peopleList.get(0);

            boolean isSuccess = false;
            for (int i = endIdx; i > 0; i--) {
                int secondPeople = peopleList.get(i);

                if (secondPeople <= limit/2) {
                    if ((i+1) % 2 == 0) answer += (i+1) / 2;
                    else answer += ((i+1) / 2) + 1;

                    answer += (peopleList.size() - (i+1));
                    return answer;
                }

                if (firstPeople + secondPeople <= limit) {
                    peopleList.remove(0);
                    peopleList.remove(i);

                    isSuccess = true;
                    answer++;
                    endIdx = i-2;
                    break;
                }
            }
            if (!isSuccess) break;
        }
        answer += peopleList.size();
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = { 70, 50, 80, 50 };

        LifeBoat lifeBoat = new LifeBoat();
        lifeBoat.solution(arr, 100);
    }
}