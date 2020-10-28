package nsu.oop.gradeBook;

import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JunitTest {
    @Test
    void testOne(){
        GradeBook testOne = new GradeBook("Alexander Bayusov");
        testOne.insertSubject("Digital platforms");
        testOne.insertSubject("Declarative programming");
        testOne.insertSubject("Physical Education");
        testOne.insertSubject("Algebra and math analysis");
        testOne.insertSubject("History");
        testOne.insertSubject("Discrete math and math logic");
        testOne.insertSubject("Culture of speech");
        testOne.insertSubject("English");
        testOne.insertSubject("Algorithms and data structures");
        testOne.insertSubject("Imperative programming");

        testOne.estimateStudent("Digital platforms", 5, 1);
        testOne.estimateStudent("Digital platforms", 3, 2);
        testOne.estimateStudent("Declarative programming", 3, 1);
        testOne.estimateStudent("Declarative programming", 3, 2);
        testOne.estimateStudent("Physical Education", 5, 1);
        testOne.estimateStudent("Physical Education", 5, 2);
        testOne.estimateStudent("Algebra and math analysis", 3, 1);
        testOne.estimateStudent("Algebra and math analysis", 3, 2);
        testOne.estimateStudent("History", 4, 1);
        testOne.estimateStudent("Discrete math and math logic", 3, 1);
        testOne.estimateStudent("Discrete math and math logic", 3, 2);
        testOne.estimateStudent("Culture of speech", 5, 1);
        testOne.estimateStudent("English", 5, 1);
        testOne.estimateStudent("English", 3, 2);
        testOne.estimateStudent("Algorithms and data structures", 5, 1);
        testOne.estimateStudent("Algorithms and data structures", 5, 2);
        testOne.estimateStudent("Imperative programming", 4, 1);
        testOne.estimateStudent("Imperative programming", 3, 2);

        assertEquals(3.888888888888889 ,testOne.middleMark());
        assertEquals(false, testOne.redDiploma());
        assertEquals(false, testOne.meritScholarship(2));
    }

    @Test
    void testRedDiploma(){
        GradeBook testBook = new GradeBook("Aphonasiy Zhmishenko");
        testBook.insertSubject("Basketball");
        testBook.insertSubject("Baseball");
        testBook.estimateStudent("Basketball", 5, 1);
        testBook.estimateStudent("Basketball", 5, 2);
        testBook.estimateStudent("Baseball", 5, 1);
        testBook.estimateStudent("Baseball", 5, 2);
        testBook.estimateDiplomaWork(5);

        assertEquals(true, testBook.redDiploma());
    }

    @Test
    void testScholarship(){
        GradeBook testBook = new GradeBook("Li Quan Yu");
        testBook.insertSubject("History of Chine");
        testBook.insertSubject("Mao Zedong");
        testBook.estimateStudent("History of Chine", 5, 1);
        testBook.estimateStudent("History of Chine", 5, 2);
        testBook.estimateStudent("Mao Zedong", 5, 1);
        testBook.estimateStudent("Mao Zedong", 5, 2);

        assertEquals(true, testBook.meritScholarship(2));
    }

    @Test
    void testException() throws NoSuchElementException {
        GradeBook testBook = new GradeBook("Yasos Biba");
        Throwable thrown = assertThrows(NoSuchElementException.class, () -> {
            testBook.estimateStudent("Philosophy", 5, 1);
        });

    }
}
