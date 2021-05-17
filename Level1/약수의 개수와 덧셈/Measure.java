package 프로그래머스.코딩테스트_연습.레벨1.약수의_개수와_덧셈;

public class Measure {

    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            if (measureIsEven(i)) answer += i;
            else answer -= i;
        }
        return answer;
    }

    private boolean measureIsEven(int num) {
        int measureCount = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) measureCount++;
        }
        return measureCount % 2 == 0;
    }

    public static void main(String[] args) {
        Measure measure = new Measure();
        measure.solution(13, 17);
    }
}