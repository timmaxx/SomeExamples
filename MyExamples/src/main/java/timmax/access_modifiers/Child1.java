package timmax.access_modifiers;

public class Child1 extends Parent {
    public void someMethod() {
        publicVar = 10;
        protectedVar = 20;
        defaultVar = 30;
        // privateVar = 40;         // Ошибка компиляции!

        publicAccessMethod();
        protectedAccessMethod();
        defaultAccessMethod();
        // privateAccessMethod();   // Ошибка компиляции!
    }
}
