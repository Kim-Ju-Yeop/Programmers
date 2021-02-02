package 프로그래머스.코딩테스트_연습.레벨2.문자열_압축;

public class Compression2 {

    public int solution(String s) {
        int answer = 0;

        for (int i = 1; i <= (s.length() / 2)+1; i++) {
            int result = getSplitedLength(s, i, 1).length();
            answer = i == 1 ? result : (Math.min(answer, result));
        }
        return answer;
    }

    private String getSplitedLength(String s, int n, int repeat) {
        if (s.length() < n) return s;

        String result = "";
        String preString = s.substring(0, n);
        String postString = s.substring(n);

        if (!postString.startsWith(preString)) {
            if (repeat == 1) return result += preString + getSplitedLength(postString, n, 1);
            return result += repeat + preString + getSplitedLength(postString, n, 1);
        }
        return result += getSplitedLength(postString, n , repeat+1);
    }

    public static void main(String[] args) {
        Compression2 compression2 = new Compression2();
        compression2.solution("abcabcabcabcdededededede");
    }
}