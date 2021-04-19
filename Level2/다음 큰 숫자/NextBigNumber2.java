package 프로그래머스.코딩테스트_연습.레벨2.다음_큰_숫자;

public class NextBigNumber2 {

    public int solution(int n) {
        int postPattern = n & -n;
        int smallPattern = ((n ^ (n + postPattern)) / postPattern) >> 2;
        return n + postPattern | smallPattern;
    }

    public static void main(String[] args) {
        NextBigNumber2 nextBigNumber2 = new NextBigNumber2();
        nextBigNumber2.solution(78);
    }
}