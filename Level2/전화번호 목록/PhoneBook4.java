package 프로그래머스.코딩테스트_연습.레벨2.전화번호_목록;

import java.util.Arrays;

public class PhoneBook4 {

    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        boolean answer = true;
        for (int i = 0; i < phone_book.length-1; i++) {
            String temp = "";
            if (phone_book[i].length() <= phone_book[i+1].length()) {
                temp = phone_book[i+1].substring(0, phone_book[i].length());
            }

            if (phone_book[i].equals(temp)) {
                answer = false;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] phone_book = { "119", "97674223", "1195524421" };

        PhoneBook4 phoneBook4 = new PhoneBook4();
        phoneBook4.solution(phone_book);
    }
}