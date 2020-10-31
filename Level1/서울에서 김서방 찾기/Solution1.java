package example15;

public class Solution1 {

    public String solution(String[] seoul) {
        String answer = "";

        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                answer = "김서방은 " + i + "에 있다";
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] seoul = {"Jane", "Kim"};

        Solution1 solution1 = new Solution1();
        solution1.solution(seoul);
    }
}
