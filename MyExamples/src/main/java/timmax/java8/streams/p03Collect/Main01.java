package timmax.java8.streams.p03Collect;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main01 {
    public static void main(String[] args) {
        List<Person> persons =
                Arrays.asList(
                        new Person("Andrew", 20),
                        new Person("Igor", 23),
                        new Person("Ira", 23),
                        new Person("Vitia", 12)
                );

        //  1.
        List<Person> filtered = persons
                .stream()
                .filter(p -> p.name.startsWith("I"))
                .collect(Collectors.toList());
        System.out.println(filtered);    // [Igor, Ira]

        //  2.  Следующий пример группирует всех по возрасту:
        Map<Integer, List<Person>> personsByAge = persons
                .stream()
                .collect(Collectors.groupingBy(p -> p.age));
        personsByAge
                .forEach((age, p) -> System.out.format("age %s: %s\n", age, p));
        // age 20: [Andrew]
        // age 23: [Igor, Ira]
        // age 12: [Vitia]

        //  3.  Можно создавать группы элементов потока, например,
        //  определение среднего возраста всех лиц:
        Double averageAge = persons
                .stream()
                .collect(Collectors.averagingInt(p -> p.age));
        System.out.println(averageAge);     // 19.5

        //  4.  Мы можем просто определить минимальный, максимальный и средний арифметический возраст,
        //  а также найти сумму и количество.
        IntSummaryStatistics ageSummary = persons
                .stream()
                .collect(Collectors.summarizingInt(p -> p.age));

        System.out.println(ageSummary);
        // Результат выполнения:
        // IntSummaryStatistics{count=4, sum=78, min=12, average=19.500000, max=23}

        //  5.  Следующий пример соединяет всех людей в одну строку:
        String phrase = persons
                .stream()
                .filter(p -> p.age >= 18)
                .map(p -> p.name)
                //  Коллектор join принимает разделитель, а также дополнительный префикс и суффикс.
                .collect(Collectors.joining(" и ", "В Германии ", " совершеннолетние."));
        System.out.println(phrase);
        // В Германии Andrew и Igor и Ira совершеннолетние.

        //  6.  Для того чтобы трансформировать элементы потока в map, мы должны указать,
        //  как ключи и значения должны быть нанесены на map.

        Map<Integer, String> map = persons
                .stream()
                .collect(Collectors.toMap(
                        p -> p.age,
                        p -> p.name
                        //  Имейте в виду, что замапенные ключи должны быть уникальными,
                        //  иначе IllegalStateException не избежать.
                        //  Вы можете передать функцию слияния в качестве дополнительного параметра,
                        //  чтобы обойти исключение:
                        , (name1, name2) -> name1 + ";" + name2
                ));
        System.out.println(map);
        // {20=Andrew, 23=Igor;Ira, 12=Vitya}

        //  7.  Теперь, когда мы знаем, некоторые мощные встроенные коллекторы,
        //  давайте попробуем построить свой собственный специальный коллектор.
        //  Мы хотим превратить всех людей в потоке в одну строку,
        //  состоящую из всех имен в верхнем регистре, разделенных знаком "|".
        //  Для достижения этого мы создаем новый коллектор через Collector.of().
        //  Мы должны пройти четыре этапа использования collectors:
        //  supplier, accumulator, combiner и finisher.
        //  public interface Collector<T, A, R>
        Collector<Person, StringJoiner, String> personNameCollector =
                /*
                public static<T, A, R> Collector<T, A, R> of(
                    Supplier<A> supplier,
                    BiConsumer<A, T> accumulator,
                    BinaryOperator<A> combiner,
                    Function<A, R> finisher,
                    Characteristics... characteristics)
                */
                Collector.of(
                        //  Так как строки в Java неизменные, нам нужен вспомогательный класс StringJoiner,
                        //  чтобы коллектор мог построить нашу строку.
                        //  Supplier изначально создает такой StringJoiner с соответствующим разделителем.
                        () -> new StringJoiner(" | "),  // supplier
                        //  Accumulator используется для добавления имени каждого человека в верхний регистр.
                        (j, p) -> j.add(p.name.toUpperCase()),  // accumulator
                        //  Combiner знает как объединить два StringJoiner в один.
                        (j1, j2) -> j1.merge(j2),               // combiner
                        //  На последнем этапе Finisher строит желаемую строку из StringJoiner.
                        StringJoiner::toString);                // finisher
        String names = persons
                .stream()
                .collect(personNameCollector);
        System.out.println(names);  // ANDREW | IGOR | IRA | VITIA
    }
}
