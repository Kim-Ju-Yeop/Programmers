package example2;

public class Solution1 {
    public String solution(String[] participant, String[] completion) {
        int equalsData = 0;

        for (int i = 0; i < participant.length; i++) {
            for (int j = 0; j < completion.length; j++) {
                if (participant[i].equals(completion[j])) {
                    equalsData = 1;
                    completion[j] = " ";
                    break;
                } else {
                    equalsData = 0;
                }
            }

            if (equalsData == 0) {
                return participant[i];
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        Solution1 solution1 = new Solution1();
        String answer = solution1.solution(participant, completion);

        System.out.println(answer);
    }
}
