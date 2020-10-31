package example4;

import java.util.ArrayList;
import java.util.Collections;

public class Solution1 {

    ArrayList<Integer> member = new ArrayList<>();

    public int solution(int n, int[] lost, int[] reserve) {
        setMember(n);
        removeLostMember(lost);
        addReserve(n, lost, reserve);

        return member.size();
    }

    public void setMember(int n) {
        for (int i = 1; i <= n; i++) {
            member.add(i);
        }
    }

    public void removeLostMember(int[] lost) {
        for (int lostValue : lost) {
            member.removeAll(Collections.singleton(lostValue));
        }
    }

    public void addReserve(int n, int[] lost, int[] reserve) {
        for (int reserveValue : reserve) {
            for (int lostValue : lost) {
                if (lostValue == reserveValue) {
                    member.add(reserveValue);
                }
            }
        }

        for (int reserveValue : reserve) {
            boolean overlapCheck = false;

            for (int lostValue : lost) {
                if (lostValue == reserveValue) {
                    overlapCheck = true;
                }
            }
            if (overlapCheck) continue;

            int backValue = reserveValue - 1;
            int forwardValue = reserveValue + 1;

            if (backValue != 0 && !member.containsAll(Collections.singleton(backValue))) {
                member.add(backValue);
                continue;
            }

            if (forwardValue <= n && !member.containsAll(Collections.singleton(forwardValue))) {
                member.add(forwardValue);
            }
        }
    }

    public static void main(String[] args) {
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};

        Solution1 solution1 = new Solution1();
        int max = solution1.solution(5, lost, reserve);

        System.out.println(max);
    }
}
