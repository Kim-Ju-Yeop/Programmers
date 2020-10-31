package example2;

import java.util.Arrays;

class Solution4 {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        int i;

        for(i = 0; i < participant.length-1; i++) {
            if(participant[i] != (completion[i])) {
                return participant[i];
            }
        }
        return participant[i];
    }

    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        Solution4 solution4 = new Solution4();
        String answer = solution4.solution(participant, completion);

        System.out.println(answer);
    }
}