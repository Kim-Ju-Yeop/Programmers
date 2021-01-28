package 프로그래머스.코딩테스트_연습.레벨1.신규_아이디_추천;

public class Solution1 {

    public String solution(String new_id) {
        new_id = firstStage(new_id);
        new_id = secondStage(new_id);
        new_id = thirdStage(new_id);
        new_id = fourthStage(new_id);
        new_id = fifthStage(new_id);
        new_id = sixthStage(new_id);
        new_id = seventhStage(new_id);

        return new_id;
    }

    // 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
    private String firstStage(String new_id) {
        return new_id.toLowerCase();
    }

    // 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
    private String secondStage(String new_id) {
        int deleteCount = 0;
        StringBuffer buffer = new StringBuffer(new_id);

        for (int i = 0; i < new_id.length(); i++) {
            int value = new_id.charAt(i);
            if (!((value >= 97 && value <= 122) || (value >= 48 && value <= 57) || (value == 45 || value == 95 || value == 46))) {
                buffer = buffer.deleteCharAt(i - deleteCount);
                deleteCount++;
            }
        }
        return buffer.toString();
    }

    // 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
    private String thirdStage(String new_id) {
        int deleteCount = 0;
        StringBuffer buffer = new StringBuffer(new_id);

        for (int i = 0; i < new_id.length(); i++) {
            if (i != new_id.length()-1) {
                int value = new_id.charAt(i);
                int nextValue = new_id.charAt(i+1);

                if (value == 46 && nextValue == 46) {
                    buffer = buffer.deleteCharAt(i - deleteCount);
                    deleteCount++;
                }
            }
        }
        return buffer.toString();
    }

    // 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
    private String fourthStage(String new_id) {
        int deleteCount = 0;
        StringBuffer buffer = new StringBuffer(new_id);

        if (new_id.charAt(0) == 46) {
            buffer.deleteCharAt(0);
            deleteCount++;
        }
        if (new_id.charAt(new_id.length()-1) == 46) {
            if (buffer.length() != 0) buffer.deleteCharAt(new_id.length()-1-deleteCount);
        }
        return buffer.toString();
    }

    // 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
    private String fifthStage(String new_id) {
        if (new_id.length() == 0) new_id = "a";
        return new_id;
    }

    // 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
    // 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
    private String sixthStage(String new_id) {
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
        }
        return fourthStage(new_id);
    }

    // 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
    private String seventhStage(String new_id) {
        if (new_id.length() <= 2) {
            while (new_id.length() != 3) {
                new_id += new_id.charAt(new_id.length()-1);
            }
        }
        return new_id;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        solution1.solution("...!@BaT#*..y.abcdefghijklm");
    }
}