package 프로그래머스.코딩테스트_연습.레벨2.더_맵게;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Spicy3 {

    public int solution(int[] scoville, int K) {
        Arrays.sort(scoville);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int s : scoville) queue.add(s);

        int count = 0;
        while (true) {
            if (queue.size() >= 2 && queue.peek() < K) {
                int firstElement = queue.peek(); queue.remove();
                int secondElement = queue.peek() * 2; queue.remove();
                int calculateElement = firstElement + secondElement;

                queue.add(calculateElement);
                count++;
            } else if (queue.peek() < K) {
                count = -1;
                break;
            }
            else break;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 0, 0, 3, 9, 10, 12 };

        Spicy3 spicy3 = new Spicy3();
        spicy3.solution(arr, 7);
    }
}