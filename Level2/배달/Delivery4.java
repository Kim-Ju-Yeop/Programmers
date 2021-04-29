package 프로그래머스.코딩테스트_연습.레벨2.배달;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Delivery4 {

    private final int MAX = 5000001;

    public int solution(int N, int[][] road, int K) {
        int[][] maps = new int[N][N];
        for (int[] a : maps) Arrays.fill(a, MAX);

        for (int[] r : road) {
            int x = r[0]-1;
            int y = r[1]-1;
            int w = r[2];
            if (w < maps[x][y]) maps[x][y] = maps[y][x] = w;
        }

        int[] distance = new int[N];
        boolean[] visited = new boolean[N];

        Arrays.fill(distance, MAX);
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(distance[o1], distance[o2]);
            }
        });

        distance[0] = 0;
        pq.add(0);

        while (!pq.isEmpty()) {
            int curr = pq.poll();
            if (visited[curr]) continue;

            visited[curr] = true;
            for (int i = 0; i < N; i++) {
                if (maps[curr][i] == MAX) continue;
                if (distance[i] > distance[curr] + maps[curr][i]) {
                    distance[i] = distance[curr] + maps[curr][i];
                    pq.offer(i);
                }
            }
        }

        int answer = 0;
        for (int d : distance) if (d <= K) answer++;
        return answer;
    }

    public static void main(String[] args) {
        int N = 6;
        int[][] road = {{1,2,1}, {1,3,2}, {2,3,2}, {3,4,3}, {3,5,2}, {3,5,3}, {5,6,1}};
        int K = 4;

        Delivery4 delivery4 = new Delivery4();
        delivery4.solution(N, road, K);
    }
}