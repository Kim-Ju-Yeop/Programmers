package example29;

public class Solution2 {

    int tempL = 10;
    int tempR = 12;
    String myhand;

    public String solution(int[] numbers, String hand) {
        myhand = ((hand.equals("right")) ? "R" : "L");
        String answer = "";

        for (int i = 0; i < numbers.length; i++) {
            switch (numbers[i]) {
                case 1: case 4: case 7: {
                    answer += "L";
                    tempL = numbers[i];
                    break;
                }
                case 3: case 6: case 9: {
                    answer += "R";
                    tempR = numbers[i];
                    break;
                }
                default: {
                    String tempHand = checkHand(numbers[i]);

                    if (tempHand.equals("L")) tempL = numbers[i] + ((numbers[i] == 0)? 11:0);
                    else tempR = numbers[i] + ((numbers[i] == 0)? 11:0);

                    answer += tempHand;
                    break;
                }
            }
        }
        return answer;
    }

    public String checkHand(int tempNum) {
        int leftDistance = 0;
        int rightDistance = 0;

        if (tempNum == 0) tempNum = 11;

        leftDistance = Math.abs(((tempNum-1) / 3) - ((tempL-1) / 3) + Math.abs(((tempNum-1) % 3) - ((tempR-1) % 3)));
        rightDistance = Math.abs(((tempNum-1) / 3) - ((tempR-1) / 3) + Math.abs(((tempNum-1) % 3) - ((tempR-1) % 3)));

        return ((leftDistance == rightDistance) ? myhand : (rightDistance > leftDistance) ? "L" : "R");
    }

    public static void main(String[] args) {
        int[] numbers = { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };
        int[] numbers2 = { 7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2 };
        int[] numbers3 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };

        String leftHand = "left";
        String rightHand = "right";

        Solution2 solution2 = new Solution2();
        solution2.solution(numbers3, rightHand);
    }
}
