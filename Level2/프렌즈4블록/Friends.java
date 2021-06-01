package 프로그래머스.코딩테스트_연습.레벨2.프렌즈4블록;

public class Friends {

    private String[][] map;
    private int height;
    private int width;
    private int answer;

    public int solution(int m, int n, String[] board) {
        map = new String[m][n];
        height = m;
        width = n;

        setMap(board);
        examineMap();

        return answer;
    }

    private void setMap(String[] board) {
        for (int row = 0; row < height; row++) {
            String curBoard = board[row];
            for (int column = 0; column < width; column++) {
                map[row][column] = String.valueOf(curBoard.charAt(column));
            }
        }
    }

    private void examineMap() {
        boolean isCorrespond = true;
        boolean[][] mapState = new boolean[height][width];

        while (isCorrespond) {
            isCorrespond = false;

            // 1단계 : 일치하는 데이터 확인
            for (int row = 0; row < height - 1; row++) {
                for (int column = 0; column < width - 1; column++) {
                    String curData = map[row][column];
                    String rightData = map[row][column + 1];
                    String belowData = map[row + 1][column];
                    String diagnoalData = map[row + 1][column + 1];

                    if (!curData.isEmpty() && curData.equals(rightData) && curData.equals(belowData) && curData.equals(diagnoalData)) {
                        isCorrespond = true;
                        mapState[row][column] = true;
                        mapState[row][column + 1] = true;
                        mapState[row + 1][column] = true;
                        mapState[row + 1][column + 1] = true;
                    }
                }
            }

            // 2단계 : 일치한 데이터 개수 세기
            for (int row = 0; row < height; row++) {
                for (int column = 0; column < width; column++) {
                    if (mapState[row][column]) answer++;
                }
            }

            // 3단계 : 데이터 자리 이동
            String[][] newMap = new String[height][width];
            for (int column = 0; column < width; column++) {
                int curRow = height-1;

                for (int row = curRow; row >= 0; row--) {
                    if (!mapState[row][column]) newMap[curRow--][column] = map[row][column];
                }
                for (int row = curRow; row >= 0; row--) {
                    newMap[row][column] = "";
                }
            }

            map = newMap;
            mapState = new boolean[height][width];
        }
    }

    public static void main(String[] args) {
        int m = 6;
        int n = 6;
        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};

        Friends friends = new Friends();
        friends.solution(m, n, board);
    }
}