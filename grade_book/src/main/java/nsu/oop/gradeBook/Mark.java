package nsu.oop.gradeBook;

/**
 * Mark class
 */
public enum Mark {
    /**
     * Marks list
     */
    UNDEFINED,
    ONE,
    FAILED,
    SATISFACTORY,
    GOOD,
    EXCELLENT;

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
                return UNDEFINED;
            case 1:
                return ONE;
            case 2:
                return FAILED;
            case 3:
                return SATISFACTORY;
            case 4:
                return GOOD;
            case 5:
                return EXCELLENT;
        }
        throw new IllegalArgumentException("Incorrect mark!");
    }
}
