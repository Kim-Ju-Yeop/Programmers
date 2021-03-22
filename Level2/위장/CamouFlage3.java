package 프로그래머스.코딩테스트_연습.레벨2.위장;

import java.util.Arrays;

import static java.util.stream.Collectors.*;

public class CamouFlage3 {

    public int solution(String[][] clothes) {
        return Arrays.stream(clothes)
                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                .values()
                .stream().reduce(1L, (x, y) -> x * (y + 1)).intValue()-1;
    }

    public static void main(String[] args) {
        String[][] arr = { { "yellowhat", "headgear" }, { "bluesunglasses", "eyewear" }, { "green_turban", "headgear" } };

        CamouFlage3 camouFlage3 = new CamouFlage3();
        camouFlage3.solution(arr);
    }
}