package 프로그래머스.코딩테스트_연습.레벨2.타겟넘버;

import java.util.LinkedList;

public class TargetNumber {

    int answer = 0;

    public int solution(int[] numbers, int target) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        dupplicateRepermutation(1, numbers.length, linkedList, numbers, target);
        return answer;
    }

    private void dupplicateRepermutation(int numCount, int maxLength, LinkedList<Integer> linkedList, int[] numbers, int target) {
        if (linkedList.size() == maxLength) {
            int sum = 0;
            for (int i = 0; i < maxLength; i++) {
                if (linkedList.get(i) == 0) sum += -numbers[i];
                else sum += numbers[i];
            }

            if (sum == target) answer++;
            return;
        }

        for (int i = 0; i <= numCount; i++) {
            linkedList.add(i);
            dupplicateRepermutation(numCount, maxLength, linkedList, numbers, target);
            linkedList.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 1, 1, 1 };

        TargetNumber targetNumber = new TargetNumber();
        targetNumber.solution(arr, 3);
    }
}
