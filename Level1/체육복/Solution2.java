package example4;

public class Solution2 {

    public int solution(int n, int[] lost, int[] reserve) {
        int[] people = new int[n];
        int answer = n;

        for (int l : lost) {
            people[l - 1]--;
        }

        for (int r : reserve) {
            people[r - 1]++;
        }

        for (int i = 0; i < people.length; i++) {
            if (people[i] == -1) {
                if (i - 1 >= 0 && people[i -1] == 1) {
                    people[i]++;
                    people[i-1]--;
                } else if (i + 1 < people.length && people[i + 1] == 1) {
                    people[i]++;
                    people[i+1]--;
                } else {
                    answer--;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};

        Solution2 solution2 = new Solution2();
        int max = solution2.solution(5, lost, reserve);

        System.out.println(max);
    }
}
