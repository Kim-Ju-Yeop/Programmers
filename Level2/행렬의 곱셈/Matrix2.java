package 프로그래머스.코딩테스트_연습.레벨2.행렬의_곱셈;

public class Matrix2 {

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        if (arr1[0].length == arr2.length) {
            for (int i = 0; i < arr1.length; i++) {
                for (int j = 0; j < arr2[0].length; j++) {
                    for (int k = 0; k < arr1[0].length; k++) {
                        answer[i][j] += arr1[i][k] * arr2[k][j];
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
        int[][] arr2 = {{3, 3}, {3, 3}};

        Matrix2 matrix = new Matrix2();
        matrix.solution(arr1, arr2);
    }
}