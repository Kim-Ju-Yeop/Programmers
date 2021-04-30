package 프로그래머스.코딩테스트_연습.레벨2.점프와_순간_이동;

public class Jump2 {

    public int solution(int n) {
        int ans = 0;
        String binaryN = Integer.toBinaryString(n);

        for (char bN : binaryN.toCharArray()) if (bN == '1') ans++;
        return ans;
    }

    public static void main(String[] args) {
        Jump2 jump2 = new Jump2();
        jump2.solution(5);
    }
}