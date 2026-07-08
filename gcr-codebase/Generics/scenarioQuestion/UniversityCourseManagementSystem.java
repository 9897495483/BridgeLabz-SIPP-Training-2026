import java.util.ArrayList;
import java.util.List;

// Base Class
abstract class CourseType {
    private String courseName;

    public CourseType(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public abstract void evaluationMethod();
}

// Exam Based Course
class ExamCourse extends CourseType {

    public ExamCourse(String courseName) {
        super(courseName);
    }

    @Override
    public void evaluationMethod() {
        System.out.println(getCourseName() + " -> Evaluation: Final Exam");
    }
}

// Assignment Based Course
class AssignmentCourse extends CourseType {

    public AssignmentCourse(String courseName) {
        super(courseName);
    }

    @Override
    public void evaluationMethod() {
        System.out.println(getCourseName() + " -> Evaluation: Assignments");
    }
}

// Research Based Course
class ResearchCourse extends CourseType {

    public ResearchCourse(String courseName) {
        super(courseName);
    }

    @Override
    public void evaluationMethod() {
        System.out.println(getCourseName() + " -> Evaluation: Research Project");
    }
}

// Generic Course Class
class Course<T extends CourseType> {

    private List<T> courses = new ArrayList<>();

    public void addCourse(T course) {
        courses.add(course);
    }

    public List<T> getCourses() {
        return courses;
    }

    public void displayCourses() {
        for (T course : courses) {
            course.evaluationMethod();
        }
    }
}

// Utility Class
class CourseUtility {

    // Wildcard Method
    public static void displayAllCourses(List<? extends CourseType> list) {

        System.out.println("\nAvailable Courses:");

        for (CourseType course : list) {
            course.evaluationMethod();
        }
    }
}

// Main Class
public class UniversityCourseManagementSystem {

    public static void main(String[] args) {

        // Exam Courses
        Course<ExamCourse> examCourses = new Course<>();
        examCourses.addCourse(new ExamCourse("Operating Systems"));
        examCourses.addCourse(new ExamCourse("Database Management"));

        // Assignment Courses
        Course<AssignmentCourse> assignmentCourses = new Course<>();
        assignmentCourses.addCourse(new AssignmentCourse("Java Programming"));
        assignmentCourses.addCourse(new AssignmentCourse("Web Development"));

        // Research Courses
        Course<ResearchCourse> researchCourses = new Course<>();
        researchCourses.addCourse(new ResearchCourse("Artificial Intelligence"));
        researchCourses.addCourse(new ResearchCourse("Machine Learning"));

        System.out.println("Exam Courses");
        examCourses.displayCourses();

        System.out.println("\nAssignment Courses");
        assignmentCourses.displayCourses();

        System.out.println("\nResearch Courses");
        researchCourses.displayCourses();

        // Wildcard Demonstration
        CourseUtility.displayAllCourses(examCourses.getCourses());
        CourseUtility.displayAllCourses(assignmentCourses.getCourses());
        CourseUtility.displayAllCourses(researchCourses.getCourses());
    }
}