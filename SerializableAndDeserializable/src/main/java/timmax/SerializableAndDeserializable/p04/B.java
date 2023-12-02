package timmax.SerializableAndDeserializable.p04;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class B implements Externalizable {
    private C c;
    public void setC(C c) {this.c = c;}
    public C getC() {return c;}

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

    }
}
