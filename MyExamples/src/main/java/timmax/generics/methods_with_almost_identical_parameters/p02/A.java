package timmax.generics.methods_with_almost_identical_parameters.p02;

public abstract class A {
    protected C1 someSet1;
    protected C2 someSet2;

    public A(C1 someSet1) {
        this.someSet1 = someSet1;
    }

    public A(C2 someSet2) {
        this.someSet2 = someSet2;
    }
}
