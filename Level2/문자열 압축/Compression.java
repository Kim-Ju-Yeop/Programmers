package 프로그래머스.코딩테스트_연습.레벨2.문자열_압축;

public class Compression {

    public int solution(String s) {
        int minLength = 0;

        for (int i = 1; i <= s.length(); i++) {
            int arrLength = s.length() / i;
            if (s.length() % i != 0) arrLength++;

            String[] arr = subString(s, i, arrLength);
            int length = findLength(arr);

            if (i == 1) minLength = length;
            else if (length < minLength) minLength = length;
        }
        return minLength;
    }

    private String[] subString(String s, int subSize, int arrLength) {
        int startIdx = 0;
        int endIdx = subSize;
        String[] arr = new String[arrLength];

        for (int i = 0; i < arrLength; i++) {
            if (endIdx > s.length()) endIdx = s.length();
            arr[i] = s.substring(startIdx, endIdx);
            startIdx = endIdx;
            endIdx += subSize;
        }
        return arr;
    }

    private int findLength(String[] arr) {
        int i;
        int count = 1;
        String answer = "";

        for (i = 0; i < arr.length-1; i++) {
            if (arr[i].equals(arr[i + 1])) count++;
            else {
                if (count == 1) answer += arr[i];
                else answer += count + arr[i];
                count = 1;
            }
        }

        if (count == 1) answer += arr[i];
        else answer += count + arr[i];
        return answer.length();
    }

    public static void main(String[] args) {
        Compression compression = new Compression();
        compression.solution("abcabcabcabcdededededede");
    }
}