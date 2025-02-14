// Custom Exception: CourseFullException
class CourseFullException extends Exception {
    public CourseFullException(String message) {
        super(message);
    }
}

// Custom Exception: PrerequisiteNotMetException
class PrerequisiteNotMetException extends Exception {
    public PrerequisiteNotMetException(String message) {
        super(message);
    }
}

class Course {
    private String name;
    private int capacity;
    private int enrolledStudents;
    private String prerequisite;

    public Course(String name, int capacity, String prerequisite) {
        this.name = name;
        this.capacity = capacity;
        this.prerequisite = prerequisite;
        this.enrolledStudents = 0;
    }

    public String getName() {
        return name;
    }

    public String getPrerequisite() {
        return prerequisite;
    }

    public boolean isFull() {
        return enrolledStudents >= capacity;
    }

    public void enrollStudent() throws CourseFullException {
        if (isFull()) {
            throw new CourseFullException("Course is full: " + name);
        }
        enrolledStudents++;
    }
}

public class UniversityEnrollmentSystem {
    public void enrollStudent(String studentName, Course course, boolean prerequisiteCompleted) {
        try {
            if (!prerequisiteCompleted) {
                throw new PrerequisiteNotMetException(
                    "Complete " + course.getPrerequisite() + " before enrolling in " + course.getName() + "."
                );
            }
            course.enrollStudent();
            System.out.println("Success: " + studentName + " enrolled in " + course.getName());
        } catch (PrerequisiteNotMetException | CourseFullException e) {
            System.out.println("Error: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        Course coreJava = new Course("Core Java", 3, null);
        Course advancedJava = new Course("Advanced Java", 2, "Core Java");


        UniversityEnrollmentSystem enrollmentSystem = new UniversityEnrollmentSystem();


        enrollmentSystem.enrollStudent("Nikhil", coreJava, true); 
        enrollmentSystem.enrollStudent("Aadi", coreJava, true);   
        enrollmentSystem.enrollStudent("Vikrant", coreJava, true); 

    
        enrollmentSystem.enrollStudent("Diksha", coreJava, true); 
        enrollmentSystem.enrollStudent("Emily", advancedJava, false); 
    }
}
