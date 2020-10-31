package example8;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {

    public int[] solution(int[] arr) {
        List<Integer> newArr = new ArrayList<>();

        for (int value : arr) {
            if (!(newArr.size() != 0 && newArr.get(newArr.size() - 1) == value)) newArr.add(value);
        }

        int[] answer = new int[newArr.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = newArr.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 0, 2};

        Solution1 solution1 = new Solution1();
        solution1.solution(arr);
    }
}
