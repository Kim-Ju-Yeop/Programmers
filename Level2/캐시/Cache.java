package 프로그래머스.코딩테스트_연습.레벨2.캐시;

import java.util.LinkedList;
import java.util.Queue;

public class Cache {

    private final int CACHE_HIT = 5;
    private final int CACHE_MISS = 1;

    private Queue<String> queue;
    private int size;
    private String[] data;
    private int answer;

    public int solution(int cacheSize, String[] cities) {
        queue = new LinkedList<>();
        size = cacheSize;
        data = cities;
        answer = 0;

        if (cacheSize == 0) answer = CACHE_HIT * cities.length;
        else {
            changeToLowerCase();
            analyzeData();
        }

        return answer;
    }

    private void changeToLowerCase() {
        for (int i = 0; i < data.length; i++)
            data[i] = data[i].toLowerCase();
    }

    private void analyzeData() {
        for (int i = 0; i < data.length; i++) {
            if (queue.contains(data[i])) {
                queue.remove(data[i]);
                queue.add(data[i]);
                answer += CACHE_MISS;
            } else {
                if (queue.size() == size) queue.remove();
                queue.add(data[i]);
                answer += CACHE_HIT;
            }
        }
    }

    public static void main(String[] args) {
        int cacheSize = 5;
        String[] cities = {"Seoul", "Seoul", "Seoul"};

        Cache cache = new Cache();
        cache.solution(cacheSize, cities);
    }
}
