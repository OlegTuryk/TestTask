package olegt.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FileReaderTest {
    private FileReader fileReader;
    private static final String FILENAME = "src/test/resources/inputTest.txt";

    @BeforeEach
    public void setUp() {
        fileReader = new FileReader();
    }

    @Test
    void readFromFile_validFile_ok() {
        String expected = """
                Test\r
                8 3\r
                ABBABAAB\r
                1 4 4\r
                2 6 1\r
                3 7 5""";
        String actual = fileReader.read(FILENAME);
        Assertions.assertEquals(actual, expected);
    }

    @Test
    void readFromFile_nonExistentFile_notOk() {
        String nonExistentFileName = "non_existent_file.csv";
        Assertions.assertThrows(RuntimeException.class,
                () -> fileReader.read(nonExistentFileName));
    }
}
