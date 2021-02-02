package 프로그래머스.코딩테스트_연습.레벨2.메뉴_리뉴얼;

import java.util.ArrayList;

public class Combination {

    private int arrSize;
    private int pickNumber;
    private int[] arr;
    private ArrayList<ArrayList<Integer>> result;

    public ArrayList<ArrayList<Integer>> getResult() {
        return result;
    }

    public Combination(int arrSize, int pickNumber) {
        this.arrSize = arrSize;
        this.pickNumber = pickNumber;
        this.arr = new int[pickNumber];
        this.result = new ArrayList<>();
    }

    private void combination(int[] now, int depth, int index, int target) {
        if (depth == pickNumber) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < this.arr.length; i++) {
                temp.add(now[this.arr[i]]);
            }
            result.add(temp);
            return;
        }
        if (target == arrSize) return;
        this.arr[index] = target;
        combination(now, depth+1, index+1, target+1);
        combination(now, depth, index, target+1);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int r = 4;

        Combination combination = new Combination(arr.length, r);
        combination.combination(arr, 0, 0, 0);

        ArrayList<ArrayList<Integer>> result = combination.getResult();
        System.out.println("모든 조합의 수 : " + result.size());
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}