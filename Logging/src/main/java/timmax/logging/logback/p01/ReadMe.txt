Эти примеры взяты из
https://www.baeldung.com/logback

Сначала я реализовывал примеры
timmax.logging.slf4j.p0Х
И в т.ч. добавлял в classpath другого провайдера (slf4j-simple-2.0.6)

Первое, что я сделал в этом примере - это дописал в pom.xml ещё две зависимости:
       <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-core</artifactId>
            <version>${logback-version}</version>
        </dependency>
        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-classic</artifactId>
            <version>${logback-version}</version>
        </dependency>

При попытке запуска примера получился конфликт провайдеров:

SLF4J(W): Class path contains multiple SLF4J providers.
SLF4J(W): Found provider [ch.qos.logback.classic.spi.LogbackServiceProvider@25f38edc]
SLF4J(W): Found provider [org.slf4j.simple.SimpleServiceProvider@1a86f2f1]
SLF4J(W): See https://www.slf4j.org/codes.html#multiple_bindings for an explanation.
SLF4J(I): Actual provider is of type [ch.qos.logback.classic.spi.LogbackServiceProvider@25f38edc]
15:21:25.838 [main] INFO timmax.logging.logback.p01.Example -- Example log from Example

Устраним конфликт через удаление другого провайдера логирования (slf4j-simple-2.0.6)
File - Project structure - Library
Выделяю
slf4j-simple-2.0.6
Удалю его.

При попытке запуска примера больше нет конфликта провайдеров:

15:26:21.273 [main] INFO timmax.logging.logback.p01.Example -- Example log from Example

Примечание:
Файл logback.xml разместил в ресурсах в аналогичном для выполнения каталоге. И попробовал этот каталог указать в
classpath. Но я не увидел, что этот файл используется.

Все вышеперечисленные действия относятся к разделам с 1 по 4 ссылки https://www.baeldung.com/logback.