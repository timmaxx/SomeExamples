package timmax.patterns.command.wikipedia.nullobject;

//  https://ru.wikipedia.org/wiki/Null_object_(%D1%88%D0%B0%D0%B1%D0%BB%D0%BE%D0%BD_%D0%BF%D1%80%D0%BE%D0%B5%D0%BA%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D1%8F)
public class Main {
    public static void main(String[] args) {
        AbstractEntity realEntity = new RealEntity();
        realEntity.doSomething(); // RealEntity::doSomething

        AbstractEntity unknownEntity = new NullEntity();
        unknownEntity.doSomething(); // no output
    }
}
