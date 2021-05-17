package 프로그래머스.코딩테스트_연습.레벨2.뉴스_클러스터링;

import java.util.ArrayList;

public class News {

    ArrayList<String> aSet = new ArrayList<>();
    ArrayList<String> bSet = new ArrayList<>();

    public int solution(String str1, String str2) {
        makeSet(str1, str2);

        int intersectionCnt = findIntersectionCnt();
        int unionCnt = findUnionCnt();
        double answer = (unionCnt == 0) ? 65536.0 : ((double)intersectionCnt / (double)unionCnt) * 65536.0;

        return (int)answer;
    }

    private void makeSet(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        for (int i = 0; i < str1.length()-1; i++) {
            char first = str1.charAt(i);
            char second = str1.charAt(i+1);
            if (isAlphabet(first, second)) aSet.add(String.valueOf(first) + String.valueOf(second));
        }

        for (int i = 0; i < str2.length()-1; i++) {
            char first = str2.charAt(i);
            char second = str2.charAt(i+1);
            if (isAlphabet(first, second)) bSet.add(String.valueOf(first) + String.valueOf(second));
        }
    }

    private int findIntersectionCnt() {
        int cnt = 0;
        ArrayList<String> alReadyElement = new ArrayList<>();

        for (int i = 0; i < aSet.size(); i++) {
            String currentElement = aSet.get(i);

            if (bSet.contains(currentElement) && !alReadyElement.contains(currentElement)) {
                int aCnt = getSameElementCnt(currentElement, aSet);
                int bCnt = getSameElementCnt(currentElement, bSet);

                cnt += Math.min(aCnt, bCnt);
                alReadyElement.add(currentElement);
            }
        }
        return cnt;
    }

    private int findUnionCnt() {
        int cnt = 0;
        ArrayList<String> alReadyElement = new ArrayList<>();

        for (int i = 0; i < aSet.size(); i++) {
            String currentElement = aSet.get(i);

            if (!alReadyElement.contains(currentElement)) {
                int aCnt = getSameElementCnt(currentElement, aSet);
                int bCnt = getSameElementCnt(currentElement, bSet);

                cnt += Math.max(aCnt, bCnt);
                alReadyElement.add(currentElement);
            }
        }

        for (int i = 0; i < bSet.size(); i++) {
            String currentElement = bSet.get(i);

            if (!alReadyElement.contains(currentElement)) {
                int aCnt = getSameElementCnt(currentElement, aSet);
                int bCnt = getSameElementCnt(currentElement, bSet);

                cnt += Math.max(aCnt, bCnt);
                alReadyElement.add(currentElement);
            }
        }
        return cnt;
    }

    private boolean isAlphabet(char first, char second) {
        return ((int) first >= 97 && (int) first <= 122) && ((int) second >= 97 && (int) second <= 122);
    }

    private int getSameElementCnt(String element, ArrayList<String> set) {
        int cnt = 0;
        for (int j = 0; j < set.size(); j++) if (set.get(j).equals(element)) cnt++;
        return cnt;
    }

    public static void main(String[] args) {
        String str1 = "FRANCE";
        String str2 = "french";

        News news = new News();
        news.solution(str1, str2);
    }
}