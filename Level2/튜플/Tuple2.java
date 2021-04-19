package 프로그래머스.코딩테스트_연습.레벨2.튜플;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Tuple2 {

    public int[] solution(String s) {
        Set<String> set = new HashSet<>();
        String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
        Arrays.sort(arr, Comparator.comparingInt(String::length));

        int[] answer = new int[arr.length];
        int idx = 0;
        for(String s1 : arr) {
            for(String s2 : s1.split(",")) {
                if(set.add(s2)) answer[idx++] = Integer.parseInt(s2);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Tuple2 tuple2 = new Tuple2();
        tuple2.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
    }
}