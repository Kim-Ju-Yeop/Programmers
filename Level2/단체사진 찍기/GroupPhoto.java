package 프로그래머스.코딩테스트_연습.레벨2.단체사진_찍기;

import java.util.LinkedList;

public class GroupPhoto {

    int answer = 0;

    public int solution(int n, String[] data) {
        String[] friends = { "A", "C", "F", "J", "M", "N", "R", "T" };
        boolean[] visited = new boolean[friends.length];

        permutation(friends.length, friends.length, visited, friends, data, new LinkedList<>());
        return answer;
    }

    private void permutation(int n, int r, boolean[] visited, String[] friends, String[] data, LinkedList<String> list) {
        if (list.size() == r) {
            if (checkConditions(data, list)) answer++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(friends[i]);
                permutation(n, r, visited, friends, data, list);

                list.removeLast();
                visited[i] = false;
            }
        }
    }

    private boolean checkConditions(String[] data, LinkedList<String> list) {
        for (String d : data) {
            String firstFriend = String.valueOf(d.charAt(0));
            String secondFriend = String.valueOf(d.charAt(2));
            String symbol = String.valueOf(d.charAt(3));
            int num = Integer.parseInt(String.valueOf(d.charAt(4)));

            int firstIndex = list.indexOf(firstFriend);
            int secondIndex = list.indexOf(secondFriend);
            int betweenFriendsCount = (Math.abs(firstIndex-secondIndex)-1);

            boolean isSuccess = true;
            switch(symbol) {
                case "=": if (betweenFriendsCount != num) isSuccess = false; break;
                case "<": if (!(betweenFriendsCount < num)) isSuccess = false; break;
                case ">": if (!(betweenFriendsCount > num)) isSuccess = false; break;
            }
            if (!isSuccess) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 2;
        String[] data = { "N~F=0", "R~T>2" };

        GroupPhoto groupPhoto = new GroupPhoto();
        groupPhoto.solution(n, data);
    }
}