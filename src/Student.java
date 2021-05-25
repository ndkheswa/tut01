public class Student {

    private String name;
    public double test1, test2, test3;

    private int ID;

    private static int nextUniqueID = 0;
        // keep track of the next available unique ID

    Student(String theName) {
        // Constructor for Student objects; provides a name for the Student,
        // and assignes a unique ID for the Student
        name = theName;
        nextUniqueID++;
        ID = nextUniqueID;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public double getAverage() {
        return (test1 + test2 + test3) / 3;
    }

} // end of class Student
