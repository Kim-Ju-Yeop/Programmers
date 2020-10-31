package example27;

import java.util.ArrayList;
import java.util.Collections;

public class Solution1 {

    public int[] solution(int[] arr) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int a : arr) arrayList.add(a);

        if (arrayList.size() == 1) {
            arrayList.remove(0);
            arrayList.add(-1);
        } else {
            arrayList.remove(Collections.min(arrayList));
        }

        int[] result = new int[arrayList.size()];
        int count = 0;

        for (Integer a : arrayList) result[count++] = a;
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1};

        Solution1 solution1 = new Solution1();
        solution1.solution(arr);
    }
}
