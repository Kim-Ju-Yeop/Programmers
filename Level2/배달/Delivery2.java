package 프로그래머스.코딩테스트_연습.레벨2.배달;

public class Delivery2 {

    public int solution(int N, int[][] road, int K) {
        int[] distance = new int[N];
        boolean[] checked = new boolean[N];

        for (int i = 1; i < N; i++) {
            distance[i] = 500001;
        }

        for (int i = 0; i < N; i++) {
            int minTownIdx = -1;
            int minTownDistance = 500001;
            for (int j = 0; j < N; j++) {
                if (!checked[j] && distance[j] < minTownDistance) {
                    minTownIdx = j;
                    minTownDistance = distance[j];
                }
            }

            for (int[] r : road) {
                if (r[0] == minTownIdx+1 || r[1] == minTownIdx+1) {
                    if (distance[r[0]-1] + r[2] < distance[r[1]-1]) {
                        distance[r[1]-1] = distance[r[0]-1] + r[2];
                    }
                    if (distance[r[1]-1] + r[2] < distance[r[0]-1]) {
                        distance[r[0]-1] = distance[r[1]-1] + r[2];
                    }
                }
            }
            checked[i] = true;
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

        Delivery2 delivery2 = new Delivery2();
        delivery2.solution(N, road, K);
    }
}
