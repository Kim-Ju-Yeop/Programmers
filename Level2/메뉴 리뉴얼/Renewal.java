package 프로그래머스.코딩테스트_연습.레벨2.메뉴_리뉴얼;

import java.util.*;

public class Renewal {

    private int size;
    private int num;
    private int[] arr;
    private ArrayList<ArrayList<Integer>> result;
    private HashMap<String, Integer> hashMap;

    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> answerList = new ArrayList<>();
        String[] sortOrders = sortOrders(orders);

        for (int combNum : course) {
            hashMap = new HashMap<>();
            for (int i = 0; i < sortOrders.length; i++) {
                int[] charArr = new int[sortOrders[i].length()];
                for (int j = 0; j < charArr.length; j++) charArr[j] = sortOrders[i].charAt(j);

                size = charArr.length;
                num = combNum;
                arr = new int[combNum];
                result = new ArrayList<>();

                combination(charArr, 0, 0, 0);
                setHashMapData();
            }
            ArrayList<String> list = getHashMapData();
            answerList.addAll(list);
        }

        Collections.sort(answerList);
        String[] answerArr = new String[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answerArr[i] = answerList.get(i);
        }
        return answerArr;
    }

    private String[] sortOrders(String[] orders) {
        int count = 0;
        String[] sortOrders = new String[orders.length];

        for (String order : orders) {
            char[] charList = new char[order.length()];
            for (int i = 0; i < order.length(); i++) charList[i] = order.charAt(i);
            Arrays.sort(charList);

            String sortOrder = "";
            for (char data : charList) sortOrder += data;
            sortOrders[count++] = sortOrder;
        }
        Arrays.sort(sortOrders);
        return sortOrders;
    }

    private void combination(int[] now, int depth, int index, int target) {
        if (depth == num) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                temp.add(now[arr[i]]);
            }
            result.add(temp);
            return;
        }
        if (target == size) return;
        arr[index] = target;
        combination(now, depth+1, index+1, target+1);
        combination(now, depth, index, target+1);
    }

    private void setHashMapData() {
        ArrayList<String> arrayList = new ArrayList<>();

        for (int i = 0; i < result.size(); i++) {
            String str = "";
            for (int j = 0; j < result.get(i).size(); j++) {
                str += ((char)(int)result.get(i).get(j));
            }
            arrayList.add(str);
        }
        for (int i = 0; i < arrayList.size(); i++) {
            if (hashMap.containsKey(arrayList.get(i))) {
                hashMap.put(arrayList.get(i), hashMap.get(arrayList.get(i)) + 1);
            } else {
                hashMap.put(arrayList.get(i), 1);
            }
        }
    }

    private ArrayList<String> getHashMapData() {
        int max = 0;
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<String> keys = hashMap.keySet().iterator();

        while (keys.hasNext()) {
            String key = keys.next();

            if (hashMap.get(key) >= 2) {
                if (max == 0) {
                    max = hashMap.get(key);
                    arrayList.add(key);
                } else {
                    if (hashMap.get(key) == max) {
                        arrayList.add(key);
                    } else if (hashMap.get(key) > max){
                        max = hashMap.get(key);
                        arrayList = new ArrayList<>();
                        arrayList.add(key);
                    }
                }
            }
        }
        return arrayList;
    }

    public static void main(String[] args) {
        String[] orders = { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" };
        int[] course = { 2, 3, 4 };

        Renewal renewal = new Renewal();
        renewal.solution(orders, course);
    }
}