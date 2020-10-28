package nsu.oop.gradeBook;

import java.util.Arrays;
import java.util.HashMap;
import java.util.NoSuchElementException;

/**
 * Class GradeBook.
 * Represents virtual FIT grade book class.
 */
public class GradeBook {
    String name;
    private int markDiplomaWork = 0;

    Subject[] subjectList = new Subject[50];
    HashMap subjectCode = new HashMap();
    private int lastPoint = 0;
    private int sizeOfList = 50;

    /**
     * Private method reallocSubjList.
     * This method reallocate subjectList by increasing his size by 50.
     */
    private void reallocSubjList(){
        subjectList = Arrays.copyOf(subjectList, subjectList.length + 50);
        sizeOfList += 50;
    }

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
        subjectList[lastPoint] = new Subject(subjectName);
        subjectCode.put(subjectName, lastPoint);
        lastPoint++;

        if(lastPoint == sizeOfList){
            reallocSubjList();
        }
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
        if(subjectCode.containsKey(subjectName) == false){
            throw new NoSuchElementException("No such subject in this grade book!");
        }
        code = (int) subjectCode.get(subjectName);
        subjectList[code].putMark(mark, semester);
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
            sum += subjectList[i].returnSum();
            denominator += subjectList[i].returnFilled();
        }
        return (sum / denominator);
    }

    /**
     * Public method redDiploma.
     * This method calculates possibility of getting red diploma for student.
     * This method uses markForDiplomaCheck() and ifNoMarkThree methods of class GradeBook.
     * @return true if getting red diploma is possible, other way false (boolean).
     */
    public boolean redDiploma(){
        if(markDiplomaWork == 5 && markForDiplomaCheck() && ifNoMarkThree()){
            return true;
        }else{
            return false;
        }
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
            countFives += subjectList[i].returnCountFives();
            countMarks += subjectList[i].returnFilled();
        }

        if((countFives / countMarks) * 100 >= 75){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Private method ifNoMarkThree.
     * This method is calculating if student has "3" marks.
     * This method is using returnIfMarkThree() method of class Subject.
     * @return true if hasn't, other way false (boolean).
     */
    private boolean ifNoMarkThree(){
        for(int i = 0; i < lastPoint; i++){
            if(subjectList[i].returnIfMarkThree() == true){
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
                if((subjectList[j].grades[i] != 0) && (subjectList[j].grades[i] != 5)){
                    return false;
                }
            }
        }
        return true;
    }

}

/**
 * Class Subject.
 * Represents subject of FIT student.
 */
class Subject{
    String subjectName;
    int[] grades = new int[9];
    int filled = 0;

    /**
     * Constructor of Subject class.
     * @param subjectName - the name of subject.
     */
    public Subject(String subjectName){
        this.subjectName = subjectName;
    }

    /**
     * Public method putMark.
     * This method puts mark for subject in given semester.
     * @param mark - mark for subject
     * @param semester - given semester.
     */
    public void putMark(int mark, int semester){
        grades[semester] = mark;
        filled++;
    }

    /**
     * Public method returnSum.
     * This method calculates the sum of marks for subject.
     * @return the sum of marks for subject.
     */
    public double returnSum(){
        int sum = 0;
        for(int a : grades){
            sum += a;
        }
        return sum;
    }

    /**
     * Public method returnFilled.
     * This method calculates how many marks was put.
     * @return how many marks was put.
     */
    public double returnFilled(){
        return filled;
    }

    /**
     * Public method returnCountFives.
     * This method calculates how many "5" marks was put for subject.
     * @return how many "5" marks was put for subject.
     */
    public double returnCountFives(){
        int count = 0;
        for(int mark : grades){
            if(mark == 5){
                count++;
            }
        }
        return count;
    }

    /**
     * Public method returnIfMarkThree.
     * This method calculates if "3" or lower marks was put.
     * @return true if "3" or lower marks was put, other way false (boolean).
     */
    public boolean returnIfMarkThree(){
        for(int mark : grades){
            if(mark <= 3 && mark != 0){
                return true;
            }
        }
        return false;
    }
}