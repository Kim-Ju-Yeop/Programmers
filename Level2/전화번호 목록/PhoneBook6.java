package 프로그래머스.코딩테스트_연습.레벨2.전화번호_목록;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook6 {

    public boolean solution(String[] phone_book) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < phone_book.length; i++) map.put(phone_book[i], i);

        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book[i].length(); j++) {
                if (map.containsKey(phone_book[i].substring(0, j))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] phone_book = { "5327", "521", "251", "4512", "231", "23125", "23245" };

        PhoneBook6 phoneBook6 = new PhoneBook6();
        phoneBook6.solution(phone_book);
    }
}