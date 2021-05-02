package 프로그래머스.코딩테스트_연습.레벨2.이진_변환_반복하기;

public class Transform {

    public int[] solution(String s) {
        int transformCnt = 0;
        int deleteZeroCnt = 0;

        while (!s.equals("1")) {
            int oneCount = 0;
            for (char cS : s.toCharArray()) {
                if (cS != '0') oneCount++;
                else deleteZeroCnt++;
            }

            s = Integer.toBinaryString(oneCount);
            transformCnt++;
        }
        return new int[]{transformCnt, deleteZeroCnt};
    }

    public static void main(String[] args) {
        Transform transform = new Transform();
        transform.solution("110010101001");
    }
}