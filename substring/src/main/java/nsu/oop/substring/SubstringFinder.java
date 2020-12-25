package nsu.oop.substring;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import static java.lang.Integer.max;

public class SubstringFinder {
    /**
     * substringSearch is public static method which finds substring in file
     * @param file file where we want to search substring
     * @param substring - required substring
     * @return array of indexes of the occurrences.
     * @throws IOException if something wrong with reading.
     * @throws NullPointerException if file or substring is null.
     */
    public static ArrayList<Long> substringSearch(InputStreamReader file, char[] substring) throws IOException {
        if (file == null) {
            throw new NullPointerException("File is null!");
        }
        if (substring == null) {
            throw new NullPointerException("Substring is null!");
        }

        ArrayList<Long> indexes = new ArrayList<>();
        char[] tape = new char[substring.length * 2];
        int lengthOfSubstring = substring.length;
        long positionInFile = 0;

        int readLength = file.read(tape, lengthOfSubstring, lengthOfSubstring);

        if (readLength < lengthOfSubstring) {
            return indexes;
        }

        boolean lastScan = false;
        do {
            System.arraycopy(tape, lengthOfSubstring, tape, 0, lengthOfSubstring);
            if (readLength == lengthOfSubstring) {
                readLength = file.read(tape, lengthOfSubstring, lengthOfSubstring);

                if(readLength < lengthOfSubstring){
                    readLength = max(readLength, 0);
                    readLength++;
                    lastScan = true;
                }
            }

            for (int i = 0; i < readLength; i++) {
                boolean isSubstring = false;

                for (int j = 0; j < lengthOfSubstring; j++) {
                    if (tape[i + j] != substring[j]) {
                        break;
                    }

                    if (j == lengthOfSubstring - 1) {
                        isSubstring = true;
                        break;
                    }
                }

                if (isSubstring) {
                    indexes.add((long) positionInFile);
                }
                positionInFile++;
            }

        } while (!lastScan);

        return indexes;
    }
}
