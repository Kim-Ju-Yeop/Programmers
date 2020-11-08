package example45;

import java.util.ArrayList;

public class Solution1 {

    public int solution(int[] priorities, int location) {
        ArrayList<Integer> prioritiesList = new ArrayList<>();
        ArrayList<String> prioritiesNameList = new ArrayList<>();

        for (int i = 0; i < priorities.length; i++) {
            prioritiesList.add(priorities[i]);
            prioritiesNameList.add(String.valueOf(i));
        }

        String findPrioritiesName = prioritiesNameList.get(location);

        for (int i = 0; i < prioritiesList.size(); i++) {
            int element = prioritiesList.get(i);
            String elementName = prioritiesNameList.get(i);

            for (int j = i + 1; j < prioritiesList.size(); j++) {
                if (prioritiesList.get(j) > element) {
                    prioritiesList.remove(i);
                    prioritiesList.add(element);

                    prioritiesNameList.remove(i);
                    prioritiesNameList.add(elementName);

                    i = -1;
                    break;
                }
            }
        }
        return prioritiesNameList.indexOf(findPrioritiesName)+1;
    }

    public static void main(String[] args) {
        int[] priorities = { 1, 1, 9, 1, 1, 1 };

        Solution1 solution1 = new Solution1();
        solution1.solution(priorities, 0);
    }
}
