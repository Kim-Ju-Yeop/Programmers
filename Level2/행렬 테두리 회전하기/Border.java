package 프로그래머스.코딩테스트_연습.레벨2.행렬_테두리_회전하기;

import java.util.Arrays;

public class Border {

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] maps = new int[rows][columns];

        addMapData(rows, columns, maps);

        for (int i = 0; i < queries.length; i++) {
            int[] curQuery = queries[i];
            rotateMapData(curQuery, maps, answer, i);
        }
        return answer;
    }

    private void addMapData(int rows, int columns, int[][] maps) {
        int value = 1;
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                maps[row][column] = value++;
            }
        }
    }

    private void rotateMapData(int[] query, int[][] maps, int[] answer, int idx) {
        int startRow = query[0]-1;
        int startColumn = query[1]-1;
        int endRow = query[2]-1;
        int endColumn = query[3]-1;

        int size = (((endColumn-startColumn)+1) * 2) + (((endRow - startRow)-1) * 2);
        int prevIdx = 0;
        int[] prevData = new int[size];

        for (int column = startColumn; column <= endColumn; column++) prevData[prevIdx++] = maps[startRow][column];
        for (int row = startRow+1; row <= endRow; row++) prevData[prevIdx++] = maps[row][endColumn];
        for (int column = endColumn-1; column >= startColumn; column--) prevData[prevIdx++] = maps[endRow][column];
        for (int row = endRow-1; row > startRow; row--) prevData[prevIdx++] = maps[row][startColumn];

        prevIdx = 0;

        for (int column = startColumn+1; column <= endColumn; column++) maps[startRow][column] = prevData[prevIdx++];
        for (int row = startRow+1; row <= endRow; row++) maps[row][endColumn] = prevData[prevIdx++];
        for (int column = endColumn-1; column >= startColumn; column--) maps[endRow][column] = prevData[prevIdx++];
        for (int row = endRow-1; row >= startRow; row--) maps[row][startColumn] = prevData[prevIdx++];

        Arrays.sort(prevData);
        answer[idx] = prevData[0];
    }

    public static void main(String[] args) {
        int rows = 6;
        int columns = 6;
        int[][] queries = {{2,2,5,4}, {3,3,6,6}, {5,1,6,3}};

        Border border = new Border();
        border.solution(rows, columns, queries);
    }
}