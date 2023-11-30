package timmax.SerializableAndDeserializable.p03;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.Map;

import static timmax.SerializableAndDeserializable.p03.TypeOfTransportPackage.GAME_EVENT;

public class Test03 {
    private final static ObjectMapper mapper = new ObjectMapper();

    private final static ByteArrayOutputStream baos = new ByteArrayOutputStream();
    private final static ObjectOutputStream oos;

    static {
        try {
            oos = new ObjectOutputStream(baos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

//        encodeGameEvent();

        encodeTransportPackageOfServer();
        decodeTransportPackageOfServer();

    }

    public static void encodeTransportPackageOfServer() throws IOException {

        RemoteView<Object> remoteView = new RemoteView<>(null, "SokobanMainFieldViewJfx@6fdeec65");
        GameEvent gameEvent = new GameEventNewGame(5, 5);

        TransportPackageOfServer transportPackageOfServer = new TransportPackageOfServer(
                GAME_EVENT,
                Map.of( "viewId", remoteView.getViewId(),
                        "gameEvent", gameEvent)
        );

        oos.writeObject(transportPackageOfServer);
        oos.flush();
        oos.close();
        System.out.println(oos);
        System.out.println(baos);
/*
        StringWriter writer = new StringWriter();
        mapper.writeValue(writer, transportPackageOfServer);
*/
//        send(writer.toString());
/*
        return writer.toString();
        */
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

    public static void decodeTransportPackageOfServer() throws IOException, ClassNotFoundException {
        System.out.println("public class Test02");
        System.out.println("public static void recive(String serializePacket)");

        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
        System.out.println(1);
        TransportPackageOfServer transportPackageOfServer2 = (TransportPackageOfServer)ois.readObject();
        System.out.println(2);

        System.out.println(transportPackageOfServer2);

        TypeOfTransportPackage typeOfTransportPackage2 = transportPackageOfServer2.getTypeOfTransportPackage();
        System.out.println(typeOfTransportPackage2);
    }
}
