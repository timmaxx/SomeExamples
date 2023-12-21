package timmax.mockito.p01;

import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {
    public static void main(String[] args) {
        DataService mockDataService = Mockito.mock(DataService.class);
        System.out.println(mockDataService);
        System.out.println(mockDataService.retrieveData());

        Mockito.when(mockDataService.retrieveData()).thenReturn(15.0);
        System.out.println(mockDataService.retrieveData());

        DataProcessor processor = new DataProcessor(mockDataService);
        double result = processor.processData();

        assertEquals(30.0, result, 0.01);
    }
}