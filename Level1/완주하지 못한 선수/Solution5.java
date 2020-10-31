package example2;

import java.util.HashMap;

public class Solution5 {
    public String solution(String[] participant, String[] completion) {
        String answer = null;
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String part : participant) {
            hashMap.put(part, hashMap.getOrDefault(part, 0) + 1);
        }

        for (String com : completion) {
            hashMap.put(com, hashMap.get(com) - 1);
        }

        for (String key : hashMap.keySet()) {
            if (hashMap.get(key) != 0) {
                answer = key;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        Solution5 solution5 = new Solution5();
        String answer = solution5.solution(participant, completion);

        System.out.println(answer);
    }
}
