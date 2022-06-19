package programmers.level2;

public class P49993 {
    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (int i = 0; i < skill_trees.length; i++) {
            if(checkSkill(skill,skill_trees[i])){
                answer++;
            }
        }
        return answer;
    }
    public static boolean checkSkill(String skill,String skillTree){
        StringBuilder sb = new StringBuilder();

        //skillTree에서 선행스킬(skill)순서에 포함되는 문자들만 뽑아낸다.
        for (int i = 0; i < skillTree.length(); i++) {
            for (char x:skill.toCharArray()) {
                if(skillTree.charAt(i) == x){
                    sb.append(x);
                }
            }
        }
        boolean check = false;
        String userSkill = sb.toString();
        //skillTree에 선행스킬이 없으면 true를 리턴한다.
        if(userSkill.equals("")) return true;

        //skillTree가 선행스킬순서를 지켰는지 체크한다.
        for (int i = 0; i < userSkill.length(); i++) {
            if(userSkill.charAt(i) == skill.charAt(i)){
                check = true;
            }else{
                //스킬순서가 틀리면 바로 false리턴한다.
                return false;
            }
        }
        return check;
    }
    public static void main(String[] args) {
        System.out.println(solution("CBD",new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
        System.out.println(solution("CBD",new String[]{"CBD", "ASZ", "CD", "DCA"}));
    }
}
