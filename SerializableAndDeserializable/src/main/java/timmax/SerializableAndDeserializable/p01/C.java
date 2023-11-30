package timmax.SerializableAndDeserializable.p01;

import java.io.Serializable;

public class C implements Serializable {
    private A a;
    private B b;
    public void setA(A a) {this.a = a;}
    public void setB(B b) {this.b = b;}
    public B getB() {return b;}
    public A getA() {return a;}
}
