class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }
}

class Student extends Person {
    final int studentId;
    double gpa;

    Student(String name, int age, int studentId, double gpa) {
        super(name, age);
        this.studentId = studentId;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Student ID: " + studentId +
                ", GPA: " + gpa;
    }
}

class GradStudent extends Student {
    String thesis;

    GradStudent(String name, int age, int studentId,
                double gpa, String thesis) {
        super(name, age, studentId, gpa);
        this.thesis = thesis;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Thesis: " + thesis;
    }
}

public class UniversityDemo {
    public static void main(String[] args) {

        GradStudent gs =
            new GradStudent("Raghav", 23, 101, 9.1,
                    "Artificial Intelligence");

        System.out.println(gs);

        Person p = gs;
        Student s = gs;

        System.out.println("\nGradStudent IS-A Student: "
                + (s instanceof Student));

        System.out.println("GradStudent IS-A Person: "
                + (p instanceof Person));
    }
}