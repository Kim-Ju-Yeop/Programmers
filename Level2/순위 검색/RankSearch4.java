package 프로그래머스.코딩테스트_연습.레벨2.순위_검색;

import java.util.*;

public class RankSearch4 implements Comparator<String> {

    int[] answer;
    ArrayList<String> infoCaseList = new ArrayList<>();
    HashMap<String, ArrayList<Integer>> infoHashMap = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        answer = new int[query.length];
        initInfoCaseList(1, 4, new LinkedList<>());
        addInfoHashMap(info);
        actionQuery(query);
        return answer;
    }

    private void initInfoCaseList(int numCount, int maxLength, LinkedList<Integer> linkedList) {
        if (linkedList.size() == maxLength) {
            String infoCase = "";
            for (int l : linkedList) infoCase += l;
            infoCaseList.add(infoCase);
            return;
        }

        for (int i = 0; i <= numCount; i++) {
            linkedList.add(i);
            initInfoCaseList(numCount, maxLength, linkedList);
            linkedList.removeLast();
        }
    }

    private void addInfoHashMap(String[] info) {
        Arrays.sort(info, this);
        for (int i = 0; i < info.length; i++) {
            String[] splitInfo = info[i].split(" ");

            for (int j = 0; j < infoCaseList.size(); j++) {
                String key = "";
                String currentInfoCase = infoCaseList.get(j);

                for (int k = 0; k < currentInfoCase.length(); k++) {
                    if (currentInfoCase.charAt(k) == '0') key += splitInfo[k];
                    if (currentInfoCase.charAt(k) == '1') key += "-";
                }

                ArrayList<Integer> value = infoHashMap.get(key) != null ? infoHashMap.get(key) : new ArrayList<>();
                value.add(Integer.parseInt(splitInfo[4]));
                infoHashMap.put(key, value);
            }
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

            if (infoHashMap.containsKey(key)) {
                ArrayList<Integer> value = infoHashMap.get(key);

                int start = 0, end = value.size()-1;
                while (start <= end) {
                    int mid = (start+end) / 2;
                    if (value.get(mid) < Integer.parseInt(currentQuery[4])) start = mid+1;
                    else end = mid-1;
                }
                count = value.size()-start;
            }
            answer[i] = count;
        }
    }

    @Override
    public int compare(String s1, String s2) {
        int n1 = Integer.parseInt(s1.split(" ")[4]);
        int n2 = Integer.parseInt(s2.split(" ")[4]);
        return Integer.compare(n1, n2);
    }

    public static void main(String[] args) {
        String[] info = { "java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50" };
        String[] query = { "java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150" };

        RankSearch4 rankSearch4 = new RankSearch4();
        rankSearch4.solution(info, query);
    }
}