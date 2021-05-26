package 프로그래머스.코딩테스트_연습.레벨2.후보키;

import java.util.ArrayList;
import java.util.HashSet;

public class Key2 {

    private ArrayList<HashSet<Integer>> candidateKey;
    private String[][] table;
    private int length;
    private int answer;

    public int solution(String[][] relation) {
        candidateKey = new ArrayList<>();
        table = relation;
        answer = 0;
        length = relation[0].length;

        for (int i = 1; i <= length; i++) makeSet(-1, i, 0, new HashSet<>());
        return answer;
    }

    public void makeSet(int index, int target, int count, HashSet<Integer> set) {
        if (count == target) {
            if (!isUnique(set)) return;
            for (HashSet<Integer> key : candidateKey) {
                if (set.containsAll(key)) return;
            }

            candidateKey.add(set);
            answer++;
            return;
        }

        for(int i = index + 1; i < length; i++) {
            HashSet<Integer> newSet = new HashSet<>(set);
            newSet.add(i);
            makeSet(i, target, count + 1, newSet);
        }
    }

    public boolean isUnique(HashSet<Integer> set) {
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < table.length; i++) {
            String temp = "";
            for(int index : set) {
                temp += table[i][index];
            }

            if (!list.contains(temp)) list.add(temp);
            else return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[][] relation = {{"a", "1", "aaa", "c", "ng"}, {"b", "1", "bbb", "c", "g"}, {"c", "1", "aaa", "d", "ng"}, {"d", "2", "bbb", "d", "ng"}};

        Key2 key2 = new Key2();
        key2.solution(relation);
    }
}