package 프로그래머스.코딩테스트_연습.레벨2.후보키;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

public class Key implements Comparator<String> {

    ArrayList<Integer> columnIdxList = new ArrayList<>();
    ArrayList<String> combinationList = new ArrayList<>();

    public int solution(String[][] relation) {
        analyzeColumn(relation);
        combinationCandidateKey(relation);
        findAnswer();

        return combinationList.size();
    }

    private void analyzeColumn(String[][] relation) {
        int width = relation[0].length;
        int height = relation.length;

        for (int w = 0; w < width; w++) {
            HashSet<String> set = new HashSet<>();
            boolean isSuccess = true;

            for (int h = 0; h < height; h++) {
                if (!set.add(relation[h][w])) {
                    isSuccess = false;
                    columnIdxList.add(w);
                    break;
                }
            }

            if (isSuccess) combinationList.add(String.valueOf(w));
        }
    }

    private void combinationCandidateKey(String[][] relation) {
        for (int i = 0; i < columnIdxList.size()-1; i++) {

            for (int j = i+1; j < columnIdxList.size(); j++) {
                ArrayList<String> list = new ArrayList<>();
                boolean isSuccess = true;

                for (int h = 0; h < relation.length; h++) {
                    int fIdx = columnIdxList.get(i);
                    int sIdx = columnIdxList.get(j);

                    String value = relation[h][fIdx] + relation[h][sIdx];
                    if (list.contains(value)) isSuccess = false;
                    list.add(value);
                }

                if (isSuccess) combinationList.add(columnIdxList.get(i) + "" + columnIdxList.get(j));
                else {
                    for (int k = j+1; k < columnIdxList.size(); k++) {
                        isSuccess = true;

                        for (int h = 0; h < relation.length; h++) {
                            int nIdx = columnIdxList.get(k);

                            String value = list.get(h) + relation[h][nIdx];
                            if (list.contains(value)) isSuccess = false;
                            list.remove(h);
                            list.add(h, value);
                        }

                        if (isSuccess) {
                            String value = columnIdxList.get(i) + "" + columnIdxList.get(j);
                            for (int a = j+1; a <= k; a++) {
                                value += "" + columnIdxList.get(a);
                            }

                            combinationList.add(value);
                            break;
                        }
                    }
                }
            }
        }
    }

    private void findAnswer() {
        combinationList.sort(this);
        for (int i = 0; i < combinationList.size(); i++) {
            String curAnswer = combinationList.get(i);

            for (int j = 0; j < i; j++) {
                if (curAnswer.contains(combinationList.get(j))) {
                    combinationList.remove(i);
                    i--;
                    break;
                }
            }
        }
    }

    @Override
    public int compare(String o1, String o2) {
        return Integer.compare(o1.length(), o2.length());
    }

    public static void main(String[] args) {
        String[][] relation = {{"a", "1", "aaa", "c", "ng"}, {"b", "1", "bbb", "c", "g"}, {"c", "1", "aaa", "d", "ng"}, {"d", "2", "bbb", "d", "ng"}};

        Key key = new Key();
        key.solution(relation);
    }
}