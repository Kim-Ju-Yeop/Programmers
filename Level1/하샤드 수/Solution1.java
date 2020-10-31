package example33;

public class Solution1 {

    public boolean solution(int x) {
        int sum = 0;
        String stringX = String.valueOf(x);

        for (int i = 0; i < stringX.length(); i++) {
            sum += Integer.parseInt(String.valueOf(stringX.charAt(i)));
        }
        return x % sum == 0;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        solution1.solution(10);
    }
}
