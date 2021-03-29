package 프로그래머스.코딩테스트_연습.레벨2.순위_검색;

public class RankSearch2 {

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        for (int i = 0; i < query.length; i++) {
            String[] splitQuery = query[i].split(" and ");
            String[] currentQuery = new String[5];
            currentQuery[0] = splitQuery[0];
            currentQuery[1] = splitQuery[1];
            currentQuery[2] = splitQuery[2];
            currentQuery[3] = splitQuery[3].split(" ")[0];
            currentQuery[4] = splitQuery[3].split(" ")[1];

            int count = 0;
            for (int j = 0; j < info.length; j++) {
                String[] currentInfo = info[j].split(" ");

                boolean isSuccess = true;
                for (int k = 0; k < currentInfo.length; k++) {
                    if (!(currentQuery[k].equals("-") || currentQuery[k].equals(currentInfo[k]) || (k == 4 && (Integer.parseInt(currentQuery[k]) <= Integer.parseInt(currentInfo[k]))))) {
                        isSuccess = false;
                        break;
                    }
                }
                if (isSuccess) count++;
            }
            answer[i] = count;
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] info = { "java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50" };
        String[] query = { "java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150" };

        RankSearch2 rankSearch2 = new RankSearch2();
        rankSearch2.solution(info, query);
    }
}