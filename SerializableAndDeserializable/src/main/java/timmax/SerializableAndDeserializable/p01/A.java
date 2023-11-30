package timmax.SerializableAndDeserializable.p01;

import java.io.Serializable;

public class A implements Serializable {
    private C c;
    private B b;
    public void setC(C c) {this.c = c;}
    public void setB(B b) {this.b = b;}
    public C getC() {return c;}
    public B getB() {return b;}
}
