package example41;

public class Solution1 {

    int elementCount = 0;
    int[] answer = new int[3];

    StringBuilder firstElement = new StringBuilder();
    StringBuilder secondElement = new StringBuilder();
    StringBuilder thirdElement = new StringBuilder();

    public int solution(String dartResult) {
        seperateData(0, firstElement, dartResult);
        inquireData(firstElement);

        int total = 0;
        for (int i = 0; i < answer.length; i++) total += answer[i];

        return total;
    }

    public void seperateData(int idx, StringBuilder element, String dartResult) {
        int i = idx;
        for (; i < dartResult.length(); i++) {
            if (!Character.isDigit(dartResult.charAt(i))) {
                element.append(dartResult.charAt(i));
            } else {
                if (i == idx || (dartResult.charAt(i-1) + "" + dartResult.charAt(i)).equals("10")) element.append(dartResult.charAt(i));
                else if (elementCount == 0) {
                    elementCount++;
                    seperateData(i, secondElement, dartResult);
                    break;
                } else if (elementCount == 1) {
                    elementCount++;
                    seperateData(i, thirdElement, dartResult);
                    break;
                } else {
                    break;
                }
            }
        }
        elementCount = 0;
    }

    public void inquireData(StringBuilder element) {
        for (int i = 0; i < element.length(); i++) {
            if (i == 0 && (element.charAt(i) + "" + element.charAt(i+1)).equals("10")) {
                answer[elementCount] = 10;
                i += 1;
            }
            String data = String.valueOf(element.toString().charAt(i));
            getResult(data);
        }

        if (elementCount == 0) {
            elementCount++;
            inquireData(secondElement);
        } else if (elementCount == 1) {
            elementCount++;
            inquireData(thirdElement);
        }
    }

    public void getResult(String data) {
        switch (data) {
            case "S": {
                answer[elementCount] = Integer.parseInt(String.valueOf(Math.round(Math.pow(answer[elementCount], 1))));
                break;
            }
            case "D": {
                answer[elementCount] = Integer.parseInt(String.valueOf(Math.round(Math.pow(answer[elementCount], 2))));
                break;
            }
            case "T": {
                answer[elementCount] = Integer.parseInt(String.valueOf(Math.round(Math.pow(answer[elementCount], 3))));
                break;
            }
            case "*": {
                if (elementCount == 0) answer[elementCount] *= 2;
                else if (elementCount == 1) {
                    answer[elementCount-1] *= 2;
                    answer[elementCount] *= 2;
                } else if (elementCount == 2) {
                    answer[elementCount-1] *= 2;
                    answer[elementCount] *= 2;
                }
                break;
            }
            case "#": {
                answer[elementCount] *= -1;
                break;
            }
            default: {
                answer[elementCount] += Integer.parseInt(data);
            }
        }
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        solution1.solution("1D2S3T*");
    }
}
