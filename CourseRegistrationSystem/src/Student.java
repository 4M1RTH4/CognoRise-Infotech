import java.util.ArrayList;
import java.util.List;
public class Student {
	private String studentID;
    private String name;
    private List<Course> registeredCourses;

    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerCourse(Course course) {
        if (course.registerStudent()) {
            registeredCourses.add(course);
            System.out.println("Course " + course.getTitle() + " registered successfully for " + name);
        } else {
            System.out.println("Course " + course.getTitle() + " is already full.");
        }
    }

    public void dropCourse(Course course) {
        if (registeredCourses.contains(course)) {
            course.removeStudent();
            registeredCourses.remove(course);
            System.out.println("Course " + course.getTitle() + " dropped successfully for " + name);
        } else {
            System.out.println("Course " + course.getTitle() + " not found in registered courses.");
        }
    }
}
