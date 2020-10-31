package example34;

public class Solution2 {

    public String solution(String phone_number) {
        char[] chars = phone_number.toCharArray();

        for (int i = 0; i < chars.length - 4; i++) {
            chars[i] = '*';
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        solution2.solution("01033334444");
    }
}
