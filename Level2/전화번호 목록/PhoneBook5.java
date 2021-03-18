package 프로그래머스.코딩테스트_연습.레벨2.전화번호_목록;

import java.util.Arrays;

public class PhoneBook5 {

    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length-1; i++) {
            if (phone_book[i+1].startsWith(phone_book[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] phone_book = { "119", "97674223", "1195524421" };

        PhoneBook5 phoneBook5 = new PhoneBook5();
        phoneBook5.solution(phone_book);
    }
}