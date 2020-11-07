package example44;

public class Solution1 {

    public long solution(int w, int h) {
        long wl = Long.parseLong(String.valueOf(w));
        long hl = Long.parseLong(String.valueOf(h));

        return (w*h) - ((w+h) - gcd(wl, hl));
    }

    public long gcd(long w, long h) {
        if (h == 0) return w;
        return gcd(h, w % h);
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        solution1.solution(8, 12);
    }
}
