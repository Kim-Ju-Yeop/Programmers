package example13;

import java.util.ArrayList;
import java.util.Collections;

public class Solution1 {

    public String solution(String s) {
        ArrayList<String> lowerList = new ArrayList<>();
        ArrayList<String> upperList = new ArrayList<>();

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (String.valueOf(s.charAt(i)).equals(String.valueOf(s.charAt(i)).toLowerCase())) {
                lowerList.add(String.valueOf(s.charAt(i)));
            } else if (String.valueOf(s.charAt(i)).equals(String.valueOf(s.charAt(i)).toUpperCase())) {
                upperList.add(String.valueOf(s.charAt(i)));
            }
        }

        Collections.sort(lowerList);
        Collections.sort(upperList);

        Collections.reverse(lowerList);
        Collections.reverse(upperList);

        for (String lower : lowerList) {
            answer.append(lower);
        }
        for (String upper : upperList) {
            answer.append(upper);
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        solution1.solution("ZbcdWRWWefag");
    }
}
