package 프로그래머스.코딩테스트_연습.레벨2.최댓값과_최솟값;

public class Max2 {

    public String solution(String s) {
        String[] tmp = s.split(" ");

        int min, max, n;
        min = max = Integer.parseInt(tmp[0]);

        for (int i = 1; i < tmp.length; i++) {
            n = Integer.parseInt(tmp[i]);
            if(min > n) min = n;
            if(max < n) max = n;
        }
        return min + " " + max;
    }

    public static void main(String[] args) {
        Max2 max2 = new Max2();
        max2.solution("1 2 3 4");
    }
}