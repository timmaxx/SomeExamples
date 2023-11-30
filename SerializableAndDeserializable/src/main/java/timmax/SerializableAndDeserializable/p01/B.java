package timmax.SerializableAndDeserializable.p01;

import java.io.Serializable;

public class B implements Serializable {
    private C c;
    public void setC(C c) {this.c = c;}
    public C getC() {return c;}
}
