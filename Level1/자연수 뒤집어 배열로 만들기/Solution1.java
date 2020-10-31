package example24;

public class Solution1 {

    public int[] solution(long n){
        String stringN = String.valueOf(n);
        int[] answer = new int[stringN.length()];

        for (int i = 0; i < stringN.length(); i++) {
            answer[i] = Integer.parseInt(String.valueOf(stringN.charAt(i)));
        }

        for (int i = 0; i < answer.length / 2; i++) {
            int start = answer[i];
            int end = answer[answer.length-1 - i];

            answer[i] = end;
            answer[answer.length-1 - i] = start;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        solution1.solution(12345);
    }
}
