package timmax.SerializableAndDeserializable.p02;

import java.util.Collections;
import java.util.Map;

public abstract class MapOfStructOfTransportPackage {
    private final Map<TypeOfTransportPackage, Map<String, Class<?>>> mapOfUniversalType;


    public MapOfStructOfTransportPackage(Map<TypeOfTransportPackage, Map<String, Class<?>>> mapOfUniversalType) {
        this.mapOfUniversalType = Collections.unmodifiableMap(mapOfUniversalType);
    }

    public Map<String, Class<?>> getMapParamName_ClassByTypeOfTransportPackage(TypeOfTransportPackage typeOfTransportPackage) {
        if (!mapOfUniversalType.containsKey(typeOfTransportPackage)) {
            throw new RuntimeException("There aren't key = '" + typeOfTransportPackage + "' in mapOfUniversalType.");
        }

        return mapOfUniversalType.get(typeOfTransportPackage);
    }
}