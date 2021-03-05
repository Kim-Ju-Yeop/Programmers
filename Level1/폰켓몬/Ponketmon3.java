package 프로그래머스.코딩테스트_연습.레벨2.폰켓몬;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class Ponketmon3 {

    public int solution(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        HashSet<String> answerSet = new HashSet<>();

        combination(nums, nums.length, nums.length/2, 0, stack, answerSet);

        int answer = countOfKind(answerSet);
        return answer;
    }

    public void combination(int[] arr, int n, int m, int index, Stack<Integer> stack, HashSet<String> answerSet) {
        if (m == 0) {
            String data = "";
            for (int s : stack) data += s;
            answerSet.add(data);
            return;
        }

        for (int i = index; i < n; i++) {
            stack.add(arr[i]);
            combination(arr, n, m-1, i+1, stack, answerSet);
            stack.pop();
        }
    }

    private int countOfKind(HashSet<String> set) {
        int maxKindCount = 0;

        while (set.iterator().hasNext()) {
            String numberCase = set.iterator().next();
            set.remove(numberCase);

            int count = 0;
            ArrayList<String> kindList = new ArrayList<>();

            for (int i = 0; i < numberCase.length(); i++) {
                if (!kindList.contains(String.valueOf(numberCase.charAt(i)))) {
                    kindList.add(String.valueOf(numberCase.charAt(i)));
                    count++;
                }
            }

            if (count > maxKindCount) maxKindCount = count;
        }
        return maxKindCount;
    }


    public static void main(String[] args) {
        int[] arr = { 3, 1, 2, 3 };

        Ponketmon3 ponketmon = new Ponketmon3();
        ponketmon.solution(arr);
    }
}