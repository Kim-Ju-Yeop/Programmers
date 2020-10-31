package example5;

import java.util.Arrays;

public class Solution2 {

    public int[] solution(int[] array, int[][] commands) {
        int[] answers = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] temp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(temp);
            answers[i] = temp[commands[i][2] - 1];
        }
        return answers;
    }

    public static void main(String[] args) {
        int[] array = { 1, 5, 2, 6, 3, 7, 4 };
        int[][] commands = { {2, 5, 3}, {4, 4, 1}, {1, 7, 3} };

        Solution2 solution2 = new Solution2();
        solution2.solution(array, commands);
    }
}
