package timmax.SerializableAndDeserializable.p08;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

// Как упростить себе жизнь: удобные юнит-тесты с JUnit и AssertJ
// https://habr.com/ru/companies/skillbox/articles/767804/

// https://assertj.github.io/doc/#assertj-core-assertions-guide

// Демонстрация тестов в Spring Boot
// https://github.com/sendelufa/spring_boot_tests

@DisplayName("GameEventGameOver Test")
public class GameEventGameOverTest {
    @Test
    @DisplayName("Some test 1")
    public void someTest() {
        GameEvent gameEvent = null;// = new GameEventNewGame(2, 3);
        assertEquals(gameEvent, gameEvent);
    }

    @ParameterizedTest
    @CsvSource({"2, 3", "4, 5", "6, 6"})
    @DisplayName("Some test 2")
    public void b(int width, int height) {
        GameEvent gameEvent = new GameEventNewGame(width, height);
        assertEquals(new GameEventNewGame(width, height), gameEvent);
    }

    public static Stream<Arguments> widthAndHeight() {
        return Stream.of(
                Arguments.of(2, 3),
                Arguments.of( 4, 7)
        );
    }

    @ParameterizedTest
    @MethodSource("widthAndHeight")
    @DisplayName("Some test 3")
    public void c(int width, int height) {
        GameEvent gameEvent = new GameEventNewGame(width, height);
        assertEquals(new GameEventNewGame(width, height), gameEvent);
    }

    @Test
    @DisplayName("Some test 5")
    public void e() {
        GameEvent gameEvent = new GameEventNewGame(2, 3);
        assertTrue(!gameEvent.equals(gameEvent), String.format("some text for 5. '%s', %d", "const", 5));
    }

    @Test
    @DisplayName("Some test 6")
    public void f() {
        GameEvent gameEvent = null;//new GameEventNewGame(2, 3);
        assertThat(gameEvent).isNotNull();
    }

    @Test
    void pureJunitTest1() {
        var actual = new BigDecimal("1234.00100");
        var expected = new BigDecimal("1234.001");

        // нам скажут, что числа разные
        assertEquals(expected, actual);
    }

    @Test
    void pureJunitTest2() {
        var actual = new BigDecimal("1234.00100");
        var expected = new BigDecimal("1234.001");

/*        assertTrue(
                String.format("actual=%s, expected=%s", actual, expected),
                actual.compareTo(expected) == 0
        );*/
        assertFalse(
                actual.compareTo(expected) == 0,
                String.format("actual=%s, expected=%s", actual, expected)
                );
    }

    // https://assertj.github.io/doc/#assertj-core-assertions-guide

    // А если использовать AssertJ, то снова можно упростить себе жизнь:
    @Test
    void assertJTest() {
        var actual = new BigDecimal("1234.00100");
        var expected = new BigDecimal("1234.001");

        assertThat(actual).isEqualByComparingTo(expected);
    }
}
