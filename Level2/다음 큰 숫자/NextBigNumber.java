package 프로그래머스.코딩테스트_연습.레벨2.다음_큰_숫자;

public class NextBigNumber {

    public int solution(int n) {
        int nOneCount = 0;
        String nBinaryString = Integer.toBinaryString(n);
        for (int i = 0; i < nBinaryString.length(); i++) {
            if (nBinaryString.charAt(i) == '1') nOneCount++;
        }
        return findNextNumber(n, nOneCount);
    }

    private int findNextNumber(int n, int nOneCount) {
        int answer = n+1;
        while (true) {
            int oneCount = 0;
            String binaryString = Integer.toBinaryString(answer);
            for (int i = 0; i < binaryString.length(); i++) {
                if (binaryString.charAt(i) == '1') oneCount++;
            }

            if (oneCount == nOneCount) break;
            else answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        NextBigNumber nextBigNumber = new NextBigNumber();
        nextBigNumber.solution(78);
    }
}