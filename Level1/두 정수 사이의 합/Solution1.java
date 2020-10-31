package example10;

public class Solution1 {
    public long solution(int a, int b) {
        long answer = 0;

        if (a < b)
            for (long i = a; i <= b; i++) answer += i;
        else
            for (long i = b; i <= a; i++) answer += i;

        return answer;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.solution(5, 3));
    }
}
