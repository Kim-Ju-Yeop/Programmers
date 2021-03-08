package 프로그래머스.코딩테스트_연습.레벨2.가장_큰_수;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BigNumber3 {

    public String solution(int[] numbers) {
        String answer = "";

        List<Integer> list = new ArrayList<>();
        for (int number : numbers) list.add(number);

        Collections.sort(list, (a, b) -> {
            String as = String.valueOf(a), bs = String.valueOf(b);
            return -Integer.compare(Integer.parseInt(as + bs), Integer.parseInt(bs + as));
        });

        StringBuilder sb = new StringBuilder();
        for (Integer i : list) sb.append(i);

        answer = sb.toString();
        if (answer.charAt(0) == '0') return "0";
        else return answer;
    }

    public static void main(String[] args) {
        int[] arr = { 1000, 0, 0, 0 };

        BigNumber3 bigNumber3 = new BigNumber3();
        bigNumber3.solution(arr);
    }
}