package olegt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import org.apache.commons.io.FileUtils;

public class FileReader {
    public String read(String fileName) {
        File file = new File(fileName);
        try {
            if (file.exists() && file.canRead()) {
                return FileUtils.readFileToString(file, Charset.defaultCharset());
            } else {
                throw new FileNotFoundException("File not found or not readable: " + fileName);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + file.getName(), e);
        }
    }
}
