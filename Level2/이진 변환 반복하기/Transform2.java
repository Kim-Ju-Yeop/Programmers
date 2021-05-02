package 프로그래머스.코딩테스트_연습.레벨2.이진_변환_반복하기;

public class Transform2 {

    public int[] solution(String s) {
        int[] answer = new int[2];
        int temp;

        while(!s.equals("1")) {
            answer[1] += s.length();

            s = s.replaceAll("0", "");
            temp = s.length();
            s = Integer.toBinaryString(temp);

            answer[0]++;
            answer[1] -= temp;
        }
        return answer;
    }

    public static void main(String[] args) {
        Transform2 transform2 = new Transform2();
        transform2.solution("110010101001");
    }
}
