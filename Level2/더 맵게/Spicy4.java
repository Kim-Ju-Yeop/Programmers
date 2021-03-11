package 프로그래머스.코딩테스트_연습.레벨2.더_맵게;

import java.util.PriorityQueue;

public class Spicy4 {

    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue();
        for (int s : scoville) priorityQueue.add(s);

        int count = 0;
        while (priorityQueue.size() > 1 && priorityQueue.peek() < K) {
            int weakHot = priorityQueue.poll();
            int secondWeakHot = priorityQueue.poll();

            priorityQueue.add(weakHot + (secondWeakHot * 2));
            count++;
        }

        if (priorityQueue.size() <= 1 && priorityQueue.peek() < K) count = -1;
        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 0, 0, 3, 9, 10, 12 };

        Spicy4 spicy4 = new Spicy4();
        spicy4.solution(arr, 7);
    }
}