package timmax.SerializableAndDeserializable.p02;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import static timmax.SerializableAndDeserializable.p02.TypeOfTransportPackage.GAME_EVENT;

public class Test02 {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {

        encodeGameEvent();

        String serializePacket = encodeTransportPackageOfServer();
        decodeTransportPackageOfServer(serializePacket);

    }

    public static String encodeTransportPackageOfServer() throws IOException {
        RemoteView<Object> remoteView = new RemoteView<>(null, "SokobanMainFieldViewJfx@6fdeec65");
        GameEvent gameEvent = new GameEventNewGame(5, 5);

        TransportPackageOfServer transportPackageOfServer = new TransportPackageOfServer(
                GAME_EVENT,
                Map.of( "viewId", remoteView.getViewId(),
                        "gameEvent", gameEvent)
        );

        StringWriter writer = new StringWriter();
        mapper.writeValue(writer, transportPackageOfServer);
        send(writer.toString());

        return writer.toString();
    }

    public static String encodeGameEvent() throws IOException {
        GameEvent gameEvent = new GameEventNewGame(5, 5);

        StringWriter writer = new StringWriter();
        mapper.writeValue(writer, gameEvent);
        send(writer.toString());

        return writer.toString();
    }

    public static void send(String message) {
        System.out.println("public class Test02");
        System.out.println("public static String send()");

        System.out.println("message. Begin");
        System.out.println(message);
        System.out.println("message. End");
        System.out.println("----------");
    }

    public static void decodeTransportPackageOfServer(String serializePacket) throws JsonProcessingException {
        System.out.println("public class Test02");
        System.out.println("public static void recive(String serializePacket)");

        TransportPackageOfServer transportPackageOfServer = mapper.readValue(serializePacket, TransportPackageOfServer.class);
        System.out.println(transportPackageOfServer);

        TypeOfTransportPackage typeOfTransportPackage = transportPackageOfServer.getTypeOfTransportPackage();
        System.out.println(typeOfTransportPackage);

/*
        if (typeOfTransportPackage == LOGOUT) {
            onLogout(transportPackageOfServer);
        } else if (typeOfTransportPackage == LOGIN) {
            onLogin(transportPackageOfServer);
        } else if (typeOfTransportPackage == FORGET_GAME_TYPE_SET) {
            onForgetGameTypeSet(transportPackageOfServer);
        } else if (typeOfTransportPackage == GET_GAME_TYPE_SET) {
            onGetGameTypeSet(transportPackageOfServer);
        } else if (typeOfTransportPackage == FORGET_GAME_TYPE) {
            onForgetGameType(transportPackageOfServer);
        } else if (typeOfTransportPackage == SELECT_GAME_TYPE) {
            onSelectGameType(transportPackageOfServer);
        } else if (typeOfTransportPackage == ADD_VIEW) {
            onAddView(transportPackageOfServer);
        } else {
            System.err.println("Client doesn't know received typeOfTransportPackage.");
            System.err.println("typeOfTransportPackage = " + typeOfTransportPackage);
            System.exit(1);
        }
*/
    }
}
