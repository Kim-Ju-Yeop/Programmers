package 프로그래머스.코딩테스트_연습.레벨2.다음_큰_숫자;

public class NextBigNumber3 {

    public int solution(int n) {
        int nOneCount = Integer.bitCount(n);
        int compare = n+1;

        while (true) {
            if (Integer.bitCount(compare) == nOneCount) break;
            compare++;
        }
        return compare;
    }

    public static void main(String[] args) {
        NextBigNumber3 nextBigNumber3 = new NextBigNumber3();
        nextBigNumber3.solution(78);
    }
}
