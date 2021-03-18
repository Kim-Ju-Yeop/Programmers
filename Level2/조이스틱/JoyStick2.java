package 프로그래머스.코딩테스트_연습.레벨2.조이스틱;

public class JoyStick2 {

    private int solution(String name) {
        int answer = 0;
        int[] diff = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };

        for (char c : name.toCharArray()) {
            answer += diff[c-'A'];
        }

        int length = name.length();
        int min = length-1;

        for (int i = 0; i < length; i++) {
            int next = i+1;
            while (next < length && name.charAt(next) == 'A') {
                next++;
            }
            min = Math.min(min, i+length-next+Math.min(i, length-next));
        }
        return answer+min;
    }

    public static void main(String[] args) {
        JoyStick2 joyStick2 = new JoyStick2();
        joyStick2.solution("JAN");
    }
}