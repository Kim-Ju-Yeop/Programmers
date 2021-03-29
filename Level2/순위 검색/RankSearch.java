package 프로그래머스.코딩테스트_연습.레벨2.순위_검색;

import java.util.ArrayList;

public class RankSearch {

    private ArrayList<Integer> cppList = new ArrayList<>();
    private ArrayList<Integer> javaList = new ArrayList<>();
    private ArrayList<Integer> pythonList = new ArrayList<>();

    private ArrayList<Integer> backendList = new ArrayList<>();
    private ArrayList<Integer> frontendList = new ArrayList<>();

    private ArrayList<Integer> juniorList = new ArrayList<>();
    private ArrayList<Integer> seniorList = new ArrayList<>();

    private ArrayList<Integer> chickenList = new ArrayList<>();
    private ArrayList<Integer> pizzaList = new ArrayList<>();

    private ArrayList<Integer> pointList = new ArrayList<>();

    private int[] answer;

    public int[] solution(String[] info, String[] query) {
        answer = new int[query.length];

        for (int i = 0; i < info.length; i++) {
            String[] currentInfo = info[i].split(" ");
            for (int j = 0; j < currentInfo.length; j++) distinguishInfoData(currentInfo[j], i);
        }

        for (int i = 0; i < query.length; i++) {
            String[] splitQuery = query[i].split(" and ");
            String[] currentQuery = new String[5];
            currentQuery[0] = splitQuery[0];
            currentQuery[1] = splitQuery[1];
            currentQuery[2] = splitQuery[2];
            currentQuery[3] = splitQuery[3].split(" ")[0];
            currentQuery[4] = splitQuery[3].split(" ")[1];

            distinguishQueryData(i, currentQuery, currentQuery[0], 0, new ArrayList<>());
        }
        return answer;
    }

    private void distinguishInfoData(String infoData, int idx) {
        switch (infoData) {
            case "cpp": cppList.add(idx); break;
            case "java": javaList.add(idx); break;
            case "python": pythonList.add(idx); break;
            case "backend": backendList.add(idx); break;
            case "frontend": frontendList.add(idx); break;
            case "junior": juniorList.add(idx); break;
            case "senior": seniorList.add(idx); break;
            case "chicken": chickenList.add(idx); break;
            case "pizza": pizzaList.add(idx); break;
            default: pointList.add(Integer.parseInt(infoData));
        }
    }

    private void distinguishQueryData(int queryIdx, String[] currentQuery, String queryData, int queryDataIdx, ArrayList<Integer> list) {
        if (queryDataIdx == 0) {
            switch (queryData) {
                case "cpp": distinguishQueryData(queryIdx, currentQuery, currentQuery[queryDataIdx+1], queryDataIdx+1, cppList); break;
                case "java": distinguishQueryData(queryIdx, currentQuery, currentQuery[queryDataIdx+1], queryDataIdx+1, javaList); break;
                case "python": distinguishQueryData(queryIdx, currentQuery, currentQuery[queryDataIdx+1], queryDataIdx+1, pythonList); break;
                default: {
                    ArrayList<Integer> allList = new ArrayList<>();
                    for (int i = 0; i < (cppList.size() + javaList.size() + pythonList.size()); i++) allList.add(i);
                    distinguishQueryData(queryIdx, currentQuery, currentQuery[queryDataIdx+1], queryDataIdx+1, allList);
                }
            }
        }
        else if (queryDataIdx == 1) {
            switch (queryData) {
                case "backend": judgeContainData(queryIdx, currentQuery, queryData, queryDataIdx, backendList, list); break;
                case "frontend": judgeContainData(queryIdx, currentQuery, queryData, queryDataIdx, frontendList, list); break;
                default: distinguishQueryData(queryIdx, currentQuery, currentQuery[queryDataIdx+1], queryDataIdx+1, list);
            }
        }
        else if (queryDataIdx == 2) {
            switch (queryData) {
                case "junior": judgeContainData(queryIdx, currentQuery, queryData, queryDataIdx, juniorList, list); break;
                case "senior": judgeContainData(queryIdx, currentQuery, queryData, queryDataIdx, seniorList, list); break;
                default: distinguishQueryData(queryIdx, currentQuery, currentQuery[queryDataIdx+1], queryDataIdx+1, list);
            }
        }
        else if (queryDataIdx == 3) {
            switch (queryData) {
                case "chicken": judgeContainData(queryIdx, currentQuery, queryData, queryDataIdx, chickenList, list); break;
                case "pizza": judgeContainData(queryIdx, currentQuery, queryData, queryDataIdx, pizzaList, list); break;
                default: distinguishQueryData(queryIdx, currentQuery, currentQuery[queryDataIdx+1], queryDataIdx+1, list);
            }
        }
        else {
            int count = 0;
            for (int i = 0; i < list.size(); i++) if (Integer.parseInt(queryData) <= pointList.get(list.get(i))) count++;
            answer[queryIdx] = count;
        }
    }

    private void judgeContainData(int queryIdx, String[] currentQuery, String queryData, int queryDataIdx, ArrayList<Integer> correspondList, ArrayList<Integer> list) {
        ArrayList<Integer> allList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) if (correspondList.contains(list.get(i))) allList.add(list.get(i));
        distinguishQueryData(queryIdx, currentQuery, currentQuery[queryDataIdx+1], queryDataIdx+1, allList);
    }

    public static void main(String[] args) {
        String[] info = { "java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50" };
        String[] query = { "java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150" };

        RankSearch rankSearch = new RankSearch();
        rankSearch.solution(info, query);
    }
}