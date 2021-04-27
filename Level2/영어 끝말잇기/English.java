package 프로그래머스.코딩테스트_연습.레벨2.영어_끝말잇기;

import java.util.HashSet;

public class English {

    public int[] solution(int n, String[] words) {
        int userIdx = 0;
        int repeatCount = 0;
        boolean isSuccess = true;

        HashSet<String> hashSet = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            if (i % n == 0) repeatCount++;
            if (i == 0) hashSet.add(words[i]);
            else {
                char preWords = words[i-1].charAt(words[i-1].length()-1);
                char curWords = words[i].charAt(0);

                if (preWords != curWords || !hashSet.add(words[i])) isSuccess = false;
                if (!isSuccess) {
                    userIdx = (i+1) % n != 0 ? (i+1) % n : n;
                    break;
                }
            }
        }

        if (isSuccess) repeatCount = 0;
        return new int[] {userIdx, repeatCount};
    }

    public static void main(String[] args) {
        int n = 3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};

        English english = new English();
        english.solution(n, words);
    }
}