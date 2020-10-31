package example16;

public class Solution4 {

    public int solution(int n) {
        int answer = 0;
        int root = (int) Math.sqrt(n);

        boolean[] sosu = new boolean[n+1];

        for (int i = 2; i <= n; i++) {
            sosu[i] = true;
        }

        for (int i = 2; i <= root; i++) {
            if (sosu[i]) {
                for (int j = i; (i*j) <= n; j++) {
                    sosu[i*j] = false;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (sosu[i]) answer++;
        }

        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        solution4.solution(10);
    }
}