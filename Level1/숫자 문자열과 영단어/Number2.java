package 프로그래머스.코딩테스트_연습.레벨1.숫자_문자열과_영단어;

public class Number2 {

    public int solution(String s) {
        String[] number = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
        String[] numberEng = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

        for (int i = 0; i < number.length; i++) {
            s = s.replaceAll(numberEng[i], number[i]);
        }
        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        Number2 number2 = new Number2();
        number2.solution("one4seveneight");
    }
}