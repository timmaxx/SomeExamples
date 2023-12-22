package timmax.mockito.p07Annotation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataProcessorTest {
    @Mock
    DataService mockDataService;

    @InjectMocks
    DataProcessor dataProcessor;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testProcess() {
        Mockito.when(mockDataService.retrieveData()).thenReturn(5);
        assertEquals(10, dataProcessor.process());
    }
}
