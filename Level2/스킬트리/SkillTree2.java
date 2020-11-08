package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class SkillTree2 {

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        ArrayList<String> skillTrees = new ArrayList<>(Arrays.asList(skill_trees));

        Iterator<String> it = skillTrees.iterator();
        while (it.hasNext()) {
            if (skill.indexOf(it.next().replaceAll("[^" + skill + "]", "")) != 0) {
                it.remove();
            }
        }
        answer = skillTrees.size();
        return answer;
    }

    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_tree = { "BACDE", "CBADF", "AECB", "BDA" };

        SkillTree2 skillTree2 = new SkillTree2();
        skillTree2.solution(skill, skill_tree);
    }
}
