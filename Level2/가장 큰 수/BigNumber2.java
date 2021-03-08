package 프로그래머스.코딩테스트_연습.레벨2.가장_큰_수;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class BigNumber2 {

    public String solution(int[] numbers) {
        Integer[] integerNumbers = Arrays.stream(numbers).mapToObj(Integer::valueOf).toArray(Integer[]::new);
        Arrays.sort(integerNumbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer num1, Integer num2) {
                String stringNum1 = num1.toString();
                String stringNum2 = num2.toString();

                return ((stringNum1 + stringNum2).compareTo(stringNum2 + stringNum1));
            }
        });

        StringBuffer answer = new StringBuffer();
        for (int number : integerNumbers) {
            answer.insert(0, number);
        }

        int count = 0;
        for (int i = 0; i < answer.toString().length(); i++) {
            if (String.valueOf(answer.toString().charAt(i)).equals("0")) count++;
        }

        if (count == answer.toString().length()) return "0";
        else return answer.toString();
    }

    public static void main(String[] args) {
        int[] arr = { 3, 30, 34, 5, 9 };

        BigNumber2 bigNumber2 = new BigNumber2();
        bigNumber2.solution(arr);
    }
}