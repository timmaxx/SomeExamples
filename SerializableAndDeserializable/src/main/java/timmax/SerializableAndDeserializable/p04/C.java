package timmax.SerializableAndDeserializable.p04;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class C implements Externalizable {
    private A a;
    private B b;
    public void setA(A a) {this.a = a;}
    public void setB(B b) {this.b = b;}
    public B getB() {return b;}
    public A getA() {return a;}

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

    }
}
