package example2;

import java.util.ArrayList;

class Solution3 {
    public String solution(String[] participant, String[] completion) {
        ArrayList<String> list = new ArrayList<>();

        for (String com : completion) {
            list.add(com);
        }

        for (int i = 0; i < participant.length; i++) {
            if (list.contains(participant[i])) {
                list.remove(participant[i]);
            } else {
                return participant[i];
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        Solution3 solution3 = new Solution3();
        String answer = solution3.solution(participant, completion);

        System.out.println(answer);
    }
}