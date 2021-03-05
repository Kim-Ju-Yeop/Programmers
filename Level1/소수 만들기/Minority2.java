package 프로그래머스.코딩테스트_연습.레벨1.소수_만들기;

public class Minority2 {

    public int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i+1; j < nums.length - 1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    int total = nums[i] + nums[j] + nums[k];
                    if(checkMinority(total)) answer++;
                }
            }
        }
        return answer;
    }

    private boolean checkMinority(int num) {
        if (num == 0 || num == 1) return false;
        if (num % 2 == 0) return false;

        for (int i = 3; i <= Math.sqrt(num); i+=2) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 7, 6, 4 };

        Minority2 minority2 = new Minority2();
        minority2.solution(arr);
    }
}