package timmax.mockito.p05ArgumentMatchers;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserServiceTest {
    @Test
    public void whenUsingAnyMatcher_thenUserIsReturned() {
        UserService mockUserService = Mockito.mock(UserService.class);
        User expectedUser = new User("Alice", 30);

        // Стаббинг с использованием any()
        Mockito.when(mockUserService.findUser(Mockito.anyString(), Mockito.anyInt())).thenReturn(expectedUser);

        // Вызов метода с любыми аргументами
        User result = mockUserService.findUser("Bob", 25);

        // Проверка
        assertEquals(expectedUser, result);
    }

    @Test
    public void whenUsingEqMatcher_thenSpecificUserIsReturned() {
        UserService mockUserService = Mockito.mock(UserService.class);
        User specificUser = new User("Bob", 25);

        // Стаббинг: метод должен быть вызван с конкретными аргументами
        Mockito.when(mockUserService.findUser(Mockito.eq("Bob"), Mockito.eq(25))).thenReturn(specificUser);

        // Вызов метода с конкретными аргументами
        User result = mockUserService.findUser("Bob", 25);

        // Проверка
        assertEquals(specificUser, result);
    }

    @Test
    public void verifyWithArgumentMatchers() {
        // Создание мока
        UserService mockUserService = Mockito.mock(UserService.class);

        // Вызов метода
        mockUserService.findUser("Alice", 30);

        // Верификация: был ли метод вызван с определенными аргументами
        Mockito.verify(mockUserService).findUser(Mockito.eq("Alice"), Mockito.eq(30));
    }
}
