package nsu.oop.gradeBook;

/**
 * Class Subject.
 * Represents subject of FIT student.
 */
public class Subject {
    String subjectName;
    Mark[] grades = new Mark[9];
    int filled = 0;

    /**
     * Constructor of Subject class.
     * @param subjectName - the name of subject.
     */
    public Subject(String subjectName){
        this.subjectName = subjectName;
        for(int i = 0; i < 9; i++){
            grades[i] = Mark.Undefined;
        }
    }

    /**
     * Public method putMark.
     * This method puts mark for subject in given semester.
     * @param mark - mark for subject.
     * @param semester - given semester.
     */
    public void putMark(int mark, int semester){
        grades[semester] = Mark.intToMark(mark);
        filled++;
    }

    /**
     * Public method returnMark.
     * This method return int value instead of Mark.
     * @param semester - given semester.
     * @return int value instead of Mark value
     */
    public int returnMark(int semester){
        return Mark.markToInt(grades[semester]);
    }

    /**
     * Public method returnSum.
     * This method calculates the sum of marks for subject.
     * @return the sum of marks for subject.
     */
    public double returnSum(){
        int sum = 0;
        for(Mark a : grades){
            sum += Mark.markToInt(a);
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
        for(Mark mark : grades){
            if(Mark.markToInt(mark) == 5){
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
        for(Mark mark : grades){
            if(Mark.markToInt(mark) <= 3 && Mark.markToInt(mark) != 0){
                return true;
            }
        }
        return false;
    }
}
