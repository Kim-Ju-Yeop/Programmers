package 프로그래머스.코딩테스트_연습.레벨2.게임_맵_최단거리;

public class Game {

    public int solution(int[][] maps) {
        int currentRow = 0;
        int currentColumn = 0;

        int endRow = maps.length-1;
        int endColumn = maps[0].length-1;

        int moveCount = 1;
        boolean isSuccess = true;

        while (moveCount < (endColumn+1) * (endRow+1)) {
            int endIsBlock = (currentColumn != endColumn) ? (maps[currentRow][currentColumn + 1] == 1) ? 0 : 1 : -1;
            int belowIsBlock = (currentRow != endRow) ? (maps[currentRow+1][currentColumn] == 1) ? 0 : 1 : -1;
            int topIsBlock = (currentRow != 0) ? (maps[currentRow-1][currentColumn] == 1) ? 0 : 1 : -1;

            if (endIsBlock == 0) currentColumn++;
            else if (belowIsBlock == 0) currentRow++;
            else if (topIsBlock == 0) currentRow--;
            else {
                isSuccess = false;
                break;
            }

            moveCount++;
            if (currentColumn == endColumn && currentRow == endRow) break;
            if (moveCount >= (endColumn+1) * (endRow+1)) isSuccess = false;
        }

        return isSuccess ? moveCount : -1;
    }

    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,1}, {0,0,0,0,1}};

        Game game = new Game();
        game.solution(maps);
    }
}