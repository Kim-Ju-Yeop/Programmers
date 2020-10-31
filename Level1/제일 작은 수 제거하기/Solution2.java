package example27;

import java.util.Arrays;

public class Solution2 {

    public int[] solution(int[] arr) {
        if (arr.length == 1) return new int[] {-1};

        int min = Arrays.stream(arr).min().getAsInt();
        return Arrays.stream(arr).filter(i -> i != min).toArray();
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1};

        Solution1 solution1 = new Solution1();
        solution1.solution(arr);
    }
}
