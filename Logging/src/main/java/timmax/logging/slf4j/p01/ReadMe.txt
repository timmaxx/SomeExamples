https://www.slf4j.org/manual.html

Если сделать только настройку pom.xml и выполнить HelloWord. Получим:

SLF4J(W): No SLF4J providers were found.
SLF4J(W): Defaulting to no-operation (NOP) logger implementation
SLF4J(W): See https://www.slf4j.org/codes.html#noProviders for further details.

Добавим в classpath провайдера:
File - Project structure - Library
У меня уже в этом перечне была библиотека: Maven: org.slf4j:slf4j-api:2.0.102
Maven - говорит, что добавление сделано через pom.xml
Сначала пробую добавить провайдер slf4j-nop-xxx.jar
C:\Users\Максим\.m2\repository\org\slf4j\slf4j-nop\2.0.9\slf4j-nop-2.0.9.jar
Библиотека добавилась:
slf4j-nop-2.0.9
Префикса Maven нет, и это значит, что pom.xml не затронут и путь к библиотеке добавлен в classpath.
Выполняем HelloWord. Получим:

[Нет никакого вывода]

В имени slf4j-nop-2.0.9 'nop' - no-operation. Т.е. молча отбрасывающий все записи журналирования.

Пробуем добавить ещё один провайдер не удаляя slf4j-nop-2.0.9, например этот:
C:\Users\Максим\.m2\repository\org\slf4j\slf4j-simple\2.0.6\slf4j-simple-2.0.6.jar
Выполняем HelloWord. Получим:

SLF4J(W): Class path contains multiple SLF4J providers.
SLF4J(W): Found provider [org.slf4j.nop.NOPServiceProvider@5a10411]
SLF4J(W): Found provider [org.slf4j.simple.SimpleServiceProvider@2ef1e4fa]
SLF4J(W): See https://www.slf4j.org/codes.html#multiple_bindings for an explanation.
SLF4J(I): Actual provider is of type [org.slf4j.nop.NOPServiceProvider@5a10411]

Т.е. есть конфликт двух провайдеров.
Удаляю библиотеку slf4j-nop-2.0.9.
Выполняем HelloWord. Получим:

[main] INFO timmax.logging.slf4j.p01.HelloWorld - Hello World