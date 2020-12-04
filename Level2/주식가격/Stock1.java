package programmers.question3;

public class Stock1 {

    public int[] solution(int[] prices) {
        int[] result = new int[prices.length];

        for (int i = 0; i < prices.length-1; i++) {
            int seconds = 0;

            for (int j = i+1; j < prices.length; j++) {
                seconds++;
                if (prices[i] > prices[j]) {
                    break;
                }
            }
            result[i] = seconds;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] prices = { 1, 2, 3, 2, 3 };

        Stock1 stock1 = new Stock1();
        stock1.solution(prices);
    }
}
