package 프로그래머스.코딩테스트_연습.레벨2.방금그곡;

public class Song2 {

    public String solution(String m, String[] musicInfos) {
        String answer = "(None)";
        int time = 0;

        m = edit(m);

        for (int inx = 0; inx < musicInfos.length; inx++) {
            String[] info = musicInfos[inx].split(",");

            int start = (60 * Integer.parseInt(info[0].substring(0, 2)) + Integer.parseInt(info[0].substring(3)));
            int end = (60 * Integer.parseInt(info[1].substring(0, 2)) + Integer.parseInt(info[1].substring(3)));
            int t = end - start;

            if (t > time) {
                info[3] = edit(info[3]);
                StringBuffer sb = new StringBuffer();
                for (int jnx = 0; jnx < t; jnx++) {
                    sb.append(info[3].charAt(jnx % (info[3].length())));
                }
                if (sb.toString().contains(m)) {
                    answer = info[2];
                    time = t;
                }
            }
        }
        return answer;
    }

    private String edit(String m) {
        m = m.replaceAll("C#", "V");
        m = m.replaceAll("D#", "W");
        m = m.replaceAll("F#", "X");
        m = m.replaceAll("G#", "Y");
        m = m.replaceAll("A#", "Z");

        return m;
    }

    public static void main(String[] args) {
        String m = "CC#BCC#BCC#BCC#B";
        String[] musicInfos = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};

        Song2 song2 = new Song2();
        song2.solution(m, musicInfos);
    }
}