package 프로그래머스.코딩테스트_연습.레벨2.N개의_최소공배수;

public class Lcm2 {

    public long solution(int[] num) {
        long answer = num[0];
        long g;

        for(int i = 1; i < num.length; i++){
            g = gcd(answer, num[i]);
            answer = g * (answer / g) * (num[i] / g);
        }
        return answer;
    }

    public long gcd(long a,long b){
        if(a > b)
            return (a % b == 0) ? b : gcd(b,a % b);
        else
            return (b % a == 0)? a : gcd(a,b % a);
    }

    public static void main(String[] args) {
        int[] arr = {2, 6, 8, 14};

        Lcm2 lcm2 = new Lcm2();
        lcm2.solution(arr);
    }
}