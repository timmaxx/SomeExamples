package timmax.mockito.p07Annotation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListManagerTest {
    @Spy
    ListManager spyListManager;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetListSize() {
        List<String> list = new ArrayList<>(Arrays.asList("item1", "item2"));
        Mockito.doReturn(100).when(spyListManager).getListSize(list);
        assertEquals(100, spyListManager.getListSize(list));
    }
}
