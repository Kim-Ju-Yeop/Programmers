package 프로그래머스.코딩테스트_연습.레벨2.영어_끝말잇기;

import java.util.HashSet;

public class English2 {

    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        char chEnd = words[0].charAt(words[0].length()-1);
        char chStart;

        HashSet<String> log = new HashSet<>();
        log.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            chStart = words[i].charAt(0);
            log.add(words[i]);

            if (chEnd != chStart || log.size() != i + 1) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            }

            chEnd = words[i].charAt(words[i].length()-1);
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};

        English2 english2 = new English2();
        english2.solution(n, words);
    }
}