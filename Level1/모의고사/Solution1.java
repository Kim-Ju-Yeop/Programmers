package example3;

import java.util.ArrayList;

public class Solution1 {

    ArrayList<Integer> firstList = new ArrayList<>();
    ArrayList<Integer> secondList = new ArrayList<>();
    ArrayList<Integer> thirdList = new ArrayList<>();

    int firstCount = 0;
    int secondCount = 0;
    int thirdCount = 0;

    public int[] solution(int[] answers) {
        setData();
        compareData(answers);
        int[] memberResult = resultMember();

        return memberResult;
    }

    public int[] resultMember() {
        int[] member = {firstCount, secondCount, thirdCount};
        int max = member[0];

        for(int i = 0; i < member.length; i++) {
            if(max <= member[i]){
                max = member[i];
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < member.length; i++) {
            if(max == member[i]) {
                result.add(i+1);
            }
        }

        int[] memberResult = new int[result.size()];

        for(int i = 0; i < memberResult.length; i++) {
            memberResult[i] = result.get(i);
        }

        return memberResult;
    }

    public void compareData(int[] answers) {
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == firstList.get(i)) firstCount++;
            if(answers[i] == secondList.get(i)) secondCount++;
            if(answers[i] == thirdList.get(i)) thirdCount++;

            firstList.addAll(firstList);
            secondList.addAll(secondList);
            thirdList.addAll(thirdList);
        }
    }

    public void setData() {
        firstList.add(1);
        firstList.add(2);
        firstList.add(3);
        firstList.add(4);
        firstList.add(5);

        secondList.add(2);
        secondList.add(1);
        secondList.add(2);
        secondList.add(3);
        secondList.add(2);
        secondList.add(4);
        secondList.add(2);
        secondList.add(5);

        thirdList.add(3);
        thirdList.add(3);
        thirdList.add(1);
        thirdList.add(1);
        thirdList.add(2);
        thirdList.add(2);
        thirdList.add(4);
        thirdList.add(4);
        thirdList.add(5);
        thirdList.add(5);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        Solution1 solution1 = new Solution1();
        int[] result = solution1.solution(arr);

        for(int i : result) {
            System.out.print(i + " ");
        }
    }
}
