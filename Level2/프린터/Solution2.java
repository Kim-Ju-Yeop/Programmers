package example45;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {

    public int solution(int[] priorities, int location) {
        int answer = 0;
        int l = location;

        Queue<Integer> queue = new LinkedList<>();
        for (int p : priorities) {
            queue.add(p);
        }

        Arrays.sort(priorities);
        int size = priorities.length - 1;

        while (!queue.isEmpty()) {
            Integer i = queue.poll();
            if (i == priorities[size - answer]) {
                answer++;
                l--;
                if (l < 0) break;
            } else {
                queue.add(i);
                l--;
                if (l < 0) l = queue.size()-1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] priorities = { 2, 1, 3, 2 };

        Solution2 solution1 = new Solution2();
        solution1.solution(priorities, 2);
    }
}
