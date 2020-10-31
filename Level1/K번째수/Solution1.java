package example5;

import java.util.Arrays;

public class Solution1 {

    public int[] solution(int[] array, int[][] commands) {
        int[] answers = new int[commands.length];
        int count = 0;

        for (int[] command : commands) {
            answers[count++] = findData(array, command[0], command[1], command[2]);
        }
        return answers;
    }

    public int findData(int[] array, int start, int end, int k) {
        int[] newArray = new int[(end - start) + 1];
        int count = 0;

        for (int i = start - 1; i < end; i++) {
            newArray[count++] = array[i];
        }
        Arrays.sort(newArray);
        return newArray[k - 1];
    }

    public static void main(String[] args) {
        int[] array = { 1, 5, 2, 6, 3, 7, 4 };
        int[][] commands = { {2, 5, 3}, {4, 4, 1}, {1, 7, 3} };

        Solution1 solution1 = new Solution1();
        solution1.solution(array, commands);
    }
}
