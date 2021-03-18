package 프로그래머스.코딩테스트_연습.레벨2.전화번호_목록;

import java.util.Arrays;

public class PhoneBook3 {

    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        boolean answer = true;
        for (int i = 0; i < phone_book.length; i++) {
            boolean isContain = false;

            for (int j = i+1; j < phone_book.length; j++) {
                String temp = "";
                if (phone_book[i].length() <= phone_book[j].length()) {
                    temp = phone_book[j].substring(0, phone_book[i].length());
                }

                if (phone_book[i].equals(temp)) {
                    isContain = true;
                    break;
                }
            }

            if (isContain) {
                answer = false;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] phone_book = { "119", "97674223", "1195524421" };

        PhoneBook3 phoneBook3 = new PhoneBook3();
        phoneBook3.solution(phone_book);
    }
}