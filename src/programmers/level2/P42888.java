package programmers.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P42888 {
    public static String[] solution(String[] record) {
        //키 : 아이디, 값 : 닉네임
        Map<String,String> userMap = new HashMap<>();
        //키 : 행동, 값 : 메세지
        Map<String,String> actionMap = new HashMap<>();
        actionMap.put("Enter", "님이 들어왔습니다.");
        actionMap.put("Leave", "님이 나갔습니다.");
        //보내야하는 메세지 갯수 count
        int count = 0;
        //user를 map에 담는다.
        for (int i = 0; i < record.length; i++) {
            String[] user = record[i].split(" ");

            if(!user[0].equals("Leave")) {
                userMap.put(user[1],user[2]);
            }
            count = user[0].equals("Change") ? count : count+1; //Change인 경우는 메세지를 카운트하지 않는다.
        }

        String[] answer = new String[count];
        int length = 0;
        for (int i = 0; i < record.length; i++) {
            String[] user = record[i].split(" ");
            if(!user[0].equals("Change")){
                answer[length] = userMap.get(user[1])+actionMap.get(user[0]);
                ++length;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Arrays.stream(
                solution(new String[]{"Enter uid1234 Muzi","Change uid1234 ASDF" ,"Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"})
        ).forEach(v -> System.out.print(v + " "));
    }
}
