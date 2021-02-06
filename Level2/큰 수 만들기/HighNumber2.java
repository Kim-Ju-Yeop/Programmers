package 프로그래머스.코딩테스트_연습.레벨2.큰_수_만들기;

public class HighNumber2 {

    public String solution(String number, int k) {
        int[] numberArr = new int[number.length()];
        for (int i = 0; i < number.length(); i++) numberArr[i] = Integer.parseInt(number.substring(i, i+1));

        int startIdx = 0;
        int[] answerArr = new int[number.length()-k];
        for (int i = 0; i < answerArr.length; i++) {
            int maxValue = -1;
            int maxValueIdx = -1;
            int endIdx = (numberArr.length - ((answerArr.length-1) - i));

            for (int j = startIdx; j < endIdx; j++) {
                if (maxValue < numberArr[j]) {
                    maxValue = numberArr[j];
                    maxValueIdx = j;
                    if (maxValue == 9) break;
                }
            }
            answerArr[i] = maxValue;
            startIdx = maxValueIdx + 1;
        }

        String result = "";
        for (int answer : answerArr) result += answer;
        return result;
    }

    public static void main(String[] args) {
        HighNumber2 highNumber2 = new HighNumber2();
        highNumber2.solution("1231234", 3);
    }
}