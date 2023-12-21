package timmax.mockito.p02;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceTest {
    @Test
    public void whenThenReturnExample() {
        CalculatorService calculatorService = Mockito.mock(CalculatorService.class);

        // Стаббинг: определение поведения
        Mockito.when(calculatorService.add(10.0, 20.0)).thenReturn(30.0);

        // Проверка: метод add возвращает 30.0
        assertEquals(30.0, calculatorService.add(10.0, 20.0), 0.01);
    }

    @Test
    public void doReturnWhenExample() {
        CalculatorService calculatorService = Mockito.mock(CalculatorService.class);

        // Стаббинг с использованием doReturn-when
        Mockito.doNothing().when(calculatorService).printSum(10.0, 20.0);

        // Вызов метода
        calculatorService.printSum(10.0, 20.0);

        // Верификация: метод был вызван с заданными параметрами
        Mockito.verify(calculatorService).printSum(10.0, 20.0);
    }
}