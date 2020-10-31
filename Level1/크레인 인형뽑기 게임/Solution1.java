package example1;

import java.util.ArrayList;

class Solution1 {

    int count = 0;
    ArrayList<Integer> stack = new ArrayList<>();

    public int solution(int[][] board, int[] moves) {
        setStackData(board, moves);
        isOverlapping();

        return count;
    }

    public void setStackData(int[][] board, int[] moves) {
        int movesCount = 0;

        while(movesCount < moves.length){
            for(int column = 0; column < board.length; column++){
                for(int row = 0; row < board.length; row++){
                    if (moves[movesCount] == row + 1) {
                        if (board[column][row] != 0){
                            stack.add(board[column][row]);

                            board[column][row] = 0;
                            column = board.length;
                            row = board.length;
                        }
                    }
                }
            }
            movesCount++;
        }
    }

    public void isOverlapping() {
        for (int i = 0; i < stack.size() - 1; i++) {
            if (stack.get(i) == stack.get(i + 1)) {
                count += 2;

                stack.remove(i);
                stack.remove(i);

                i = -1;
            }
        }
    }

    public static void main(String[] args) {
        int[][] board = { {0,0,0,0,0}, {0,0,1,0,3}, {0,2,5,0,1}, {4,2,4,4,2}, {3,5,1,3,1} };
        int[] moves = { 1,5,3,5,1,2,1,4 };

        Solution1 solution1 = new Solution1();
        int answer = solution1.solution(board, moves);

        System.out.println(answer);
    }
}