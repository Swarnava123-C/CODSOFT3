import java.util.*;

public class CourseRegistrationSystem {
    static Scanner scanner = new Scanner(System.in);
    static List<Course> courses = new ArrayList<>();
    static Map<String, Student> students = new HashMap<>();

    public static void main(String[] args) {
        initializeCourses();

        while (true) {
            System.out.println("\n📚 Student Course Registration System");
            System.out.println("1. Register as a new student");
            System.out.println("2. View available courses");
            System.out.println("3. Register for a course");
            System.out.println("4. Drop a course");
            System.out.println("5. View registered courses");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1 -> registerStudent();
                case 2 -> listCourses();
                case 3 -> registerForCourse();
                case 4 -> dropCourse();
                case 5 -> viewRegisteredCourses();
                case 6 -> {
                    System.out.println("Exiting... Thank you!");
                    return;
                }
                default -> System.out.println("❌ Invalid choice! Try again.");
            }
        }
    }

    private static void initializeCourses() {
        courses.add(new Course("CS101", "Introduction to Java", "Basic Java programming", "Mon & Wed 10 AM", 3));
        courses.add(new Course("CS102", "Data Structures", "Stacks, Queues, Trees", "Tue & Thu 12 PM", 2));
        courses.add(new Course("CS103", "Web Development", "HTML, CSS, JS", "Fri 2 PM", 2));
    }

    private static void registerStudent() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        students.put(id, new Student(id, name));
        System.out.println("✅ Student registered successfully!");
    }

    private static void listCourses() {
        System.out.println("\n📜 Available Courses:");
        for (Course c : courses) {
            System.out.println(c);
        }
    }

    private static void registerForCourse() {
        Student student = getStudent();
        if (student == null) return;

        listCourses();
        System.out.print("Enter Course Code to register: ");
        String code = scanner.nextLine();
        
        Course course = findCourse(code);
        if (course != null) {
            student.registerCourse(course);
        } else {
            System.out.println("❌ Course not found!");
        }
    }

    private static void dropCourse() {
        Student student = getStudent();
        if (student == null) return;

        student.showRegisteredCourses();
        System.out.print("Enter Course Code to drop: ");
        String code = scanner.nextLine();

        Course course = findCourse(code);
        if (course != null) {
            student.dropCourse(course);
        } else {
            System.out.println("❌ Course not found!");
        }
    }

    private static void viewRegisteredCourses() {
        Student student = getStudent();
        if (student != null) {
            student.showRegisteredCourses();
        }
    }

    private static Student getStudent() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        
        if (students.containsKey(id)) {
            return students.get(id);
        } else {
            System.out.println("❌ Student not found! Please register first.");
            return null;
        }
    }

    private static Course findCourse(String code) {
        return courses.stream().filter(c -> c.code.equalsIgnoreCase(code)).findFirst().orElse(null);
    }
}

class Course {
    String code, title, description, schedule;
    int capacity, enrolled;

    public Course(String code, String title, String description, String schedule, int capacity) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.schedule = schedule;
        this.capacity = capacity;
        this.enrolled = 0;
    }

    public boolean hasSeats() {
        return enrolled < capacity;
    }

    public void enrollStudent() {
        if (hasSeats()) {
            enrolled++;
        }
    }

    public void dropStudent() {
        if (enrolled > 0) {
            enrolled--;
        }
    }

    @Override
    public String toString() {
        return code + " - " + title + " (" + schedule + ") | Available Slots: " + (capacity - enrolled);
    }
}

class Student {
    String studentID, name;
    List<Course> registeredCourses = new ArrayList<>();

    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
    }

    public void registerCourse(Course course) {
        if (course.hasSeats()) {
            registeredCourses.add(course);
            course.enrollStudent();
            System.out.println("✅ Successfully registered for: " + course.title);
        } else {
            System.out.println("❌ Course is full!");
        }
    }

    public void dropCourse(Course course) {
        if (registeredCourses.remove(course)) {
            course.dropStudent();
            System.out.println("✅ Dropped course: " + course.title);
        } else {
            System.out.println("❌ You are not registered for this course!");
        }
    }

    public void showRegisteredCourses() {
        if (registeredCourses.isEmpty()) {
            System.out.println("No courses registered.");
        } else {
            System.out.println("Registered Courses:");
            for (Course c : registeredCourses) {
                System.out.println("- " + c.title);
            }
        }
    }
}
//Output:

/*📚 Student Course Registration System
1. Register as a new student
2. View available courses
3. Register for a course
4. Drop a course
5. View registered courses
6. Exit
Enter your choice: 1
Enter Student ID: 231001001247
Enter Student Name: Swarnava Malakar
? Student registered successfully!

? Student Course Registration System
1. Register as a new student
2. View available courses
3. Register for a course
4. Drop a course
5. View registered courses
6. Exit
Enter your choice: 2

? Available Courses:
CS101 - Introduction to Java (Mon & Wed 10 AM) | Available Slots: 3
CS102 - Data Structures (Tue & Thu 12 PM) | Available Slots: 2
CS103 - Web Development (Fri 2 PM) | Available Slots: 2

? Student Course Registration System
1. Register as a new student
2. View available courses
3. Register for a course
4. Drop a course
5. View registered courses
6. Exit
Enter your choice: 3
Enter Student ID: 231001001247

? Available Courses:
CS101 - Introduction to Java (Mon & Wed 10 AM) | Available Slots: 3
CS102 - Data Structures (Tue & Thu 12 PM) | Available Slots: 2
CS103 - Web Development (Fri 2 PM) | Available Slots: 2
Enter Course Code to register: CS103
? Successfully registered for: Web Development

? Student Course Registration System
1. Register as a new student
2. View available courses
3. Register for a course
4. Drop a course
5. View registered courses
6. Exit
Enter your choice: 4
Enter Student ID: 231001001247
Registered Courses:
- Web Development
Enter Course Code to drop: CS103
? Dropped course: Web Development

? Student Course Registration System
1. Register as a new student
2. View available courses
3. Register for a course
4. Drop a course
5. View registered courses
6. Exit
Enter your choice: 5
Enter Student ID: 231001001247
No courses registered.

? Student Course Registration System
1. Register as a new student
2. View available courses
3. Register for a course
4. Drop a course
5. View registered courses
6. Exit
Enter your choice: 6
Exiting... Thank you! */
