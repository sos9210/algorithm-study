package programmers;


import java.time.DayOfWeek;
import java.time.LocalDate;

public class P12901 {
    public static String solution(int a, int b) {
        LocalDate date = LocalDate.of(2016, a, b);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        String answer = dayOfWeek.toString().substring(0,3);
        return answer;
        /*
        //이 코드가 더 나아보인다.
      String answer = "";
        String[] day = { "FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU" };
        int[] date = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int allDate = 0;
        for (int i = 0; i < a - 1; i++) {
            allDate += date[i];
        }
        allDate += (b - 1);
        answer = day[allDate % 7];

        return answer;
         */
    }
    public static void main(String[] args) {
        System.out.println(solution(5,20));
    }
}
