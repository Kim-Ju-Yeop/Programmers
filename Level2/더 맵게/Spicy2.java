package 프로그래머스.코딩테스트_연습.레벨2.더_맵게;

import java.util.Arrays;
import java.util.Stack;

public class Spicy2 {

    public int solution(int[] scoville, int K) {
        Arrays.sort(scoville);
        Stack<Integer> stack = new Stack<>();
        for (int a : scoville) stack.add(a);

        int count = 0;
        while (true) {
            if (stack.size() >= 2 && stack.get(0) < K) {
                int firstElement = stack.get(0);
                int secondElement = stack.get(1) * 2;
                int calculateElement = firstElement + secondElement;

                stack.remove(0);
                stack.remove(0);

                int j = 0;
                for (; j < stack.size(); j++) if (stack.get(j) >= calculateElement) break;

                stack.add(j, calculateElement);
                count++;
            }
            else if (stack.get(0) < K) {
                count = -1;
                break;
            } else break;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 0, 0, 3, 9, 10, 12 };

        Spicy2 spicy2 = new Spicy2();
        spicy2.solution(arr, 14);
    }
}