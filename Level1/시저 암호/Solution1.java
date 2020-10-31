package example19;

public class Solution1 {
    public String solution(String s, int n) {
        int[] charList = new int[s.length()];
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            charList[i] = s.charAt(i);

            if (charList[i] == 32) continue;
            for (int j = 0; j < n; j++) {
                if (Character.isUpperCase(charList[i]) && charList[i] == 90) charList[i] = 64;
                else if (Character.isLowerCase(charList[i]) && charList[i] == 122) charList[i] = 96;

                charList[i] += 1;
            }
        }

        for (int c : charList) {
            answer.append((char) c);
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        solution1.solution("AB", 1);
    }
}
