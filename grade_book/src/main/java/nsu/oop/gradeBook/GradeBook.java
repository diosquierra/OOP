package nsu.oop.gradeBook;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.NoSuchElementException;

/**
 * Class GradeBook.
 * Represents virtual FIT grade book class.
 */
public class GradeBook {
    String name;
    private int markDiplomaWork = 0;

    List<Subject> subjectList = new ArrayList<>();
    Map<String, Integer> subjectCode = new HashMap<>();
    private int lastPoint = 0;

    /**
     * Constructor of GradeBook class.
     * @param name - the name of student.
     */
    public GradeBook(String name){
        this.name = name;
    }

    /**
     * Public method estimateDiplomaWork.
     * This method puts mark for student's diploma work.
     * @param mark - mark for diploma work.
     */
    public void estimateDiplomaWork(int mark){
        markDiplomaWork = mark;
    }

    /**
     * Public method insertSubject.
     * Adding a new subject in student's grade book.
     * Also checks if there is enough space for new subject in array.
     * @param subjectName - name of subject.
     */
    public void insertSubject(String subjectName){
        subjectList.add(new Subject(subjectName));
        subjectCode.put(subjectName, lastPoint);
        lastPoint++;
    }

    /**
     * Public method estimateStudent.
     * This method puts mark for subject in a given semester.
     * This method uses putMark() method of class Subject.
     * @param subjectName - name of subject
     * @param mark - mark for subject.
     * @param semester - given semester.
     */
    public void estimateStudent(String subjectName, int mark, int semester){
        int code;
        if(!subjectCode.containsKey(subjectName)){
            throw new NoSuchElementException("No such subject in this grade book!");
        }
        code = subjectCode.get(subjectName);
        subjectList.get(code).putMark(mark, semester);
    }

    /**
     * Public method middleMark.
     * This method calculate GPA for all study period.
     * This method uses returnSum() and returnFilled() methods of class Subject.
     * @return GPA (double).
     */
    public double middleMark(){
        double sum = 0;
        double denominator = 0;
        for(int i = 0; i < lastPoint; i++){
            sum += subjectList.get(i).returnSum();
            denominator += subjectList.get(i).returnFilled();
        }
        return (sum / denominator);
    }

  /**
   * Public method redDiploma. This method calculates possibility of getting red diploma for
   * student. This method uses markForDiplomaCheck() and ifNoMarkThree methods of class GradeBook.
   *
   * @return true if getting red diploma is possible, other way false (boolean).
   */
    public boolean redDiploma() {
        return markDiplomaWork == 5 && markForDiplomaCheck() && ifNoMarkThree();
    }
    /**
     * Private method markForDiplomaCheck.
     * This method calculates if student has 75% or more "5" marks.
     * This method uses returnCountFives() and returnFilled() methods of class Subject
     * @return true if has 75% or more "5" marks, other way false (boolean).
     */
    private boolean markForDiplomaCheck(){
        double countFives = 0;
        double countMarks = 0;

        for(int i = 0; i < lastPoint; i++){
            countFives += subjectList.get(i).returnCountFives();
            countMarks += subjectList.get(i).returnFilled();
        }

        return (countFives / countMarks) * 100 >= 75;
    }

    /**
     * Private method ifNoMarkThree.
     * This method is calculating if student has "3" marks.
     * This method is using returnIfMarkThree() method of class Subject.
     * @return true if hasn't, other way false (boolean).
     */
    private boolean ifNoMarkThree(){
        for(int i = 0; i < lastPoint; i++){
            if(subjectList.get(i).returnIfMarkThree()){
                return false;
            }
        }
        return true;
    }

    /**
     * Public method meritScholarship.
     * This method calculates possibility of getting merit scholarship for student.
     * @param semester - semester of checking.
     * @return true if it is possible for student to get merit scholarship, other way false (boolean).
     */
    public boolean meritScholarship(int semester){
        int checkSemester = semester - 1;

        if(checkSemester == -1){
            return false;
        }

        for(int i = checkSemester; i <= semester; i++){
            for(int j = 0; j < lastPoint; j++){
                if((subjectList.get(j).returnMark(i) != 0) && (subjectList.get(j).returnMark(i) != 5)){
                    return false;
                }
            }
        }
        return true;
    }

}