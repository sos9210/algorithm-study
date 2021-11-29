package sec01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sec01_06 {
    public static String solution(String str){
        String answer = "";

        for (int i = 0; i < str.length(); i++) {
            if(str.indexOf(str.charAt(i)) == i){
                answer += str.charAt(i);
            }
        }

        return answer;
    }
}
