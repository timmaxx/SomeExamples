package timmax.mockito.p06Spying;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListManagerTest {
    @Test
    public void spyExample() {
        ListManager spyListManager = Mockito.spy(new ListManager());

        // Использование реального метода
        List<String> list = spyListManager.createList();
        list.add("Item");

        // Переопределение поведения метода getListSize
        Mockito.when(spyListManager.getListSize(list)).thenReturn(100);

        // Тестирование
        int size = spyListManager.getListSize(list);

        // Проверка
        assertEquals(100, size);
    }

    @Test
    public void verifySpy() {
        // Создание спай-объекта
        ListManager spyListManager = Mockito.spy(new ListManager());

        // Вызов метода
        List<String> list = spyListManager.createList();
        list.add("Item");
        spyListManager.getListSize(list);

        // Верификация вызова метода
        Mockito.verify(spyListManager).getListSize(list);
    }
}
