package example38;

import java.util.Arrays;

public class Solution1 {

    public int solution(int[] d, int budget) {
        Arrays.sort(d);

        int sum = 0;
        int departmentCount = 0;

        for (int i = 0; i < d.length; i++) {
            if (sum == budget) return departmentCount;
            else if (sum > budget) return departmentCount-1;

            sum += d[i];
            departmentCount++;
        }

        if (sum == budget) return departmentCount;
        else if (sum > budget) return departmentCount-1;
        else return departmentCount;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 2, 5, 4 };

        Solution1 solution1 = new Solution1();
        solution1.solution(arr, 9);
    }
}
