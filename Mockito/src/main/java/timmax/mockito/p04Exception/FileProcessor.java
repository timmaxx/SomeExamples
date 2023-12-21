package timmax.mockito.p04Exception;

import java.io.IOException;

public class FileProcessor {
    private final FileReader fileReader;

    public FileProcessor(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public String processFile(String path) {
        try {
            return "Processed: " + fileReader.readFile(path);
        } catch (IOException e) {
            return "Error";
        }
    }
}
