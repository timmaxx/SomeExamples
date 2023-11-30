package timmax.SerializableAndDeserializable.p03;

import java.io.Serializable;
import java.util.Map;

public class TransportPackageOfServer extends TransportPackage implements Serializable {
    private static MapOfStructOfTransportPackageOfServer mapOfStructOfTransportPackageOfServer;


    public TransportPackageOfServer(TypeOfTransportPackage typeOfTransportPackage) {
        super(typeOfTransportPackage);
    }

    //@JsonCreator(mode = PROPERTIES)
    public TransportPackageOfServer(
            TypeOfTransportPackage typeOfTransportPackage,
            Map<String, Object> mapOfParamName_Value) {
        super(typeOfTransportPackage, mapOfParamName_Value);
    }

    @Override
    MapOfStructOfTransportPackage initMapOfStructOfTransportPackage() {
        if (mapOfStructOfTransportPackageOfServer == null) {
            mapOfStructOfTransportPackageOfServer = new MapOfStructOfTransportPackageOfServer();
        }
        return mapOfStructOfTransportPackageOfServer;
    }
}