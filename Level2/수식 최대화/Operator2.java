package 프로그래머스.코딩테스트_연습.레벨2.수식_최대화;

import java.util.ArrayList;

public class Operator2 {

    public long solution(String expression) {
        long answer = 0;
        ArrayList<Long> numbers = new ArrayList<>();
        ArrayList<Character> operators = new ArrayList<>();

        String num = "";
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                operators.add(c);
                numbers.add(Long.parseLong(num));
                num = "";
            } else {
                num += c;
            }
        }
        numbers.add(Long.parseLong(num));

        long[] result = new long[6];
        result[0] = operation(numbers, operators, '+', '-', '*');
        result[1] = operation(numbers, operators, '+', '*', '-');
        result[2] = operation(numbers, operators, '-', '+', '*');
        result[3] = operation(numbers, operators, '-', '*', '+');
        result[4] = operation(numbers, operators, '*', '-', '+');
        result[5] = operation(numbers, operators, '*', '+', '-');

        for (int i = 0; i < 6; i++) {
            long value = Math.abs(result[i]);
            if (answer < value) answer = value;
        }
        return answer;
    }

    private long operation(ArrayList<Long> nums, ArrayList<Character> opers, char op1, char op2, char op3) {
        ArrayList<Long> numbers = (ArrayList<Long>) nums.clone();
        ArrayList<Character> operators = (ArrayList<Character>) opers.clone();

        calc(numbers, operators, op1);
        calc(numbers, operators, op2);
        calc(numbers, operators, op3);

        return numbers.get(0);
    }

    private void calc(ArrayList<Long> numbers, ArrayList<Character> operators, char op) {
        for (int i = 0; i < operators.size(); i++) {
            if (operators.get(i) == op) {
                long num1 = numbers.get(i);
                long num2 = numbers.get(i+1);
                long result = cal(num1, num2, op);

                numbers.remove(i);
                numbers.remove(i);
                numbers.add(i, result);
                operators.remove(i);
                i--;
            }
        }
    }

    private long cal(long a, long b, char op){
        if (op == '+') return a + b;
        else if (op == '-') return a - b;
        else return a * b;
    }

    public static void main(String[] args) {
        Operator2 operator2 = new Operator2();
        operator2.solution("100-200*300-500+20");
    }
}