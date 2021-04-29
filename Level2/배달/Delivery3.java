package 프로그래머스.코딩테스트_연습.레벨2.배달;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Delivery3 {

    class Edge {
        int vertext;
        int weight;

        public Edge(int vertext, int weight) {
            this.vertext = vertext;
            this.weight = weight;
        }
    }

    public int solution(int N, int[][] road, int K) {
        int[] distance = new int[N+1];
        Arrays.fill(distance, 99999999);
        ArrayList<Edge>[] graph = new ArrayList[N+1];

        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < road.length; i++) {
            int[] r = road[i];
            graph[r[0]].add(new Edge(r[1], r[2]));
            graph[r[1]].add(new Edge(r[0], r[2]));
        }

        int start = 1;
        distance[start] = 0;
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge edge1, Edge edge2) {
                return Integer.compare(edge1.weight, edge2.weight);
            }
        });

        priorityQueue.offer(new Edge(start, 0));

        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            for (int i = 0; i < graph[edge.vertext].size(); i++) {
                Edge tmp = graph[edge.vertext].get(i);
                if (distance[tmp.vertext] > edge.vertext + tmp.weight) {
                    distance[tmp.vertext] = edge.vertext + tmp.weight;
                    priorityQueue.add(new Edge(tmp.vertext, distance[tmp.vertext]));
                }
            }
        }

        int count = 0;
        for (int d : distance) {
            if (d <= K) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int N = 6;
        int[][] road = {{1,2,1}, {1,3,2}, {2,3,2}, {3,4,3}, {3,5,2}, {3,5,3}, {5,6,1}};
        int K = 4;

        Delivery3 delivery3 = new Delivery3();
        delivery3.solution(N, road, K);
    }
}