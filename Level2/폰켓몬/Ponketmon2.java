package 프로그래머스.코딩테스트_연습.레벨2.폰켓몬;

import java.util.HashSet;

public class Ponketmon2 {

    public int solution(int[] nums) {
        int halfNumsSize = nums.length / 2;

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        return Math.min(halfNumsSize, set.size());
    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 2, 3 };

        Ponketmon2 ponketmon2 = new Ponketmon2();
        ponketmon2.solution(arr);
    }
}