package 프로그래머스.코딩테스트_연습.레벨1.소수_만들기;

import java.util.HashSet;

public class Minority {

    int answer = 0;

    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        combination(nums, nums.length, 3, 0, set);

        return answer;
    }

    private void combination(int[] nums, int n, int m, int index, HashSet<Integer> set) {
        if (m == 0) {
            int total = 0;
            for (int s : set) {
                total += s;
            }
            if(checkMinority(total)) answer++;
        }

        for (int i = index; i < n; i++) {
            set.add(nums[i]);
            combination(nums, n, m-1, i+1,set);
            set.remove(nums[i]);
        }
    }

    private boolean checkMinority(int num) {
        if (num == 0 || num == 1) return false;
        else {
            if (num % 2 == 0) return false;
            for (int i = 3; i <= Math.sqrt(num); i+=2) {
                if (num % i == 0) return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };

        Minority minority = new Minority();
        minority.solution(arr);
    }
}