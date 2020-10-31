package example16;

import java.util.ArrayList;

public class Solution2 {

    public int solution(int n) {
        ArrayList<Integer> minorityList = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            int check = 0;
            for (Integer minority : minorityList) {
                if (i % minority == 0) {
                    check = 1;
                    break;
                }
            }
            if (check == 0) minorityList.add(i);
        }
        return minorityList.size();
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        solution2.solution(1000000);
    }
}
