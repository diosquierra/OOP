package nsu.oop.gradeBook;

/**
 * Mark class
 */
public enum Mark {
    /**
     * Marks list
     */
    Undefined,
    One,
    Failed,
    Satisfactory,
    Good,
    Excellent;

    /**
     * Public static method intToMark.
     * This method convert int value into Mark value.
     * @param mark - int value.
     * @return Mark value.
     * @throws IllegalArgumentException if mark is incorrect
     */
    public static Mark intToMark(int mark){
        switch (mark){
            case 0:
                return Undefined;
            case 1:
                return One;
            case 2:
                return Failed;
            case 3:
                return Satisfactory;
            case 4:
                return Good;
            case 5:
                return Excellent;
        }
        throw new IllegalArgumentException("Incorrect mark!");
    }

    /**
     * Public static method markToInt.
     * This method convert Mark value into int value.
     * @param mark - Mark value.
     * @return int value.
     * @throws IllegalArgumentException if mark is incorrect.
     */
    public static int markToInt(Mark mark){
        switch(mark){
            case Undefined:
                return 0;
            case One:
                return 1;
            case Failed:
                return 2;
            case Satisfactory:
                return 3;
            case Good:
                return 4;
            case Excellent:
                return 5;
        }
        throw new IllegalArgumentException("Incorrect mark!");
    }

}
