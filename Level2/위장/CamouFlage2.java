package 프로그래머스.코딩테스트_연습.레벨2.위장;

import java.util.HashMap;
import java.util.Iterator;

public class CamouFlage2 {

    public int solution(String[][] clothes) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            if (hashMap.containsKey(clothes[i][1])) hashMap.put(clothes[i][1], hashMap.get(clothes[i][1])+1);
            else hashMap.put(clothes[i][1], 1);
        }

        int answer = 1;
        Iterator<String> keys = hashMap.keySet().iterator();
        while (keys.hasNext()) {
            int value = hashMap.get(keys.next())+1;
            answer *= value;
        }
        return answer-1;
    }

    public static void main(String[] args) {
        String[][] arr = { { "yellowhat", "headgear" }, { "bluesunglasses", "eyewear" }, { "green_turban", "headgear" } };

        CamouFlage2 camouFlage2 = new CamouFlage2();
        camouFlage2.solution(arr);
    }
}