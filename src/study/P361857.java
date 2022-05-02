package study;

import java.util.HashMap;
import java.util.Map;

public class P361857 {
    public static void main(String[] args) {
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion= {"josipa", "filipa", "marina", "nikola"};
        Map<String,Integer> participantMap = new HashMap<>();
        for (int i = 0; i < participant.length; i++) {
            participantMap.put(participant[i],participantMap.getOrDefault(participant[i],0)+1);
        }

        for (int i = 0; i < completion.length; i++) {
            participantMap.put(completion[i],participantMap.getOrDefault(completion[i],0)-1);
        }

        for (int i = 0; i < participant.length; i++) {
            if(participantMap.get(participant[i]) > 0) System.out.println(participant[i]);
        }
    }
}
