package timmax.polymorphism.p02;

public class AA extends A {
    protected int a;
    public AA(int a) {
        super(a);
        this.a = 10;
    }

    @Override
    public String toString() {
        return "AA{" +
                super.toString() +
                "super.a=" + super.a +
                ", a=" + a +
                '}';
    }
}
