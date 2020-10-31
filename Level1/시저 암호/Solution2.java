package example19;

public class Solution2 {
    public String solution(String s, int n) {
        String result = "";
        n %= 26;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isLowerCase(ch)) ch = (char) ((ch - 'a' + n) % 26 + 'a');
            else if (Character.isUpperCase(ch)) ch = (char) ((ch - 'A' + n) % 26 + 'A');

            result += ch;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        solution2.solution("AB", 1);
    }
}
