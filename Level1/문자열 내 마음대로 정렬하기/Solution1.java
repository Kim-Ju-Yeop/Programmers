package example11;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution1 {

    ArrayList<String> result = new ArrayList<>();

    public String[] solution(String[] strings, int n) {

        String[] index = new String[strings.length];
        for (int i = 0; i < strings.length; i++) {
            index[i] = String.valueOf(strings[i].charAt(n));
        }
        Arrays.sort(index);
        Arrays.sort(strings);

        for (String i : index) {
            for (String s : strings) {
                if (i.equals(String.valueOf(s.charAt(n)))) {
                    int check = 0;

                    for (String r : result) {
                        if (r.equals(s)) check = 1;
                    }

                    if (check == 0) result.add(s);
                }
            }
        }

        String[] answer = new String[result.size()];
        int count = 0;
        for (String r : result) {
            answer[count++] = r;
        }
        return answer;
    }


    public static void main(String[] args) {
        String[] strings = {"abce", "abcd", "cdx"};
        int n = 2;

        Solution1 solution1 = new Solution1();
        solution1.solution(strings, n);
    }
}
