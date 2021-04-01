package 프로그래머스.코딩테스트_연습.레벨2.가장_큰_정사각형_찾기;

public class FindSquare2 {

    public int solution(int[][] board) {
        int maxSize = 0;
        boolean isContainOne = false;

        for (int height = 0; height < board.length; height++) {
            for (int width = 0; width < board[height].length; width++) {
                if (board[height][width] == 1) isContainOne = true;
                if (height == 0 || width == 0 || board[height][width] == 0) continue;

                int firstData = board[height-1][width-1];
                int secondData = board[height-1][width];
                int thirdData = board[height][width-1];
                board[height][width] = Math.min(firstData, Math.min(secondData, thirdData))+1;

                if (board[height][width] > maxSize) maxSize = board[height][width];
            }
        }
        return (maxSize == 0 && isContainOne) ? 1 : maxSize*maxSize;
    }

    public static void main(String[] args) {
        int[][] arr = { {0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0} };

        FindSquare2 findSquare2 = new FindSquare2();
        findSquare2.solution(arr);
    }
}