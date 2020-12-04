package programmers.question2;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Truck {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0;
        Queue<Integer> q = new ConcurrentLinkedQueue<>();

        for (int t : truck_weights) {
            while (true) {
                if (q.isEmpty()) {
                    q.add(t);
                    sum += t;
                    answer++;
                    break;
                } else if (q.size() == bridge_length) {
                    sum -= q.poll();
                } else {
                    if (sum + t > weight) {
                        answer++;
                        q.add(0);
                    } else {
                        q.add(t);
                        sum += t;
                        answer++;
                        break;
                    }
                }
            }
        }
        return answer + bridge_length;
    }

    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = { 7, 4, 5, 6 };

        Truck truck = new Truck();
        truck.solution(bridge_length, weight, truck_weights);
    }
}
