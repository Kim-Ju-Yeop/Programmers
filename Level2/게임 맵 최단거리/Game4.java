package 프로그래머스.코딩테스트_연습.레벨2.게임_맵_최단거리;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;

public class Game4 {

    public int solution(int[][] maps) {
        int row = maps.length;
        int column = maps[0].length;

        boolean[][] visited = new boolean[row][column];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(row-1, column-1));

        int r, c, size, cnt = 0;
        Point p = new Point();

        while (!queue.isEmpty()) {
            size = queue.size();
            cnt++;

            for (int i = 0; i < size; i++) {
                p = queue.poll();
                r = p.x;
                c = p.y;

                if (visited[r][c]) continue;

                maps[r][c] = 0;
                visited[r][c] = true;

                if (r == 0 && c == 0) return cnt;
                if (r-1 > -1 && maps[r-1][c] == 1) queue.add(new Point(r-1, c));
                if (r+1 < row && maps[r+1][c] == 1) queue.add(new Point(r+1, c));
                if (c-1 > -1 && maps[r][c-1] == 1) queue.add(new Point(r, c-1));
                if (c+1 < column && maps[r][c+1] == 1) queue.add(new Point(r, c+1));
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,1}, {0,0,0,0,1}};

        Game4 game4 = new Game4();
        game4.solution(maps);
    }
}