package nsu.oop.substring;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.io.InputStreamReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class JUnitTestSubstringFinder {
    @Test
    void testOne() throws IOException {
        FileWriter fw = new FileWriter("input.txt", StandardCharsets.UTF_8);
        String str = "lorem ipsum dolor";

        fw.write(str);
        fw.close();

        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("input.txt"), StandardCharsets.UTF_8);
        ArrayList<Long> result = SubstringFinder.substringSearch(inputStreamReader, "ipsum".toCharArray());
        Long[] expectedResult = new Long[]{6L};
        assertArrayEquals(expectedResult, result.toArray());
        inputStreamReader.close();

        File file = new File("input.txt");
        file.delete();
    }
    @Test
    void noMatchesTest() throws IOException {
        FileWriter fw = new FileWriter("input.txt", StandardCharsets.UTF_8);
        String str = "lorem ipsum domini";

        fw.write(str);
        fw.close();

        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("input.txt"), StandardCharsets.UTF_8);
        ArrayList<Long> result = SubstringFinder.substringSearch(inputStreamReader, "conina".toCharArray());
        Integer[] expectedResult = new Integer[]{};
        assertArrayEquals(expectedResult, result.toArray());
        inputStreamReader.close();

        File file = new File("input.txt");
        file.delete();
    }
    @Test
    void test14GBFile() throws IOException { //on my laptop it takes 2m45s
        FileWriter fw = new FileWriter("input.txt", StandardCharsets.UTF_8);
        String str = "But whoever disobeys Allah and His Messenger and exceeds their limits " +
                "will be cast into Hell, to stay there forever. And they will suffer a humiliating punishment. ".repeat(10) +
                "Allah only accepts the repentance of those who repent soon after — Allah will pardon them.\n".repeat(10);
        Long[] expectedResult = new Long[(int) (14L * 1024 * 1024 * 1024 / str.length())];
        for (long i = 0; i < (int) (14L * 1024 * 1024 * 1024 / str.length()); i++) {
            if (i % 10000000 == 0)
                fw.flush();
            fw.write(str);
            expectedResult[(int)i] = (i * str.length());
        }
        fw.close();

        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("input.txt"), StandardCharsets.UTF_8);
        ArrayList<Long> result = SubstringFinder.substringSearch(inputStreamReader, "But whoever disobeys Allah".toCharArray());


        assertArrayEquals(expectedResult, result.toArray());
        inputStreamReader.close();

        File file = new File("input.txt");
        file.delete();
    }
}
