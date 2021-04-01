package 프로그래머스.코딩테스트_연습.레벨2.단체사진_찍기;

public class GroupPhoto2 {

    private String[] arr = { "A", "C", "F", "J", "M", "N", "R", "T" };
    private String[] result = new String[8];
    private boolean[] used = new boolean[8];
    private int answer = 0;

    private int solution(int n, String[] data) {
        permutation(0, data);
        return answer;
    }

    private void permutation(int cnt, String[] data) {
        if (cnt == 8) {
            String s = "";
            for (int i = 0; i < arr.length; i++) s += result[i];

            for (int i = 0; i < data.length; i++) {
                int start = s.indexOf(data[i].charAt(0));
                int end = s.indexOf(data[i].charAt(2));

                if (data[i].charAt(3) == '=' && Math.abs(start-end)-1 != data[i].charAt(4) - '0') return;
                if (data[i].charAt(3) == '<' && Math.abs(start-end)-1 >= data[i].charAt(4) - '0') return;
                if (data[i].charAt(3) == '>' && Math.abs(start-end)-1 <= data[i].charAt(4) - '0') return;
            }
            answer++;
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!used[i]) {
                used[i] = true;
                result[cnt] = arr[i];
                permutation(cnt+1, data);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int n = 2;
        String[] data = { "N~F=0", "R~T>2" };

        GroupPhoto2 groupPhoto2 = new GroupPhoto2();
        groupPhoto2.solution(n, data);
    }
}