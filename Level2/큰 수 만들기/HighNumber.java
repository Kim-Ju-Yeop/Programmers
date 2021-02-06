package 프로그래머스.코딩테스트_연습.레벨2.큰_수_만들기;

import java.util.ArrayList;

public class HighNumber {

    private int arrSize;
    private int pickNumber;
    private int[] pickArr;
    private ArrayList<ArrayList<Integer>> result;

    public String solution(String number, int k) {
        int[] arr = new int[number.length()];
        for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(number.substring(i, i+1));

        arrSize = arr.length;
        pickNumber = arr.length - k;
        pickArr = new int[pickNumber];
        result = new ArrayList<>();
        combination(arr, 0, 0, 0);

        String maxValue = "-1";
        for (int i = 0; i < result.size(); i++) {
            String temp = "";
            for (int j = 0; j < result.get(i).size(); j++) temp += result.get(i).get(j);
            if (Integer.parseInt(temp) > Integer.parseInt(maxValue)) maxValue = temp;
        }
        return maxValue;
    }

    private void combination(int[] arr, int depth, int index, int target) {
        if (depth == pickNumber) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < pickArr.length; i++) {
                temp.add(arr[pickArr[i]]);
            }
            result.add(temp);
            return;
        }
        if (target == arrSize) return;
        pickArr[index] = target;
        combination(arr, depth+1, index+1, target+1);
        combination(arr, depth, index, target+1);
    }

    public static void main(String[] args) {
        HighNumber highNumber = new HighNumber();
        highNumber.solution("1231234", 3);
    }
}