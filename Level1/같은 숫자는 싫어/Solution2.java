package example8;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public int[] solution(int[] arr) {
        List<Integer> newArr = new ArrayList<>();

        int pNum = 10;
        for (int i = 0; i < arr.length; i++) {
            if (pNum != arr[i]) newArr.add(arr[i]);
            pNum = arr[i];
        }

        int[] answer = new int[newArr.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = newArr.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 0, 1, 1};

        Solution2 solution2 = new Solution2();
        solution2.solution(arr);
    }
}
