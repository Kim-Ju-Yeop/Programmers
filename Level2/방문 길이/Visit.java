package 프로그래머스.코딩테스트_연습.레벨2.방문_길이;

import java.util.HashMap;

public class Visit {

    int row = 5;
    int column = 5;
    int answer = 0;

    public int solution(String dirs) {
        boolean[][] maps = new boolean[11][11];
        HashMap<String, Boolean> mapsState = new HashMap<>();

        for (char d : dirs.toCharArray()) {
            int startRow = row;
            int startColumn = column;
            int endRow;
            int endColumn;

            switch(d) {
                case 'U': {
                    if (startRow != 0) {
                        endRow = row -= 1;
                        endColumn = startColumn;
                        controlMapsState(startRow, startColumn, endRow, endColumn, mapsState);
                    } break;
                }
                case 'D': {
                    if (startRow != 10) {
                        endRow = row += 1;
                        endColumn = startColumn;
                        controlMapsState(startRow, startColumn, endRow, endColumn, mapsState);
                    } break;
                }
                case 'R': {
                    if (startColumn != 10) {
                        endColumn = column += 1;
                        endRow = startRow;
                        controlMapsState(startRow, startColumn, endRow, endColumn, mapsState);
                    } break;
                }
                case 'L': {
                    if (startColumn != 0) {
                        endColumn = column -= 1;
                        endRow = startRow;
                        controlMapsState(startRow, startColumn, endRow, endColumn, mapsState);
                    } break;
                }
            }
        }
        return answer;
    }

    private void controlMapsState(int startRow, int startColumn, int endRow, int endColumn, HashMap<String, Boolean> mapsState) {
        String firstKey = startRow + "" + startColumn + "" + endRow + "" + endColumn;
        String secondKey = endRow + "" + endColumn + "" + startRow + "" + startColumn;

        if (mapsState.get(firstKey) == null && mapsState.get(secondKey) == null) answer++;
        mapsState.put(firstKey, true);
        mapsState.put(secondKey, true);
    }

    public static void main(String[] args) {
        Visit visit = new Visit();
        visit.solution("ULURRDLLU");
    }
}