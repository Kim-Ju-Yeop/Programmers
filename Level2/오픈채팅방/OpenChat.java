package 프로그래머스.코딩테스트_연습.레벨2.오픈채팅방;

import java.util.HashMap;

public class OpenChat {

    enum State {
        ENTER,
        LEAVE,
        CHANGE
    }

    int changeCount = 0;

    public String[] solution(String[] record) {
        HashMap<String, String> map = new HashMap<>();
        analyzeUser(record, map);

        String[] result = new String[record.length - changeCount];
        checkRecord(record, map, result);

        return result;
    }

    private void analyzeUser(String[] record, HashMap<String, String> map) {
        for (String r : record) {
            String[] temp = r.split(" ");
            State state = temp[0].equals("Enter") ? State.ENTER : temp[0].equals("Leave") ? State.LEAVE : State.CHANGE;

            if (state == State.CHANGE) changeCount++;
            if (state != State.LEAVE) map.put(temp[1], temp[2]);
        }
    }

    private void checkRecord(String[] record, HashMap<String, String> map, String[] result) {
        int idx = 0;
        for (String r : record) {
            String[] temp = r.split(" ");
            State state = temp[0].equals("Enter") ? State.ENTER : temp[0].equals("Leave") ? State.LEAVE : State.CHANGE;

            if (state == State.ENTER) result[idx++] = enterMessage(map.get(temp[1]));
            else if (state == State.LEAVE) result[idx++] = leaveMessage(map.get(temp[1]));
        }
    }

    private String enterMessage(String nickName) {
        return nickName + "님이 들어왔습니다.";
    }

    private String leaveMessage(String nickName) {
        return nickName + "님이 나갔습니다.";
    }

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi","Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        OpenChat openChat = new OpenChat();
        openChat.solution(record);
    }
}
