package timmax.polymorphism.p02;

public class AAA extends AA {
    protected int a;
    public AAA(int a) {
        super(a);
        this.a = 20;
    }

    @Override
    public String toString() {
        return "AAA{" +
                super.toString() +
                // "super.super.a=" + super.super.a +
                "super.a=" + super.a +
                ", a=" + a +
                '}';
    }
}
