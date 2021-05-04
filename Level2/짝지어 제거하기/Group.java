package 프로그래머스.코딩테스트_연습.레벨2.짝지어_제거하기;

public class Group {

    public int solution(String s) {
        if (isFinish(s)) return 0;

        StringBuilder builder = new StringBuilder(s);

        char prevChar = '0';
        for (int i = 0; i < builder.length(); i++) {
            char curChar = builder.charAt(i);
            if (prevChar == curChar) {
                builder.delete(i-1, i+1);
                prevChar = '0';
                i = -1;
                continue;
            }
            prevChar = builder.charAt(i);
        }
        return builder.length() == 0 ? 1 : 0;
    }

    private boolean isFinish(String s) {
        if (s.length() % 2 != 0) return true;
        else {
            int[] alphabet = new int[36];
            for (char c : s.toCharArray()) alphabet[(int)c - 97] += 1;
            for (int i = 0; i < alphabet.length; i++) if (!(alphabet[i] == 0 || alphabet[i] % 2 == 0)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Group group = new Group();
        group.solution("baabaa");
    }
}