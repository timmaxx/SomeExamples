package timmax.SerializableAndDeserializable.p04;


import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class A implements Externalizable {
    private C c;
    private B b;
    public void setC(C c) {this.c = c;}
    public void setB(B b) {this.b = b;}
    public C getC() {return c;}
    public B getB() {return b;}

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

    }
}
