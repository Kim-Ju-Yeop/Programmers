package example17;

public class Solution2 {

    public String solution(int n) {
        return new String(new char[n / 2 + 1]).replace("\0", "수박").substring(0, n);
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        solution2.solution(3);
    }
}
