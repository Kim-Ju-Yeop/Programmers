package example11;

import java.util.ArrayList;
import java.util.Collections;

public class Solution2 {

    public String[] solution(String[] strings, int n) {
        String[] answer;
        ArrayList<String> arr = new ArrayList<>();

        for (String string : strings) {
            arr.add(string.charAt(n) + string);
        }

        Collections.sort(arr);
        answer = new String[arr.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = arr.get(i).substring(1);
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] strings = {"abce", "abcd", "cdx"};
        int n = 2;

        Solution2 solution2 = new Solution2();
        solution2.solution(strings, n);
    }
}
