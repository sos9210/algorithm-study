package programmers.level2;

import java.util.Arrays;

public class P42746 {
    public static String solution(int[] numbers) {
        String[] strings = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            strings[i] = String.valueOf(numbers[i]);
        }

        //두 수를 번갈아가며 합친 수 중 큰 값을 앞으로 정렬(내림차순 정렬)
        Arrays.sort(strings, (o1, o2) -> (o2+o1).compareTo(o1+o2));
        if(strings[0].equals("0")) return "0";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            sb.append(strings[i]);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        //System.out.println(solution(new int[]{6, 10, 2}));
        System.out.println(solution(new int[]{3, 30, 34, 5, 9}));
    }
}
