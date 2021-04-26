package 프로그래머스.코딩테스트_연습.레벨2.게임_맵_최단거리;

import java.util.Stack;

public class Game2 {

    public int solution(int[][] maps) {
        int currentRow = 0;
        int currentColumn = 0;

        int endRow = maps.length-1;
        int endColumn = maps[0].length-1;

        int moveCount = 1;
        boolean[][] states = new boolean[maps.length][maps[0].length];
        Stack<String> remembers = new Stack<>();

        while (moveCount != 0 && !(currentColumn == endColumn && currentRow == endRow)) {
            boolean isSuccess = true;
            boolean endIsBlock = currentColumn == endColumn || (maps[currentRow][currentColumn + 1] != 1);
            boolean belowIsBloack = currentRow == endRow || (maps[currentRow + 1][currentColumn] != 1);
            boolean startIsBlock = currentColumn == 0 || (maps[currentRow][currentColumn - 1] != 1);
            boolean topIsBlock = currentRow == 0 || (maps[currentRow - 1][currentColumn] != 1);

            if (!endIsBlock && !states[currentRow][currentColumn + 1]) {
                currentColumn++;
                remembers.push("end");
            }
            else if (!belowIsBloack && !states[currentRow + 1][currentColumn]) {
                currentRow++;
                remembers.push("below");
            }
            else if (!startIsBlock && !states[currentRow][currentColumn - 1]) {
                currentColumn--;
                remembers.push("start");
            }
            else if (!topIsBlock && !states[currentRow - 1][currentColumn]) {
                currentRow--;
                remembers.push("top");
            }
            else {
                isSuccess = false;
                if (moveCount != 1) {
                    String remember = remembers.pop();
                    switch (remember) {
                        case "end": currentColumn--; break;
                        case "below": currentRow--; break;
                        case "start": currentColumn++; break;
                        case "top": currentRow++; break;
                    }
                }
            }

            if (isSuccess) {
                moveCount++;
                states[currentRow][currentColumn] = true;
            } else {
                moveCount--;
            }
        }
        return moveCount != 0 ? moveCount : -1;
    }

    public static void main(String[] args) {
        int[][] maps = {{1,1,1,1,0,1}, {1,1,1,1,0,1}, {1,1,0,0,0,1}, {1,1,1,1,1,1}};

        Game2 game2 = new Game2();
        game2.solution(maps);
    }
}