package example34;

public class Solution1 {

    public String solution(String phone_number) {
        StringBuilder answer = new StringBuilder();
        String endPhoneNumber = phone_number.substring(phone_number.length()-4);

        for (int i = 0; i < phone_number.length()-4; i++) {
            answer.append("*");
        }
        answer.append(endPhoneNumber);
        return answer.toString();
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        solution1.solution("01033334444");
    }
}
