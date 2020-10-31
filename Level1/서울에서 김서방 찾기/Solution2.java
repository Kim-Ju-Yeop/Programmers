package example15;

import java.util.Arrays;

public class Solution2 {

    public String solution(String[] seoul) {
        int x = Arrays.asList(seoul).indexOf("Kim");
        return "김서방은 " + x +"에 있다";
    }

    public static void main(String[] args) {
        String[] seoul = {"Jane", "Kim"};

        Solution2 solution2 = new Solution2();
        solution2.solution(seoul);
    }
}
