package example39;

public class Solution1 {

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] formatArr1 = formatBinaryString(n, arr1);
        String[] formatArr2 = formatBinaryString(n, arr2);

        String[] mixArr = mixData(n, formatArr1, formatArr2);
        return mixArr;
    }

    // int 정수형 배열을 -> 2진수 문자열 배열로 변환
    public String[] formatBinaryString(int n, int[] arr) {
        String[] formatArr = new String[n];

        for (int i = 0; i < n; i++) {
            formatArr[i] = String.format("%0"+n+"d", Long.parseLong(Integer.toBinaryString(arr[i])));
        }
        return formatArr;
    }

    // 두 개의 2진수 문자열 배열을 조합
    public String[] mixData(int n, String[] formatArr1, String[] formatArr2) {
        String[] mixArr = new String[n];

        for (int i = 0; i < n; i++) {
            mixArr[i] = "";
            for (int j = 0; j < n; j++) {
                if (formatArr1[i].charAt(j) != formatArr2[i].charAt(j)) {
                    mixArr[i] += "#";
                } else if (formatArr1[i].charAt(j) == formatArr2[i].charAt(j)) {
                    if (formatArr1[i].charAt(j) == '0') mixArr[i] += " ";
                    else if (formatArr1[i].charAt(j) == '1') mixArr[i] += "#";
                }
            }
        }
        return mixArr;
    }

    public static void main(String[] args) {
        int[] arr1 = { 9, 20, 28, 18, 11 };
        int[] arr2 = { 30, 1, 21, 17, 28 };

        Solution1 solution1 = new Solution1();
        solution1.solution(5, arr1, arr2);
    }
}
