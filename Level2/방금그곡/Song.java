package 프로그래머스.코딩테스트_연습.레벨2.방금그곡;

import java.util.ArrayList;

public class Song {

    class MusicInfo {
        String startTime;
        String endTime;
        String title;
        String sheet;

        public MusicInfo(String startTime, String endTime, String title, String sheet) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.title = title;
            this.sheet = sheet;
        }
    }

    private ArrayList<MusicInfo> musicInfoList;
    private String targetMelody;
    private String answer;

    public String solution(String m, String[] musicInfos) {
        musicInfoList = new ArrayList<>();
        targetMelody = m;

        setMusicInfoList(musicInfos);
        analyzeMusicInfoList();

        return answer;
    }

    private void setMusicInfoList(String[] musicInfos) {
        for (String musicInfo : musicInfos) {
            String[] music = musicInfo.split(",");
            MusicInfo mi = new MusicInfo(music[0], music[1], music[2], music[3]);
            musicInfoList.add(mi);
        }
    }

    private void analyzeMusicInfoList() {
        int maxDuration = 0;

        for (MusicInfo musicInfo : musicInfoList) {
            String[] startTime = musicInfo.startTime.split(":");
            String[] endTime = musicInfo.endTime.split(":");
            String title = musicInfo.title;
            String sheet = musicInfo.sheet;

            int sTime = (Integer.parseInt(startTime[0]) * 60) + Integer.parseInt(startTime[1]);
            int eTime = (Integer.parseInt(endTime[0]) * 60) + Integer.parseInt(endTime[1]);
            int duration = eTime - sTime;

            ArrayList<String> melodyList = strToArrayList(sheet, duration);

            int startIdx = 0;
            int endIdx = melodyList.size();
            for (int i = melodyList.size(); i < duration; i++) {
                if (startIdx == endIdx) startIdx = 0;

                melodyList.add(melodyList.get(startIdx));
                startIdx++;
            }

            ArrayList<String> targetMelodyList = strToArrayList(targetMelody, duration);

            boolean isSuccess = true;
            while (isSuccess) {
                if (targetMelodyList.size() == 0) isSuccess = false;
                else if (!melodyList.contains(targetMelodyList.get(0))) isSuccess = false;
                else {
                    int fIdx = melodyList.indexOf(targetMelodyList.get(0));

                    String temp = "";
                    for (int i = fIdx; i < fIdx + targetMelodyList.size(); i++) {
                        if (i == melodyList.size()) break;
                        temp += melodyList.get(i);
                    }

                    if (!temp.equals(targetMelody)) melodyList.remove(fIdx);
                    else break;
                }
            }

            if (isSuccess && duration > maxDuration) {
                maxDuration = duration;
                answer = title;
            }
        }

        if (maxDuration == 0) answer = "(None)";
    }

    private ArrayList<String> strToArrayList(String str, int duration) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (arrayList.size() == duration) break;

            if (i == str.length()-1 && str.charAt(i) != '#') arrayList.add(String.valueOf(str.charAt(i)));
            else if (str.charAt(i+1) != '#') arrayList.add(String.valueOf(str.charAt(i)));
            else {
                String temp = String.valueOf(str.charAt(i)) + String.valueOf(str.charAt(i+1));
                arrayList.add(temp);
                i++;
            }
        }
        return arrayList;
    }

    public static void main(String[] args) {
        String m = "CC#BCC#BCC#BCC#B";
        String[] musicInfos = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};

        Song song = new Song();
        song.solution(m, musicInfos);
    }
}