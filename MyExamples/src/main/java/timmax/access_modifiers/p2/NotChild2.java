package timmax.access_modifiers.p2;

import timmax.access_modifiers.Parent;

public class NotChild2 {
    public static void main(String[] args) {
        Parent parent = new Parent();

        parent.publicVar = 10;
        // parent.protectedVar = 20;
        // parent.defaultVar = 30;
        // object.privateVar = 40;          // Ошибка компиляции!

        parent.publicAccessMethod();
        // parent.protectedAccessMethod();
        // parent.defaultAccessMethod();
        // object.privateAccessMethod();    // Ошибка компиляции!
    }
}