package example31;

public class Solution1 {

    public int solution(double num) {
        for (int i = 0; i < 500; i++) {
            if (num == 1) return i;
            else {
                if (num % 2 == 0) {
                    num = even(num);
                } else {
                    num = odd(num);
                }
            }
        }
        return -1;
    }

    public double even(double evenNum) {
        return evenNum / 2;
    }
    public double odd(double oddNum) {
        return (oddNum * 3) + 1;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        solution1.solution(626331);
    }
}
