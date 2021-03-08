package 프로그래머스.코딩테스트_연습.레벨2.가장_큰_수;

import java.util.Arrays;

public class BigNumber {

    public String solution(int[] numbers) {
        String[] stringNumbers = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
        String[] sortNumbers = bubbleSort(stringNumbers);

        StringBuffer answer = new StringBuffer();
        for (String number : sortNumbers) {
            answer.insert(0, number);
        }

        int count = 0;
        for (int i = 0; i < answer.toString().length(); i++) {
            if (String.valueOf(answer.toString().charAt(i)).equals("0")) count++;
        }

        if (count == answer.toString().length()) return "0";
        else return answer.toString();
    }

    public String[] bubbleSort(String[] stringNumbers) {
        for (int i = 0; i < stringNumbers.length-1; i++) {
            for (int j = stringNumbers.length-1; j > i; j--) {
                int firstCase = Integer.parseInt(stringNumbers[j] + stringNumbers[j-1]);
                int secondCase = Integer.parseInt(stringNumbers[j-1] + stringNumbers[j]);

                if (firstCase < secondCase) swap(stringNumbers, j, j-1);
            }
        }
        return stringNumbers;
    }

    public void swap(String[] stringNumbers, int firstIdx, int secondIdx) {
        String temp = stringNumbers[firstIdx];
        stringNumbers[firstIdx] = stringNumbers[secondIdx];
        stringNumbers[secondIdx] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 1000, 0, 0, 0 };

        BigNumber bigNumber = new BigNumber();
        bigNumber.solution(arr);
    }
}