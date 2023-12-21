package timmax.mockito.p04Exception;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileReaderTest {
    @Test
    public void whenIOException_thenReturnsError() throws IOException {
        // Создание мока
        FileReader mockFileReader = Mockito.mock(FileReader.class);

        // Мокирование исключения
        Mockito.when(mockFileReader.readFile(Mockito.anyString())).thenThrow(new IOException());

        // Тестирование
        FileProcessor fileProcessor = new FileProcessor(mockFileReader);
        String result = fileProcessor.processFile("test.txt");

        System.out.println(result);
        // Проверка
        assertEquals("Error", result);
    }

    @Test
    public void whenSpecificArgument_thenThrowException() throws IOException {
        // Создание мока
        FileReader mockFileReader = Mockito.mock(FileReader.class);

        // Мокирование исключения для конкретного аргумента
        Mockito.when(mockFileReader.readFile("specific.txt")).thenThrow(new IOException());

        // Тестирование
        FileProcessor fileProcessor = new FileProcessor(mockFileReader);
        String result = fileProcessor.processFile("specific.txt");

        // Проверка
        assertEquals("Error", result);
    }
}
