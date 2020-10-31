package example6;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Solution1 {
    public String solution(int a, int b) throws Exception {
        String inputDate;

        if (a < 10) inputDate = "2016" + "0" + a + b;
        else inputDate = "2016" + a + b;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = simpleDateFormat.parse(inputDate);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int week = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println(week);

        switch (week) {
            case 1: return "SUN";
            case 2: return "MON";
            case 3: return "TUE";
            case 4: return "WED";
            case 5: return "THU";
            case 6: return "FRI";
            case 7: return "SAT";
            default: return "NO";
        }
    }

    public static void main(String[] args) throws Exception{
        Solution1 solution1 = new Solution1();
        solution1.solution(10, 24);
    }
}
