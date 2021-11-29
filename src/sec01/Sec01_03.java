package sec01;

public class Sec01_03 {
    public static String solution(String str){
    /* //내가 푼것
        String thisChar = "";
        String[] strList = str.split(" ");
        int size = 0;
        for(int i=0; strList.length > i; ++i){
            int thisSize = strList[i].toCharArray().length;
            if(thisSize > size){
                size = thisSize;
                thisChar = strList[i];
            }
        }

        return thisChar;
     */
     /*
        String answer = "";
        int m = Integer.MIN_VALUE;
        String[] s = str.split(" ");
        for (String x:s) {
            int len=x.length();
            if(len > m) {
                m = len;
                answer = x;
            }
        }
        return answer;

    */
        int m =Integer.MIN_VALUE,pos;
        String answer = "";
        while((pos=str.indexOf(" ")) != -1) {
            String tmp = str.substring(0,pos);
            int len = tmp.length();
            if(len > m){
                m = len;
                answer = tmp;
            }
            str = str.substring(pos+1);
        }
        if(str.length() > m){
            answer = str;
        }
        return answer;
    }
}
