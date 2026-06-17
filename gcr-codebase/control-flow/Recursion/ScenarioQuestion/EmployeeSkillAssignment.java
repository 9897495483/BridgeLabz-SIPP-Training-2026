
public class EmployeeSkillAssignment {

    static void findTeams(int[] skills,int index,int target,String team,int sum) {

        if (sum == target) {
            System.out.println("[" +
                    team.substring(0,
                    team.length() - 1) + "]");
            return;
        }

        if (index == skills.length || sum > target)
            return;

        // Include current employee
        findTeams(skills,
                index + 1,
                target,
                team + skills[index] + ",",
                sum + skills[index]);

        // Exclude current employee
        findTeams(skills,
                index + 1,
                target,
                team,
                sum);
    }

    public static void main(String[] args) {

        int[] skills = {2, 3, 5, 7};
        int target = 10;

        findTeams(skills,
                0,
                target,
                "",
                0);
    }
}