package 프로그래머스.코딩테스트_연습.레벨2.행렬의_곱셈;

public class Matrix {

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int row = arr1.length;
        int column = arr2[0].length;

        int[][] answer = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int sum = 0;
                for (int k = 0; k < arr1[0].length; k++) {
                    sum += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = sum;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
        int[][] arr2 = {{3, 3}, {3, 3}};

        Matrix matrix = new Matrix();
        matrix.solution(arr1, arr2);
    }
}