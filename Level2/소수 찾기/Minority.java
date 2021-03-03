package 프로그래머스.코딩테스트_연습.레벨2.소수_찾기;

import java.util.ArrayList;

public class Minority {

    ArrayList<String> combNumberList = new ArrayList<>();
    ArrayList<Integer> finalNumberList = new ArrayList<>();

    public int solution(String numbers) {
        int[] arr = separateNumbers(numbers);

        combNumbers(arr, arr.length, "");
        removeDupplicate();

        int answer = getMinorityCount();
        return answer;
    }

    private int[] separateNumbers(String numbers) {
        int[] arr = new int[numbers.length()];
        for (int i = 0; i < numbers.length(); i++) {
            arr[i] = Integer.parseInt(String.valueOf(numbers.charAt(i)));
        }
        return arr;
    }

    private void combNumbers(int[] numArr, int idx, String number) {
        if (!number.isEmpty()) combNumberList.add(number);

        if (idx == 0) return;
        else {
            for (int i = 0; i < numArr.length; i++) {
                String n = String.valueOf(numArr[i]);
                String newNum = number + n;

                if (!number.contains(n)) {
                    combNumbers(numArr, idx-1, newNum);
                } else {
                    int count = 0;
                    for (int num : numArr) if (num == Integer.parseInt(n)) count++;

                    int count2 = 0;
                    for (int j = 0; j < (newNum).length(); j++) {
                        if (String.valueOf((newNum).charAt(j)).equals(n)) count2++;
                    }

                    if (count2 <= count) combNumbers(numArr, idx-1, newNum);
                }
            }
        }
    }

    private void removeDupplicate() {
        ArrayList<Integer> integerNumberList = new ArrayList<>();
        for (String answer : combNumberList) {
            integerNumberList.add(Integer.valueOf(answer));
        }

        ArrayList<Integer> numberList = new ArrayList<>();
        for (int i = 0; i < integerNumberList.size(); i++) {
            if (!numberList.contains(integerNumberList.get(i))) {
                numberList.add(integerNumberList.get(i));
            }
        }
        finalNumberList = numberList;
    }

    private int getMinorityCount() {
        int count = 0;
        for (int num : finalNumberList) {
            if (!(num == 0 || num == 1)) {
                boolean isMinority = true;
                for (int i = 2; i <= Math.sqrt(num); i++) {
                    if (num % i == 0) {
                        isMinority = false;
                        break;
                    }
                }
                if (isMinority) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Minority minority = new Minority();
        minority.solution("1234");
    }
}