package 프로그래머스.코딩테스트_연습.레벨2.최솟값_만들기;

import java.util.Arrays;

public class Min {

    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int total = 0;
        int length = A.length;
        for (int i = 0; i < length; i++) {
            total += A[i] * B[(length-1)-i];
        }
        return total;
    }

    public static void main(String[] args) {
        int[] A = {1,4,2};
        int[] B = {5,4,4};

        Min min = new Min();
        min.solution(A, B);
    }
}