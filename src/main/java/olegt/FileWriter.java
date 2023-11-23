package olegt;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;

public class FileWriter {
    public void write(String filename, List<Integer> data) {
        File file = new File(filename);
        try {
            FileUtils.writeLines(file, data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write in file " + file.getName(), e);
        }
    }
}
