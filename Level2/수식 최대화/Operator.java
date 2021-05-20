package 프로그래머스.코딩테스트_연습.레벨2.수식_최대화;

import java.util.ArrayList;

public class Operator {

    ArrayList<Long> numberList = new ArrayList<>();
    ArrayList<String> operatorList = new ArrayList<>();
    ArrayList<String> operatorCaseList = new ArrayList<>();

    public long solution(String expression) {
        seperateExpression(expression);
        setOperateCase();

        long answer = getMaxCalValue((ArrayList<Long>) numberList.clone(), (ArrayList<String>) operatorList.clone());
        return answer;
    }

    private void seperateExpression(String expression) {
        String[] numberArr = expression.split("[^0-9]");
        String[] operatorArr = expression.split("[0-9]");

        for (String number : numberArr) numberList.add(Long.parseLong(number));
        for (String operator : operatorArr) if (!operator.isEmpty()) operatorList.add(operator);
    }

    private void setOperateCase() {
        boolean addIsExist = operatorList.contains("+");
        boolean subIsExist = operatorList.contains("-");
        boolean mulIsExist = operatorList.contains("*");

        if (addIsExist && subIsExist && mulIsExist) {
            operatorCaseList.add("+-*");
            operatorCaseList.add("+*-");
            operatorCaseList.add("-+*");
            operatorCaseList.add("-*+");
            operatorCaseList.add("*+-");
            operatorCaseList.add("*-+");
            return;
        }

        if (addIsExist && subIsExist) {
            operatorCaseList.add("+-");
            operatorCaseList.add("-+");
            return;
        }
        if (addIsExist && mulIsExist) {
            operatorCaseList.add("+*");
            operatorCaseList.add("*+");
            return;
        }
        if (subIsExist && mulIsExist) {
            operatorCaseList.add("-*");
            operatorCaseList.add("*-");
            return;
        }

        if (addIsExist) operatorCaseList.add("+");
        if (subIsExist) operatorCaseList.add("-");
        if (mulIsExist) operatorCaseList.add("*");
    }

    private long getMaxCalValue(ArrayList<Long> numberList, ArrayList<String> operatorList) {
        long maxCalValue = 0;
        for (String operatorCase : operatorCaseList) {
            String[] curOperatorCase = operatorCase.split("");
            ArrayList<Long> curNumberList = (ArrayList<Long>) numberList.clone();
            ArrayList<String> curOperatorList = (ArrayList<String>) operatorList.clone();

            for (String curOperator : curOperatorCase) {
                while (curOperatorList.contains(curOperator)) {
                    int idx = curOperatorList.indexOf(curOperator);
                    curOperatorList.remove(curOperator);

                    long firstNum = curNumberList.get(idx);
                    long secondNum = curNumberList.get(idx+1);
                    curNumberList.remove(idx);
                    curNumberList.remove(idx);
                    curNumberList.add(idx, calculateNumber(curOperator, firstNum, secondNum));
                }
            }

            long calValue = Math.abs(curNumberList.get(0));
            if (maxCalValue <= calValue) maxCalValue = calValue;
        }
        return maxCalValue;
    }

    private long calculateNumber(String operator, long firstNum, long secondNum) {
        if (operator.equals("+")) return firstNum + secondNum;
        else if (operator.equals("-")) return firstNum - secondNum;
        else return firstNum * secondNum;
    }

    public static void main(String[] args) {
        Operator operator = new Operator();
        operator.solution("100-200*300-500+20");
    }
}