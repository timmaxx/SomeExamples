package timmax.SerializableAndDeserializable.p07;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collections;
import java.util.Map;


public abstract class TransportPackage implements Externalizable {
    private final static String TRANSPORT_PACKAGE_AND_ITS_TYPE =
            "\nTransport package is '%s'. \nType of transport package is '%s'.";
    private final static String KEY_IN_MAP_OF_PARAM_VALUE_DOES_NOT_CONTAINS_KEY_IN_MAP_OF_PARAM_CLASS =
            "\nmapOfParamName_Value does not contains key = '%s'\nmapOfParamName_Value = '%s'\nmapOfParamName_Class = '%s'";
    private final static String PARAMETERS_LIST_IS_EMPTY_BUT_IT_IS_WRONG =
            "\nThere are not any parameters, but they must be %d.";
    private final static String COUNT_OF_PARAMETERS_IN_SPECIFICATION_IS_NOT_EQUAL_COUNT_OF_PARAMETERS_IN_THIS_PACKAGE =
            "\nCount of parameters in specification of protocol is %d and it is not equal count of parameters in package %d.";
    private final static String TYPE_OF_PARAMETER_IN_SPECIFICATION_IS_NOT_EQUAL_TYPE_OF_PARAMETERS_IN_THIS_PACKAGE =
            "\nType of parameter '%s' must be type of '%s'. But received value = '%s' is type of '%s'.\n";

    private MapOfStructOfTransportPackage mapOfStructOfTransportPackage;
    private TypeOfTransportPackage typeOfTransportPackage;
    private Map<String, Object> mapOfParamName_Value;


    public TransportPackage() {
    }

    public TransportPackage(TypeOfTransportPackage typeOfTransportPackage) {
        mapOfStructOfTransportPackage = initMapOfStructOfTransportPackage();
        Map<String, Class<?>> mapOfParamName_Class = mapOfStructOfTransportPackage.getMapParamName_ClassByTypeOfTransportPackage(typeOfTransportPackage);

        if (!mapOfParamName_Class.isEmpty()) {
            String head = String.format(TRANSPORT_PACKAGE_AND_ITS_TYPE, typeOfTransportPackage.getClass(), typeOfTransportPackage);
            String part2 = String.format(PARAMETERS_LIST_IS_EMPTY_BUT_IT_IS_WRONG, mapOfParamName_Class.size());
            throw new RuntimeException(head + part2);
        }

        this.typeOfTransportPackage = typeOfTransportPackage;
        this.mapOfParamName_Value = Collections.emptyMap();
    }

    public TransportPackage(
            TypeOfTransportPackage typeOfTransportPackage,
            Map<String, Object> mapOfParamName_Value) throws MultiGameProtocolException {
        StringBuilder stringBuilder = new StringBuilder();

        // ToDo: Возможно проверку на null можно сделать ч/з аннотацию?
        if (typeOfTransportPackage == null) {
            stringBuilder.append("\nTransportPackage");
            stringBuilder.append("\n public TransportPackage(two params)");
            stringBuilder.append("\n  typeOfTransportPackage is null!");
            // ToDo: Создание исключения с текстом stringBuilder повторяется в коде, но чтобы сделать уменьшить
            //       дублирование кода, нужно либо if, либо 'throw new MultiGameProtocolException' в отдельный метод.
            throw new MultiGameProtocolException(stringBuilder.toString());
        }

        mapOfStructOfTransportPackage = initMapOfStructOfTransportPackage();
        Map<String, Class<?>> mapOfParamName_Class = mapOfStructOfTransportPackage.getMapParamName_ClassByTypeOfTransportPackage(typeOfTransportPackage);

        if (mapOfParamName_Class.size() != mapOfParamName_Value.size()) {
            stringBuilder.append(String.format(TRANSPORT_PACKAGE_AND_ITS_TYPE,
                    typeOfTransportPackage.getClass(), typeOfTransportPackage));
            stringBuilder.append(String.format(COUNT_OF_PARAMETERS_IN_SPECIFICATION_IS_NOT_EQUAL_COUNT_OF_PARAMETERS_IN_THIS_PACKAGE,
                    mapOfParamName_Class.size(), mapOfParamName_Value.size()));
        } else {
/*
            System.out.println("mapOfParamName_Class = " + mapOfParamName_Class);
            System.out.println("mapOfParamName_Value = " + mapOfParamName_Value);
*/
            for (Map.Entry<String, Class<?>> nameParam : mapOfParamName_Class.entrySet()) {
                String paramName = nameParam.getKey();
                Class<?> clazz = nameParam.getValue();
//              System.out.println("paramName = " + paramName);

                if (!mapOfParamName_Value.containsKey(paramName)) {
                    stringBuilder.append(String.format(KEY_IN_MAP_OF_PARAM_VALUE_DOES_NOT_CONTAINS_KEY_IN_MAP_OF_PARAM_CLASS,
                            paramName, mapOfParamName_Value, mapOfParamName_Class));
                    break;
                }

                Object value = mapOfParamName_Value.get(paramName);
/*
                System.out.println("value = " + value);
                System.out.println("value.getClass() = " + value.getClass());
*/
                if ((value.getClass() != String.class || !clazz.isEnum())
                        && (!Classes.isInstanceOf(value, clazz))) {
                    stringBuilder.append(String.format(TRANSPORT_PACKAGE_AND_ITS_TYPE,
                            typeOfTransportPackage.getClass(), typeOfTransportPackage));
                    stringBuilder.append(String.format(TYPE_OF_PARAMETER_IN_SPECIFICATION_IS_NOT_EQUAL_TYPE_OF_PARAMETERS_IN_THIS_PACKAGE,
                            paramName, clazz, value, value.getClass()));
                }
            }
        }

        if (stringBuilder.toString().length() > 0) {
            throw new MultiGameProtocolException(stringBuilder.toString());
        }

        this.typeOfTransportPackage = typeOfTransportPackage;
        this.mapOfParamName_Value = mapOfParamName_Value;
    }

    public TypeOfTransportPackage getTypeOfTransportPackage() {
        return typeOfTransportPackage;
    }

    // На неиспользование этого метода указывает компилятор.
    // И явно этот метод не нужно использовать, т.к. всё равно потом будет вызван get (для чистоты кода).
    // Но если удалить его, то не будет работать JSON десериализация:
    //   Caused by: java.lang.NullPointerException: Cannot invoke "java.util.Map.size()" because "mapOfParamName_Value" is null
    public Map<String, Object> getMapOfParamName_Value() {
        return mapOfParamName_Value;
    }

    public Object get(String paramName) {
        return mapOfParamName_Value.get(paramName);
    }

    abstract MapOfStructOfTransportPackage initMapOfStructOfTransportPackage();

    @Override
    public String toString() {
        return "TransportPackage{" +
                "typeOfTransportPackage=" + typeOfTransportPackage +
                ", mapOfParamName_Value=" + mapOfParamName_Value +
                '}';
    }


    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(typeOfTransportPackage);
        out.writeObject(mapOfParamName_Value);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        typeOfTransportPackage = (TypeOfTransportPackage)in.readObject();
        mapOfParamName_Value = (Map<String, Object>)in.readObject();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransportPackage that = (TransportPackage) o;

        if (typeOfTransportPackage != that.typeOfTransportPackage) return false;
        return mapOfParamName_Value.equals(that.mapOfParamName_Value);
    }

    @Override
    public int hashCode() {
        int result = typeOfTransportPackage.hashCode();
        result = 31 * result + mapOfParamName_Value.hashCode();
        return result;
    }
}