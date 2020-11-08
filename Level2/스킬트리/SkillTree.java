package programmers;

import java.util.ArrayList;

public class SkillTree {

    public int solution(String skill, String[] skill_trees) {
        ArrayList<String> skillList = new ArrayList<>();
        for (int i = 0; i < skill.length(); i++) {
            skillList.add(String.valueOf(skill.charAt(i)));
        }

        int answer = 0;
        for (String skill_tree : skill_trees) {
            boolean isSuccess = true;
            int[] checkSkill = new int[skill.length()];

            for (int i = 0; i < skill_tree.length(); i++) {
                int idx = skillList.indexOf(String.valueOf(skill_tree.charAt(i)));
                if (idx != -1) {
                    if (idx == 0 || checkSkill[idx-1] == 1) {
                        checkSkill[idx] = 1;
                    } else {
                        isSuccess = false;
                        break;
                    }
                }
            }

            if (isSuccess) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_tree = { "BACDE", "CBADF", "AECB", "BDA" };

        SkillTree skillTree = new SkillTree();
        skillTree.solution(skill, skill_tree);
    }
}
