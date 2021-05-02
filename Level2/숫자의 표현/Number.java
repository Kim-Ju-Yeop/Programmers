package 프로그래머스.코딩테스트_연습.레벨2.숫자의_표현;

public class Number {

    public int solution(int n) {
        int count = 0;
        int total = 0;
        int curI = 1;

        for (int i = 1; i <= n; i++) {
            if ((total += i) == n) {
                count++;
                total = 0;
                i = curI++;
            }
            if (total > n) {
                total = 0;
                i = curI++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Number number = new Number();
        number.solution(15);
    }
}