package 프로그래머스.코딩테스트_연습.레벨2.구명보트;

import java.util.Arrays;

public class LifeBoat3 {

    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length-1;

        for (; i < j; --j) {
            if (people[i] + people[j] <= limit) {
                ++i;
            }
        }
        return people.length - i;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };

        LifeBoat3 lifeBoat3 = new LifeBoat3();
        lifeBoat3.solution(arr, 100);
    }
}