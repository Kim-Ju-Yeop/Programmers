package 프로그래머스.코딩테스트_연습.레벨2.땅따먹기;

public class Land3 {

    public int solution(int[][] land) {
        return hopscotch(land, land.length, 0, -1);
    }

    private int hopscotch(int[][] land, int size, int y, int idx) {
        if (y >= size) return 0;

        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < 4; i++) {
            if (i != idx) answer = Math.max(hopscotch(land, size, y+1, i) + land[y][i], answer);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] land = {{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}};

        Land3 land3 = new Land3();
        land3.solution(land);
    }
}