package data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by: Josh
 * On: 5/2/13 11:23 PM
 */
public class FastDatabase implements StudentDatabase {
    private ArrayList<Student> students;
    private ArrayList<Index>[] gradeIndex;

    public FastDatabase() {
        students = new ArrayList<Student>(10000);

        gradeIndex = new ArrayList[Major.values().length];
        for (int i = 0; i < gradeIndex.length; ++i) {
            gradeIndex[i] = new ArrayList<Index>(10000);
        }
    }

    @Override
    public boolean addStudent(Student student) {
        int studentId = students.size();
        student.setId(studentId);
        students.add(student);

        //Add the student to the index corresponding to their majors.
        int[] majors = Arrays.copyOf(student.getMajors(), student.getMajors().length + 1);
        //Also add them to the all students level.
        majors[majors.length - 1] = 0;

        Index newStudentGrade = new Index(studentId, student.getGrade());
        for (int major : majors) {
            insertMajorGrade(gradeIndex[major], newStudentGrade);
        }
        return true;
    }

    private void insertMajorGrade(List<Index> index, Index newStudentGrade) {
        //Perform insertion sort here on index. The Index class has a compareTo method.
    }

    @Override
    public Student getById(int id) {
        if (id > students.size() - 1 && id >= 0) {
            return null;
        } else {
            return students.get(id);
        }
    }

    @Override
    public double[] getPercentilesById(int id) {
        return new double[0];
    }

    @Override
    public Student[] getHighestAchievers() {
        return new Student[0];
    }
}
