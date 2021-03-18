package 프로그래머스.코딩테스트_연습.레벨2.전화번호_목록;

import java.util.Arrays;
import java.util.HashMap;

public class PhoneBook2 {

    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        boolean answer = true;
        HashMap<String, String> hashMap = new HashMap();
        for (int i = 0; i < phone_book.length; i++) {
            boolean isContain = false;

            for (int j = 0; j < i; j++) {
                String temp = "";
                if (phone_book[j].length() <= phone_book[i].length()) {
                    temp = phone_book[i].substring(0, phone_book[j].length());
                }

                if (hashMap.containsKey(temp)) {
                    isContain = true;
                    break;
                }
            }

            if (!isContain) hashMap.put(phone_book[i], phone_book[i]);
            else {
                answer = false;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] phone_book = { "119", "97674223", "1195524421" };

        PhoneBook2 phoneBook2 = new PhoneBook2();
        phoneBook2.solution(phone_book);
    }
}