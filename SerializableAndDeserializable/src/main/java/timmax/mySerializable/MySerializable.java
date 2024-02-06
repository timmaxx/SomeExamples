package timmax.mySerializable;

import java.io.*;
import java.lang.reflect.Constructor;

public interface MySerializable extends Serializable {
    /**
     * The object implements the writeExternal method to save its contents
     * by calling the methods of DataOutput for its primitive values or
     * calling the writeObject method of ObjectOutput for objects, strings,
     * and arrays.
     *
     * @serialData Overriding methods should use this tag to describe
     *             the data layout of this Externalizable object.
     *             List the sequence of element types and, if possible,
     *             relate the element to a public/protected field and/or
     *             method of this Externalizable class.
     *
     * @param     out the stream to write the object to
     * @throws IOException Includes any I/O exceptions that may occur
     */
    void writeExternal(ObjectOutput out) throws IOException;

    /**
     * The object implements the readExternal method to restore its
     * contents by calling the methods of DataInput for primitive
     * types and readObject for objects, strings and arrays.  The
     * readExternal method must read the values in the same sequence
     * and with the same types as were written by writeExternal.
     *
     * @param     in the stream to read data from in order to restore the object
     * @throws    IOException if I/O errors occur
     * @throws    ClassNotFoundException If the class for an object being
     *            restored cannot be found.
     */
    /*
    void readExternal(ObjectInput in) throws IOException, ClassNotFoundException;
    */


    static MySerializable r(ObjectInput in, Class clazz) throws NoSuchMethodException {
        MySerializable result = null;
        Constructor<?> constructor = clazz.getConstructor(Object[].class);

        // ObjectStreamClass objectStreamClass;
        // throw new InvalidClassException();

        return result;
    }
}
