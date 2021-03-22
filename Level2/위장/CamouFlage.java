package 프로그래머스.코딩테스트_연습.레벨2.위장;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class CamouFlage {

    int answer = 0;
    HashMap<String, String> hashMap = new HashMap();

    public int solution(String[][] clothes) {
        String[] clothesArr = new String[clothes.length];
        for (int i = 0; i < clothes.length; i++) {
            clothesArr[i] = clothes[i][0];
            hashMap.put(clothes[i][0], clothes[i][1]);
        }

        Stack<String> stack = new Stack<>();
        combination(clothesArr, clothesArr.length, clothesArr.length, 0, stack);
        return answer;
    }

    private void combination(String[] arr, int arrLength, int combMax, int index, Stack<String> stack) {
        if (stack.size() != 0) {
            boolean isSuccess = true;
            ArrayList<String> clothesKindList = new ArrayList<>();

            for (int j = 0; j < stack.size(); j++) {
                String clothesKindValue = hashMap.get(stack.get(j));

                if (clothesKindList.contains(clothesKindValue)) {
                    isSuccess = false;
                    break;
                } else clothesKindList.add(clothesKindValue);
            }
            if (isSuccess) answer++;
            else return;
        }
        if (combMax == 0) return;

        for (int i = index; i < arrLength; i++) {
            stack.add(arr[i]);
            combination(arr, arrLength, combMax-1, i+1, stack);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        String[][] arr = { { "yellowhat", "headgear" }, { "bluesunglasses", "eyewear" }, { "green_turban", "headgear" } };

        CamouFlage camouFlage = new CamouFlage();
        camouFlage.solution(arr);
    }
}