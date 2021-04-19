package 프로그래머스.코딩테스트_연습.레벨2.튜플;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Tuple implements Comparator<String[]> {

    ArrayList<String[]> numberArrayList = new ArrayList<>();

    public int[] solution(String s) {
        splitNumber(s);
        return analyzeNumber();
    }

    private void splitNumber(String s) {
        s = s.substring(1, s.length()-1);
        String[] splitS = s.split("}");

        for (int i = 0; i < splitS.length; i++) {
            int startIdx = (i == 0) ? 1 : 2;
            String[] numberArray = splitS[i].substring(startIdx).split(",");
            numberArrayList.add(numberArray);
        }
        numberArrayList.sort(this);
    }

    private int[] analyzeNumber() {
        int currentTupleIdx = 0;
        int[] tuple = new int[numberArrayList.get(numberArrayList.size()-1).length];

        for (int i = 0; i < numberArrayList.size(); i++) {
            ArrayList<String> numberList = new ArrayList<>(Arrays.asList(numberArrayList.get(i)));
            for (int j = 0; j < currentTupleIdx; j++) numberList.remove(String.valueOf(tuple[j]));
            tuple[currentTupleIdx++] = Integer.parseInt(numberList.get(0));
        }
        return tuple;
    }

    @Override
    public int compare(String[] numberArray1, String[] numberArray2) {
        return Integer.compare(numberArray1.length, numberArray2.length);
    }

    public static void main(String[] args) {
        Tuple tuple = new Tuple();
        tuple.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
    }
}