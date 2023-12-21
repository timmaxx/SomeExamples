package timmax.mockito.p03;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class OrderServiceTest {
    @Test
    public void verifyMethodCall() {
        // Создание мока
        OrderService orderService = Mockito.mock(OrderService.class);

        // Создание тестового заказа
        Order testOrder = new Order("TestItem", 3);

        // Имитация вызова метода
        orderService.placeOrder(testOrder);

        // Верификация: был ли вызван метод placeOrder с testOrder
        Mockito.verify(orderService).placeOrder(testOrder);
    }

    @Test
    public void verifyNumberOfMethodCalls() {
        OrderService orderService = Mockito.mock(OrderService.class);

        // Имитация вызовов
        orderService.placeOrder(new Order("Item1", 1));
        orderService.placeOrder(new Order("Item2", 2));

        // orderService.getOrderCount();

        // Верификация: метод placeOrder был вызван дважды
        Mockito.verify(orderService, Mockito.times(2)).placeOrder(Mockito.any(Order.class));

        // Верификация: метод getOrderCount ни разу не был вызван
        Mockito.verify(orderService, Mockito.never()).getOrderCount();
    }
}
