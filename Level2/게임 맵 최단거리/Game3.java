package 프로그래머스.코딩테스트_연습.레벨2.게임_맵_최단거리;

import java.util.LinkedList;
import java.util.Queue;

public class Game3 {

    class Node {
        int row;
        int column;
        int depth;

        public Node(int row, int column, int depth) {
            this.row = row;
            this.column = column;
            this.depth = depth;
        }
    }

    public int solution(int[][] maps) {
        int row = maps.length;
        int column = maps[0].length;

        boolean[][] visited = new boolean[row][column];
        visited[0][0] = true;

        int answer = bfs(row-1, column-1, maps, visited);
        return answer == 0 ? -1 : answer;
    }

    private int bfs(int endRow, int endColumn, int[][] maps, boolean[][] visited) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 0));

        int answer = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int r = node.row;
            int c = node.column;
            int d = node.depth+1;

            if (r == endRow && c == endColumn) {
                answer = d;
                break;
            }
            if (r != 0 && maps[r-1][c] == 1 && !visited[r-1][c]) {
                visited[r-1][c] = true;
                queue.add(new Node(r-1, c, d));
            }
            if (r != endRow && maps[r+1][c] == 1 && !visited[r+1][c]) {
                visited[r+1][c] = true;
                queue.add(new Node(r+1, c, d));
            }
            if (c != endColumn && maps[r][c+1] == 1 && !visited[r][c+1]) {
                visited[r][c+1] = true;
                queue.add(new Node(r, c+1, d));
            }
            if (c != 0 && maps[r][c-1] == 1 && !visited[r][c-1]) {
                visited[r][c-1] = true;
                queue.add(new Node(r, c-1, d));
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,1}, {0,0,0,0,1}};

        Game3 game3 = new Game3();
        game3.solution(maps);
    }
}