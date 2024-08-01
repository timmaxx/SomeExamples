package timmax.access_modifiers;

public class NotChild1 {
    public static void main(String[] args) {
        Parent object = new Parent();

        object.publicVar = 10;
        object.protectedVar = 20;
        object.defaultVar = 30;
        // object.privateVar = 40;          // Ошибка компиляции!

        object.publicAccessMethod();
        object.protectedAccessMethod();
        object.defaultAccessMethod();
        // object.privateAccessMethod();    // Ошибка компиляции!
    }
}
