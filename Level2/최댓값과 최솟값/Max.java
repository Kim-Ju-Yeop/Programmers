package 프로그래머스.코딩테스트_연습.레벨2.최댓값과_최솟값;

import java.util.Arrays;

public class Max {

    public String solution(String s) {
        String[] arr = s.split(" ");

        int[] numArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            numArr[i] = Integer.parseInt(arr[i]);
        }

        Arrays.sort(numArr);
        String answer = numArr[0] + " " + numArr[numArr.length-1];
        return answer;
    }

    public static void main(String[] args) {
        Max max = new Max();
        max.solution("1 2 3 4");
    }
}