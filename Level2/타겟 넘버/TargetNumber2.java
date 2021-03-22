package 프로그래머스.코딩테스트_연습.레벨2.타겟넘버;

public class TargetNumber2 {

    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, 0, 0, target);
        return answer;
    }

    private int dfs(int[] numbers, int n, int sum, int target) {
        if (n == numbers.length) {
            if (sum == target) return 1;
            return 0;
        }
        return dfs(numbers, n+1, sum + numbers[n], target) + dfs(numbers, n+1, sum - numbers[n], target);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 1, 1, 1 };

        TargetNumber2 targetNumber2 = new TargetNumber2();
        targetNumber2.solution(arr, 3);
    }
}