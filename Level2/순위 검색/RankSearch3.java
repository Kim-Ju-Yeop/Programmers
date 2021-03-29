package 프로그래머스.코딩테스트_연습.레벨2.순위_검색;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class RankSearch3 {

    int[] answer;
    ArrayList<String> infoCaseList = new ArrayList<>();
    ArrayList<HashMap<String, Integer>> hashMapList = new ArrayList<>();

    public int[] solution(String[] info, String[] query) {
        answer = new int[query.length];
        initInfoCase(1, 4, new LinkedList<>());
        addHashMapList(info);
        actionQuery(query);
        return answer;
    }

    private void initInfoCase(int numCount, int maxLength, LinkedList<Integer> linkedList) {
        if (linkedList.size() == maxLength) {
            String info = "";
            for (int l : linkedList) info += l;
            infoCaseList.add(info);
            return;
        }

        for (int i = 0; i <= numCount; i++) {
            linkedList.add(i);
            initInfoCase(numCount, maxLength, linkedList);
            linkedList.removeLast();
        }
    }

    private void addHashMapList(String[] info) {
        for (int i = 0; i < info.length; i++) {
            String[] splitInfo = info[i].split(" ");
            HashMap<String, Integer> hashMap = new HashMap<>();

            for (int j = 0; j < infoCaseList.size(); j++) {
                String key = "";
                String currentInfoCase = infoCaseList.get(j);
                for (int k = 0; k < currentInfoCase.length(); k++) {
                    if (currentInfoCase.charAt(k) == '0') key += splitInfo[k];
                    if (currentInfoCase.charAt(k) == '1') key += "-";
                }
                hashMap.put(key, Integer.parseInt(splitInfo[4]));
            }
            hashMapList.add(hashMap);
        }
    }

    private void actionQuery(String[] query) {
        for (int i = 0; i < query.length; i++) {
            String[] splitQuery = query[i].split(" and ");
            String[] currentQuery = new String[5];
            currentQuery[0] = splitQuery[0];
            currentQuery[1] = splitQuery[1];
            currentQuery[2] = splitQuery[2];
            currentQuery[3] = splitQuery[3].split(" ")[0];
            currentQuery[4] = splitQuery[3].split(" ")[1];

            int count = 0;
            String key = currentQuery[0] + currentQuery[1] + currentQuery[2] + currentQuery[3];
            for (int j = 0; j < hashMapList.size(); j++) {
                HashMap<String, Integer> currentHashMap = hashMapList.get(j);
                if (currentHashMap.containsKey(key) && Integer.parseInt(currentQuery[4]) <= currentHashMap.get(key)) count++;
            }
            answer[i] = count;
        }
    }

    public static void main(String[] args) {
        String[] info = { "java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50" };
        String[] query = { "java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150" };

        RankSearch3 rankSearch3 = new RankSearch3();
        rankSearch3.solution(info, query);
    }
}