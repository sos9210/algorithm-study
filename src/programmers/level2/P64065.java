package programmers.level2;

import java.util.*;

public class P64065 {
    public static int[] solution(String s) {
        /*
        s = s.replaceAll("\\{\\{","{").replaceAll("}}","}");
        List<List<Integer>> allList = new ArrayList<>();
        List<Integer> addList = new ArrayList<>();
        String numbers = "";
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == ',') continue;
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                numbers += s.charAt(i);
                if(!(s.charAt(i+1) >= '0' && s.charAt(i+1) <= '9')){
                    addList.add(Integer.parseInt(numbers));
                    numbers="";
                }
            }
            if(s.charAt(i) == '}'){
                allList.add(addList);
                addList = new ArrayList<>();
                numbers = "";
            }
        }
        allList.sort((o1,o2) -> o1.size() - o2.size());
        List<Integer> result = new ArrayList<>();
        for (List<Integer> list :allList) {
            for (int i :list) {
                if(!result.contains(i))
                result.add(i);
            }
        }
        Integer[] integers = result.toArray(new Integer[0]);
        int[] answer = new int[integers.length];
        for (int i = 0; i < integers.length; i++) {
            answer[i] = integers[i];
        }
        return answer;
        */

        //이 방법이 더 짧고 성능상 좋다..
        Set<String> set = new HashSet<>();
        String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
        Arrays.sort(arr, (a, b)->{return a.length() - b.length();});
        int[] answer = new int[arr.length];
        int idx = 0;
        for(String s1 : arr) {
            for(String s2 : s1.split(",")) {
                if(set.add(s2)) answer[idx++] = Integer.parseInt(s2);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        //Arrays.stream(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")).forEach(v -> System.out.print(v+" "));
        Arrays.stream(solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")).forEach(v -> System.out.print(v+" "));
    }
}
