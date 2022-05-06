package study;

public class P72410 {
    public static String solution (String new_id) {
        String answer = "";
        new_id = new_id.toLowerCase();  //1단계
        StringBuilder sb= new StringBuilder();
        for (char id:new_id.toCharArray()) {    //2단계
            if(Character.isAlphabetic(id)|| Character.isDigit(id) || id == '-' || id == '_' || id == '.'){
                sb.append(id);
            }
        }
        new_id = sb.toString().replaceAll("\\.{2,}", ".");    //3단계
        new_id = new_id.startsWith(".") ? new_id.substring(1,new_id.length()) : new_id; //4단계
        new_id = new_id.endsWith(".") ? new_id.substring(0,new_id.length()-1) : new_id;  //4단계
        new_id = "".equals(new_id) ? "a" : new_id;        //5단계
        if(new_id.length() > 15){       //6단계
            new_id = new_id.substring(0,15);
            new_id = new_id.endsWith(".") ? new_id.substring(0,new_id.length()-1) : new_id;
        }

        if(new_id.length() <= 2){   //7단계
            while(new_id.length() < 3){
                new_id += new_id.substring(new_id.length()-1, new_id.length());
            }
        }
        answer = new_id;
        return answer;
    }
    public static void main(String[] args) {
   //    String result = solution("...!@BaT#*..y.abcdefghijklm");
   //     String result = solution("z-+.^.");
 //       String result = solution("123_.def");
        String result = solution("abcdefghijklmn.p");
        System.out.println(result);
    }
}
