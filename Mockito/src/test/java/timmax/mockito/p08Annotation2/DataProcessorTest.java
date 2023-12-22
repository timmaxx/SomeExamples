package timmax.mockito.p08Annotation2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
// import org.mockito.junit.MockitoJUnitRunner; // Junit 4
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

// @RunWith(MockitoJUnitRunner.class) // Junit 4
@ExtendWith(MockitoExtension.class)
public class DataProcessorTest {
    @Mock
    DataService mockDataService;

    @Test
    public void testProcess() {
        when(mockDataService.retrieveData()).thenReturn(5);

        DataProcessor dataProcessor = new DataProcessor(mockDataService);

        assertEquals(10, dataProcessor.process());
    }
}
