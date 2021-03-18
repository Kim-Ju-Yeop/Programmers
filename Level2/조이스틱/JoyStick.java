package 프로그래머스.코딩테스트_연습.레벨2.조이스틱;

import java.lang.Math;

public class JoyStick {

    int cursor = 0;
    int dataCount = 0;
    int answer = 0;

    public int solution(String name) {
        int[] nameArr = new int[name.length()];
        boolean[] stateArr = new boolean[name.length()];

        for (int i = 0; i < nameArr.length; i++) {
            if (name.charAt(i) != 65) dataCount++;
            nameArr[i] = name.charAt(i);
            stateArr[i] = false;
        }

        int finishCount = 0;
        while(dataCount != finishCount) {
            if (!isSame(nameArr)) {
                compareUpAndDown(nameArr);
                finishCount++;
            }
            stateArr[cursor] = true;
            if (dataCount != finishCount) compareFrontAndEnd(nameArr, stateArr);
        }
        return answer;
    }

    private boolean isSame(int[] nameArr) {
        return nameArr[cursor] == 65;
    }

    private void compareUpAndDown(int[] nameArr) {
        answer += Math.min((nameArr[cursor]-65), (91-nameArr[cursor]));
    }

    private void compareFrontAndEnd(int[] nameArr, boolean[] stateArr) {
        int fCount = 0;
        int frontIdx = cursor;
        while(true) {
            if (nameArr[frontIdx] != 65 && !stateArr[frontIdx]) break;

            if (frontIdx == nameArr.length-1) frontIdx = 0;
            else frontIdx++;
            fCount++;
        }

        int eCount = 0;
        int endIdx = cursor;
        while(true) {
            if (nameArr[endIdx] != 65 && !stateArr[endIdx]) break;

            if (endIdx == 0) endIdx = nameArr.length-1;
            else endIdx--;
            eCount++;
        }

        if (eCount < fCount) {
            cursor = endIdx;
            answer += eCount;
        } else {
            cursor = frontIdx;
            answer += fCount;
        }
    }

    public static void main(String[] args) {
        JoyStick joyStick = new JoyStick();
        joyStick.solution("JAN");
    }
}