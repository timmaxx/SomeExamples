package timmax.access_modifiers.p2;

import timmax.access_modifiers.Parent;

public class Child2 extends Parent {
    public void someMethod() {
        publicVar = 10;
        protectedVar = 30;
        // defaultVar = 20;
        // privateVar = 40;         // Ошибка компиляции!

        publicAccessMethod();
        protectedAccessMethod();
        // defaultAccessMethod();
        // privateAccessMethod();   // Ошибка компиляции!
    }
}
