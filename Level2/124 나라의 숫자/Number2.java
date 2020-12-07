package programmers.question5;

public class Number2 {

    public String solution(int n) {
        String[] number = { "4", "1", "2" };
        String answer = "";

        while (n > 0) {
            answer = number[n % 3] + answer;
            n = (n-1) / 3;
        }
        return answer;
    }

    public static void main(String[] args) {
        Number2 number2 = new Number2();
        number2.solution(39);
    }
}
