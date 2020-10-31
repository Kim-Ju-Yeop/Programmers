package example2;

import java.util.*;

class Solution2 {
    public String solution(String[] participant, String[] completion) {
        ArrayList<String> list = new ArrayList<>();
        Hashtable<String, ArrayList<String>> hashTable = new Hashtable<>();

        for (String com : completion) {
            list.add(com);
        }

        hashTable.put("dataList", list);

        for (int i = 0; i < participant.length; i++) {
            if (hashTable.get("dataList").contains(participant[i])) {
                hashTable.get("dataList").remove(participant[i]);
            } else {
                return participant[i];
            }
        }

        return null;
    }

    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        Solution2 solution2 = new Solution2();
        String answer = solution2.solution(participant, completion);

        System.out.println(answer);
    }
}