package data;

/**
 * Created by: Josh
 * On: 4/25/13 2:45 PM
 */
public class Student {
    private int studentId;
    private String name;
    private double grade;
    private int[] majors;

    Student(int studentId, String name, double grade, int[] majors) {
        this.studentId = studentId;
        this.name = name;
        if (grade > 100)
            this.grade = 100;
        else if (grade < 0)
            this.grade = 0;
        else
            this.grade = grade;
        this.majors = majors;
    }

    int[] getMajors() {
        return majors;
    }

    double getGrade() {
        return grade;
    }

    void setId(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {

        String studentIdString = String.format("%7s", studentId).replace(" ", "0");

        Major[] majorList = Major.values();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < majors.length - 1; ++i) {
            sb.append(majorList[majors[i]].getDescription())
                    .append(", ");
        }
        sb.append(majorList[majors[majors.length - 1]].getDescription());

        return String.format("%s|%20s|%8.2f|   %s", studentIdString, name, grade, sb.toString());
    }
}
