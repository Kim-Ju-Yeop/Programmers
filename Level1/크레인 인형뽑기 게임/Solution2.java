package example1;

import java.util.Stack;

public class Solution2 {

    Stack<Integer> stack = new Stack<>();

    public int solution(int[][] board, int[] moves){
        int answer = 0;

        for (int move : moves) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][move-1] != 0) {
                    if (stack.isEmpty()) {
                        stack.push(board[i][move-1]);
                        board[i][move-1] = 0;
                        break;
                    }

                    if (board[i][move-1] == stack.peek()) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(board[i][move-1]);
                    }

                    board[i][move-1] = 0;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] board = { {0,0,0,0,0}, {0,0,1,0,3}, {0,2,5,0,1}, {4,2,4,4,2}, {3,5,1,3,1} };
        int[] moves = { 1,5,3,5,1,2,1,4 };

        Solution2 solution2 = new Solution2();
        int answer = solution2.solution(board, moves);

        System.out.println(answer);
    }
}
