package programmers.question2;

import java.util.LinkedList;
import java.util.Queue;

public class Truck2 {

    class Truck {
        int weight;
        int move;

        public Truck(int weight) {
            this.weight = weight;
            this.move = 1;
        }

        public void moving() {
            move++;
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> waitQ = new LinkedList<>();
        Queue<Truck> moveQ = new LinkedList<>();

        for (int t : truck_weights) {
            waitQ.offer(new Truck(t));
        }

        int answer = 0;
        int curWeight = 0;

        while (!waitQ.isEmpty() || !moveQ.isEmpty()) {
            answer++;

            if (moveQ.isEmpty()) {
                Truck truck = waitQ.poll();
                curWeight = truck.weight;
                moveQ.offer(truck);
                continue;
            }

            for (Truck truck : moveQ) {
                truck.moving();
            }

            if (moveQ.peek().move > bridge_length) {
                Truck truck = moveQ.poll();
                curWeight -= truck.weight;
            }

            if (!waitQ.isEmpty() && curWeight + waitQ.peek().weight <= weight) {
                Truck truck = waitQ.poll();
                curWeight += truck.weight;
                moveQ.offer(truck);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = { 7, 4, 5, 6 };

        Truck2 truck2 = new Truck2();
        System.out.println(truck2.solution(bridge_length, weight, truck_weights));
    }
}
