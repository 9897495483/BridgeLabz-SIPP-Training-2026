import java.util.ArrayList;
import java.util.List;

// Base Class
abstract class JobRole {
    private String roleName;

    public JobRole(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public abstract void displayRole();
}

// Software Engineer
class SoftwareEngineer extends JobRole {

    public SoftwareEngineer() {
        super("Software Engineer");
    }

    @Override
    public void displayRole() {
        System.out.println("Role : " + getRoleName());
    }
}

// Data Scientist
class DataScientist extends JobRole {

    public DataScientist() {
        super("Data Scientist");
    }

    @Override
    public void displayRole() {
        System.out.println("Role : " + getRoleName());
    }
}

// Product Manager
class ProductManager extends JobRole {

    public ProductManager() {
        super("Product Manager");
    }

    @Override
    public void displayRole() {
        System.out.println("Role : " + getRoleName());
    }
}

// Generic Resume Class
class Resume<T extends JobRole> {

    private String candidateName;
    private T jobRole;

    public Resume(String candidateName, T jobRole) {
        this.candidateName = candidateName;
        this.jobRole = jobRole;
    }

    public void displayResume() {
        System.out.println("Candidate : " + candidateName);
        jobRole.displayRole();
        System.out.println();
    }

    public T getJobRole() {
        return jobRole;
    }
}

// Utility Class
class ResumeScreeningUtility {

    // Generic Method
    public static <T extends JobRole> void screenResume(Resume<T> resume) {
        System.out.println("Resume Screening Successful");
        resume.displayResume();
    }

    // Wildcard Method
    public static void displayJobRoles(List<? extends JobRole> roles) {

        System.out.println("Available Job Roles:");

        for (JobRole role : roles) {
            role.displayRole();
        }
    }
}

// Main Class
public class AIResumeScreeningSystem {

    public static void main(String[] args) {

        Resume<SoftwareEngineer> resume1 =
                new Resume<>("Raghav", new SoftwareEngineer());

        Resume<DataScientist> resume2 =
                new Resume<>("Rahul", new DataScientist());

        Resume<ProductManager> resume3 =
                new Resume<>("Anjali", new ProductManager());

        ResumeScreeningUtility.screenResume(resume1);
        ResumeScreeningUtility.screenResume(resume2);
        ResumeScreeningUtility.screenResume(resume3);

        List<JobRole> roles = new ArrayList<>();

        roles.add(new SoftwareEngineer());
        roles.add(new DataScientist());
        roles.add(new ProductManager());

        ResumeScreeningUtility.displayJobRoles(roles);
    }
}