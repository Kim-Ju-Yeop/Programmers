package 프로그래머스.코딩테스트_연습.레벨2.폰켓몬;

import java.util.ArrayList;
import java.util.HashSet;

public class Ponketmon {

    public int solution(int[] nums) {
        String str = "";
        for (int num : nums) {
            str += num;
        }

        HashSet<String> set = new HashSet<>();
        combination("", str, set, nums.length/2);

        int answer = countOfKind(set);
        return answer;
    }

    private void combination(String prefix, String str, HashSet<String> set, int size) {
        if (prefix.length() > size) return;

        int n = str.length();
        if (!prefix.isEmpty() && prefix.length() == size) set.add(prefix);

        for (int i = 0; i < n; i++) {
            combination(prefix + str.charAt(i), (str.substring(0, i) + str.substring(i+1, n)), set, size);
        }
    }

    private int countOfKind(HashSet<String> set) {
        int maxKindCount = 0;

        while (set.iterator().hasNext()) {
            String numberCase = set.iterator().next();
            set.remove(numberCase);

            int count = 0;
            ArrayList<String> kindList = new ArrayList<>();

            for (int i = 0; i < numberCase.length(); i++) {
                if (!kindList.contains(String.valueOf(numberCase.charAt(i)))) {
                    kindList.add(String.valueOf(numberCase.charAt(i)));
                    count++;
                }
            }

            if (count > maxKindCount) maxKindCount = count;
        }
        return maxKindCount;
    }


    public static void main(String[] args) {
        int[] arr = { 3, 1, 2, 3 };

        Ponketmon ponketmon = new Ponketmon();
        ponketmon.solution(arr);
    }
}
