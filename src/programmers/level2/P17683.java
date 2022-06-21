package programmers.level2;


//방금그곡
public class P17683 {
    public static String solution(String m, String[] musicinfos) {
        String answer = "";
        int maxTime = Integer.MIN_VALUE;

        for (int i = 0; i < musicinfos.length; i++) {
            String[] split = musicinfos[i].split(",");
            String startTime = split[0];
            String endTime = split[1];

            //음악 시작시간과 끝나는시간의 차이의 분을 구한다.
            int timeDiff =
                    (Integer.parseInt(endTime.split(":")[0]) * 3600 + Integer.parseInt(endTime.split(":")[1]) * 60) / 60
                            -
                    (Integer.parseInt(startTime.split(":")[0]) * 3600 + Integer.parseInt(startTime.split(":")[1]) * 60) / 60;

            StringBuilder sb = new StringBuilder();
            String melody = changeMelody(split[3]);  //네오가 기억하고있는 멜로디
            m = changeMelody(m);                    //#이들어가는 멜로디를 다른 알파벳으로 치환한다.

            if (timeDiff > melody.length()) {       //멜로디의 길이보다 음악 시작시간과 끝나는 시간 차이가 더 크면 멜로디를 이어서 붙여준다.
                sb.append(melody);
                for (int j = 0; j < timeDiff; j++) {
                    int jj = j % melody.length();
                    sb.append(melody.charAt(jj));
                }
            }else{  //시간 차이보다 멜로디의 길이가 더 클수도있다.
                sb.append(melody.substring(0,timeDiff));
            }
            String totalMusic = sb.toString();
            //이어붙인음악이 멜로디와 같은 문장이있고 기존에 찾았던 음악시간보다 길면
            if(totalMusic.contains(m) && maxTime < timeDiff){
                maxTime = timeDiff;
                answer = split[2];
            }

        }
        //음악을 찾지 못하면 (none)
        return answer.equals("") ? "(None)" : answer;
    }
    public static String changeMelody(String oldMelody) {
        oldMelody = oldMelody.replaceAll("C#", "H");
        oldMelody = oldMelody.replaceAll("D#", "I");
        oldMelody = oldMelody.replaceAll("F#", "J");
        oldMelody = oldMelody.replaceAll("G#", "K");
        oldMelody = oldMelody.replaceAll("A#", "L");

        return oldMelody;
    }
    public static void main(String[] args) {
        System.out.println(solution("ABCDEFG",new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}));  //HELLO
        System.out.println(solution("CDCDF",new String[]{"12:00,12:14,HELLO,CDCDCDF", "13:00,13:05,WORLD,CDCDCDF"}));   //HELLO
        System.out.println(solution("CCB",new String[]{"03:00,03:10,FOO,CCB#CCB", "04:00,04:08,BAR,ABC"}));             //FOO
        System.out.println(solution("CC#BCC#BCC#",new String[]{"03:00,03:58,FOO,CC#B","02:50,03:08,FOSO,CC#B"}));       //FOO
        System.out.println(solution("ABC",new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}));     //
    }
}
