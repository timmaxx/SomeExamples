package timmax.mockito.p07Annotation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class DataServiceTest {
    @Mock
    DataService mockDataService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveData() {
        Mockito.when(mockDataService.retrieveData()).thenReturn(5);
        assertEquals(5, mockDataService.retrieveData());
    }
}