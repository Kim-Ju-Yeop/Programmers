package example42;

import java.util.Stack;

public class Solution1 {

    public int solution(int n) {
        Stack<Integer> stack = new Stack<>();
        while (!(n == 0)) {
            stack.push(n % 3);
            n = n / 3;
        }

        int i = 0;
        int[] arr = new int[stack.size()];
        while (!(stack.isEmpty())) {
            arr[i++] = stack.pop();
        }

        StringBuffer reverseBuilder = new StringBuffer();
        for (int j = arr.length-1; j >= 0; j--) {
            reverseBuilder.append(arr[j]);
        }

        int total = 0;
        int count = 0;
        for (int j = reverseBuilder.toString().length()-1; j >= 0; j--) {
            total += Integer.parseInt(String.valueOf(reverseBuilder.toString().charAt(j))) * Math.pow(3, count++);
        }
        return total;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        solution1.solution(125);
    }
}
