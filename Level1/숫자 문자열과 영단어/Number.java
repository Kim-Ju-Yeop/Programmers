package 프로그래머스.코딩테스트_연습.레벨1.숫자_문자열과_영단어;

import java.util.ArrayList;

public class Number {

    ArrayList<String> numberEngList = new ArrayList<>();

    private int solution(String s) {
        setNumberEngList();

        String answer = "";
        String temp = "";

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                answer += s.charAt(i);
                temp = "";
                continue;
            }

            temp += s.charAt(i);
            int idx = numberEngList.indexOf(temp);

            if (idx != -1) {
                answer += idx;
                temp = "";
            }
        }
        return Integer.parseInt(answer);
    }

    private void setNumberEngList() {
        numberEngList.add("zero");
        numberEngList.add("one");
        numberEngList.add("two");
        numberEngList.add("three");
        numberEngList.add("four");
        numberEngList.add("five");
        numberEngList.add("six");
        numberEngList.add("seven");
        numberEngList.add("eight");
        numberEngList.add("nine");
    }

    public static void main(String[] args) {
        Number number = new Number();
        number.solution("one4seveneight");
    }
}