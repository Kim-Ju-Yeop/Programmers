package example30;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {

    public int[] solution(int n, int m) {
        int[] result = new int[2];

        List<Integer> nDivisorList = new ArrayList<>();
        List<Integer> mDivisorList = new ArrayList<>();

        setDivisor(nDivisorList, n);
        setDivisor(mDivisorList, m);

        result[0] = findMaxDivisor(nDivisorList, mDivisorList);
        result[1] = findMinMultiple(n, m, result[0]);

        return result;
    }

    public void setDivisor(List<Integer> divisorList, int divisorNumber) {
        divisorList.add(1);
        for (int i = 2; i <= divisorNumber; i++) {
            if (divisorNumber % i == 0) divisorList.add(i);
        }
    }

    public int findMaxDivisor(List<Integer> nDivisorList, List<Integer> mDivisorList) {
        int maxDivisor = 0;

        for (int n = nDivisorList.size()-1; n >= 0; n--) {
            for (int m = mDivisorList.size()-1; m >= 0; m--) {
                if (nDivisorList.get(n).equals(mDivisorList.get(m))) {
                    maxDivisor = nDivisorList.get(n);
                    break;
                }
            }
            if (maxDivisor != 0) break;
        }
        return maxDivisor;
    }

    public int findMinMultiple(int n, int m, int maxDivisor) {
        for (int i = maxDivisor; ; i++) {
            if (i % n == 0 && i % m == 0) {
                return i;
            }
        }
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        solution1.solution(3, 12);
    }
}
