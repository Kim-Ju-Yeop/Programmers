package 프로그래머스.코딩테스트_연습.레벨2.캐시;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cache2 {

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LRU<String, String> clsTemp = LRU.newInstance(cacheSize);

        for (int i = 0; i < cities.length; i++) {
            String sTemp = cities[i].toUpperCase();

            if (clsTemp.containsKey(sTemp)) answer++;
            else answer += 5;

            clsTemp.put(sTemp, sTemp);
        }

        return answer;
    }

    public static void main(String[] args) {
        int cacheSize = 5;
        String[] cities = {"Seoul", "Seoul", "Seoul"};

        Cache2 cache = new Cache2();
        cache.solution(cacheSize, cities);
    }
}

class LRU<K, V> extends LinkedHashMap<K, V> {
    private int size;

    private LRU(int size) {
        super(size, 0.75f, true);
        this.size = size;
    }

    protected boolean removeEldesEntry(Map.Entry<K, V> eldest) {
        return size() > size;
    }

    public static <K,V> LRU<K,V> newInstance(int size) {
        return new LRU<>(size);
    }
}