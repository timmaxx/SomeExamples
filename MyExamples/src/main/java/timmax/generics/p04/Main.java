package timmax.generics.p04;

import java.util.List;

//  https://skillbox.ru/media/code/dzheneriki-v-java-dlya-tekh-kto-postarshe/
public class Main {
    public void testUpperBounding(List<? extends Paper> list) {
        Paper p = list.get(0); // OK
        Garbage g = list.get(1); // OK
        // CoolPaper sp = list.get(2); // не скомпилируется
        // list.add(new Paper()); // не скомпилируется
        list.add(null); // OK
    }

    public void testLowBounding(List<? super Paper> list) {
        // Paper p = list.get(0); // не скомпилируется
        // Garbage g = list.get(1); // не скомпилируется
        Object o = list.get(2); // OK
        // list.add(new Garbage()); // не скомпилируется
        list.add(new Paper()); // OK
        list.add(new CoolPaper()); // OK
    }
}
