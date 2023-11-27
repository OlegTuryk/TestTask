package olegt.io;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FileWriterTest {
    private static final String testFolderPath = "src/test/resources/";
    private FileWriter fileWriter;

    @BeforeEach
    public void setUp() {
        fileWriter = new FileWriter();
    }

    @Test
    void writeToFile_validData_fileCreatedWithCorrectContent() throws IOException {
        String fileName = testFolderPath + "outputTest.txt";
        List<Integer> testData = new ArrayList<>(Arrays.asList(1, 2, 3));
        fileWriter.write(fileName, testData);
        Path path = Path.of(fileName);
        String actual = Files.readString(path);
        String expected = "1\r\n2\r\n3\r\n";
        Assertions.assertEquals(expected, actual);
        Files.deleteIfExists(path);
    }
}
