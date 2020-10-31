package example29;

public class Solution1 {

    StringBuilder result = new StringBuilder();
    String[][] keypad = { {"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}, {"*", "0", "#"} };

    int[] currentLeft = { 3, 0 };
    int[] currentRight = { 3, 2 };

    public String solution(int[] numbers, String hand) {
        for (int number : numbers) {
            boolean isFind = false;
            for (int i = 0; i < keypad.length; i++) {
                for (int j = 0; j < keypad[i].length; j++) {
                    if (i == 3 && (j == 0 || j == 2)) continue;
                    if (number == Integer.parseInt(keypad[i][j])) {
                        judgeNumber(i, j, number, hand);
                        isFind = true;
                        break;
                    }
                }
                if (isFind) break;
            }
        }
        return result.toString();
    }

    public void judgeNumber(int rowIdx, int columnIdx, int number, String hand) {
        switch (number) {
            case 1:
            case 4:
            case 7: {
                selectLeft(rowIdx, columnIdx);
                break;
            }
            case 2:
            case 5:
            case 8:
            case 0: {
                int[] thisLeft = { currentLeft[0], currentLeft[1] };
                int[] thisRight = { currentRight[0], currentRight[1] };

                int moveLeftCount = 0;
                int moveRightCount = 0;

                // 왼손 (Row) && 왼손 (Column)
                while (thisLeft[0] != rowIdx) {
                    if (thisLeft[0] > rowIdx) thisLeft[0] -= 1;
                    else thisLeft[0] += 1;
                    moveLeftCount++;
                }
                while (thisLeft[1] != columnIdx) {
                    if (thisLeft[1] > columnIdx) thisLeft[1] -= 1;
                    else thisLeft[1] += 1;
                    moveLeftCount++;
                }

                // 오른손 (Row) && 오른손 (Column)
                while (thisRight[0] != rowIdx) {
                    if (thisRight[0] > rowIdx) thisRight[0] -= 1;
                    else thisRight[0] += 1;
                    moveRightCount++;
                }
                while (thisRight[1] != columnIdx) {
                    if (thisRight[1] > columnIdx) thisRight[1] -= 1;
                    else thisRight[1] += 1;
                    moveRightCount++;
                }

                if (moveLeftCount < moveRightCount) selectLeft(rowIdx, columnIdx);
                else if (moveRightCount < moveLeftCount) selectRight(rowIdx, columnIdx);
                else {
                    if (hand.equals("left")) selectLeft(rowIdx, columnIdx);
                    else selectRight(rowIdx, columnIdx);
                }
                break;
            }
            case 3:
            case 6:
            case 9: {
                selectRight(rowIdx, columnIdx);
                break;
            }
        }
    }

    public void selectLeft(int rowIdx, int columnIdx) {
        currentLeft[0] = rowIdx;
        currentLeft[1] = columnIdx;
        result.append("L");
    }
    public void selectRight(int rowIdx, int columnIdx) {
        currentRight[0] = rowIdx;
        currentRight[1] = columnIdx;
        result.append("R");
    }

    public static void main(String[] args) {
        int[] numbers = { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };
        int[] numbers2 = { 7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2 };
        int[] numbers3 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };

        String leftHand = "left";
        String rightHand = "right";

        Solution1 solution1 = new Solution1();
        solution1.solution(numbers3, rightHand);
    }
}