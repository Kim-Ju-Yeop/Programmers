package 프로그래머스.코딩테스트_연습.레벨2.가장_큰_정사각형_찾기;

public class FindSquare {

    int maxSize = 0;
    boolean isContainOne = false;

    public int solution(int[][] board) {
        for (int height = 0; height < board.length; height++) {
            if (board.length-height <= maxSize) break;
            for (int width = 0; width < board[height].length; width++) {
                if (board[height].length-width <= maxSize) break;
                else if (board[height][width] == 1) analyzeBoard(board, height, width);
            }
        }

        if (maxSize == 0 && isContainOne) return 1;
        else return (int)Math.pow(maxSize, 2);
    }

    private void analyzeBoard(int[][] board, int preHeight, int preWidth) {
        isContainOne = true;

        int size = 2;
        int maxHeight = preHeight+size;
        int maxWidth = preWidth+size;
        int curWidth = preWidth;
        boolean isSame = true;

        while (maxHeight <= board.length && maxWidth <= board[preHeight].length) {
            for (int height = preHeight; height < maxHeight; height++) {
                for (int width = (height==maxHeight-1) ? preWidth : curWidth; width < maxWidth; width++) {
                    if (board[height][width] != 1) {
                        isSame = false;
                        break;
                    }
                }
                if (!isSame) break;
            }
            if (!isSame) break;
            else {
                if (size > maxSize) maxSize = size;
                size++;
                maxHeight++;
                maxWidth++;
                curWidth = maxWidth-1;
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = { {0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0} };

        FindSquare findSquare = new FindSquare();
        findSquare.solution(arr);
    }
}