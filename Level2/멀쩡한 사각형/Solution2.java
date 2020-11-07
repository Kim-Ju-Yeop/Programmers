package example44;

import java.math.BigInteger;

public class Solution2 {

    public long solution(int w, int h) {
        long totalCount = (long) w * (long) h;
        long diagonalCount = w + h - BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).longValue();

        return totalCount - diagonalCount;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        solution2.solution(8, 12);
    }
}
