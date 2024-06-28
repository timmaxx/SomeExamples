package timmax.access_modifiers;

// Модификаторы доступа
// https://www.examclouds.com/ru/java/java-core-russian/upravlenie-dostupom#:~:text=%D0%A3%D1%80%D0%BE%D0%B2%D0%B5%D0%BD%D1%8C%20%D0%B4%D0%BE%D1%81%D1%82%D1%83%D0%BF%D0%B0%20protected%20%D0%B8%D1%81%D0%BF%D0%BE%D0%BB%D1%8C%D0%B7%D1%83%D0%B5%D1%82%D1%81%D1%8F%20%D0%BF%D1%80%D0%B8,%D0%BF%D0%B0%D0%BA%D0%B5%D1%82%D0%B5%20%D0%B8%D0%BB%D0%B8%20%D0%B4%D0%BB%D1%8F%20%D0%BA%D0%BB%D0%B0%D1%81%D1%81%D0%BE%D0%B2%20%D0%BD%D0%B0%D1%81%D0%BB%D0%B5%D0%B4%D0%BD%D0%B8%D0%BA%D0%BE%D0%B2.
public class Parent {
    public      int publicVar;      // открытый уровень доступа
    protected   int protectedVar;
                int defaultVar;     // уровень доступа по умолчанию (package-private)
    private     int privateVar;     // закрытый уровень доступа


    public Parent() {
        publicVar = 1;
        protectedVar = 2;
        defaultVar = 3;
        privateVar = 4;

        publicAccessMethod();
        protectedAccessMethod();
        defaultAccessMethod();
        privateAccessMethod();
    }

    public      void publicAccessMethod() {
    }

    // package-private
                void defaultAccessMethod() {
    }

    protected   void protectedAccessMethod() {
    }

    private     void privateAccessMethod() {
    }

    @Override
    public String toString() {
        return "Parent{"
                +   "publicVar = "    + publicVar
                + ", protectedVar = " + protectedVar
                + ", defaultVar = "   + defaultVar
                + ", privateVar = "   + privateVar
                + '}';
    }
}
