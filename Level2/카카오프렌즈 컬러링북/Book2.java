package programmers.question6;

import java.util.LinkedList;
import java.util.Queue;

public class Book2 {

    private final int[] dx = {1, -1, 0, 0};
    private final int[] dy = {0, 0, 1, -1};

    private int size = 0;
    private boolean[][] visited;
    private Queue<Node> queue = new LinkedList<>();

    private class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        visited = new boolean[m][n];

        for (int height = 0; height < m; height++) {
            for (int width = 0; width < n; width++) {
                if (picture[height][width] > 0 && !visited[height][width]) {
                    size = 1;
                    bfs(picture, height, width, m, n);
                    numberOfArea++;

                    if (maxSizeOfOneArea < size) {
                        maxSizeOfOneArea = size;
                    }
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    private void bfs(int[][] picture, int height, int width, int m, int n) {
        queue.add(new Node(height, width));
        visited[height][width] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nh = now.x + dx[i];
                int nw = now.y + dy[i];

                if (0 <= nh && nh < m && 0 <= nw && nw < n) {
                    if (picture[nh][nw] == picture[height][width] && !visited[nh][nw]) {
                        queue.add(new Node(nh, nw));
                        visited[nh][nw] = true;
                        size++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int m = 13;
        int n = 16;
        int[][] picture = {{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
                {0, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 0}, {0, 1, 1, 1, 2, 1, 2, 1, 1, 2, 1, 2, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0}, {0, 1, 3, 3, 3, 1, 1, 1, 1, 1, 1, 3, 3, 3, 1, 0},
                {0, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 0}, {0, 0, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 0, 0},
                {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0}};

        Book2 book2 = new Book2();
        book2.solution(m, n, picture);
    }
}