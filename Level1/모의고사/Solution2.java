package example3;

import java.util.ArrayList;

public class Solution2 {

    int[] first = {1, 2, 3, 4, 5};
    int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
    int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    int[] result = {0, 0, 0};

    public int[] solution(int[] answers) {
        compareData(answers);

        int[] memberList = findMember();
        return memberList;
    }

    public void compareData(int[] answers) {
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == first[i % 5]) result[0]++;
            if (answers[i] == second[i % 8]) result[1]++;
            if (answers[i] == third[i % 10]) result[2]++;
        }
    }

    public int[] findMember() {
        int max = result[0];

        for (int i : result) {
            if(max <= i) max = i;
        }

        ArrayList<Integer> member = new ArrayList<>();

        for (int i = 0; i < result.length; i++) {
            if (max == result[i]) member.add(i + 1);
        }

        int[] memberList = new int[member.size()];

        for (int i = 0; i < memberList.length; i++) {
            memberList[i] = member.get(i);
        }

        return memberList;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4, 2};

        Solution2 solution2 = new Solution2();
        int[] memberList = solution2.solution(arr);

        for(int i : memberList) {
            System.out.print(i + " ");
        }
    }
}
