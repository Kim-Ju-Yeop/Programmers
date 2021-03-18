package 프로그래머스.코딩테스트_연습.레벨2.전화번호_목록;

public class PhoneBook {

    public boolean solution(String[] phone_book) {
        boolean answer = true;

        for (int i = 0; i < phone_book.length-1; i++) {
            String temp = phone_book[i];

            for (int j = 0; j < phone_book.length; j++) {
                if (i != j && temp.length() <= phone_book[j].length()) {
                    if (temp.equals(phone_book[j].substring(0, temp.length()))) {
                        answer = false;
                        break;
                    }
                }
            }
            if (!answer) break;
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] phone_book = { "119", "97674223", "1195524421" };

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.solution(phone_book);
    }
}