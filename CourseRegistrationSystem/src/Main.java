
public class Main {
	public static void main(String[] args) {
        Course course1 = new Course("SCSA1616", "Linux Programming", "Introduction and File Utilities", 50);
        Course course2 = new Course("SCSA2626", "Linux Programming Lab", "Basic linux commands", 40);

        Student student1 = new Student("41614005", "Amirtha Sowmya");
        Student student2 = new Student("41614001", "Aashini");

        student1.registerCourse(course1);
        student1.registerCourse(course2);
        student2.registerCourse(course1);

        displayCourses(course1, course2);

        student1.dropCourse(course1);

        displayCourses(course1, course2);
    }

    public static void displayCourses(Course... courses) {
        for (Course course : courses) {
            System.out.println(course.toString());
        }
    }

}
