package timmax.mockito.p04Exception;

import java.io.IOException;

public interface FileReader {
    String readFile(String path) throws IOException;
}
