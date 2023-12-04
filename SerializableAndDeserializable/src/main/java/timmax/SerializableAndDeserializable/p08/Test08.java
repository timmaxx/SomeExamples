package timmax.SerializableAndDeserializable.p08;

import java.io.*;
import java.util.Map;

import static timmax.SerializableAndDeserializable.p08.TypeOfTransportPackage.GAME_EVENT;

public class Test08 {
    private static ObjectOutput objectOutput;
    private static ObjectInput objectInput;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        PipedOutputStream outputStream = new PipedOutputStream();
        PipedInputStream inputStream = new PipedInputStream(outputStream);

        objectOutput = new ObjectOutputStream(outputStream);
        objectInput = new ObjectInputStream(inputStream);

        test01();
        System.out.println("==========");
        test02();
    }

    public static void test01() throws IOException, ClassNotFoundException {
        GameEvent gameEvent11 = new GameEventNewGame(5, 565);
        encodeExternalizable(gameEvent11);

        GameEvent gameEvent21 = new GameEventGameOver(GameStatus.DEFEAT);
        encodeExternalizable(gameEvent21);

        GameEvent gameEvent12 = (GameEvent) decodeExternalizable();
        GameEvent gameEvent22 = (GameEvent) decodeExternalizable();

        // true
        System.out.println(gameEvent11.equals(gameEvent11));
        System.out.println(gameEvent12.equals(gameEvent12));
        System.out.println(gameEvent21.equals(gameEvent21));
        System.out.println(gameEvent22.equals(gameEvent22));
        System.out.println(gameEvent11.equals(gameEvent12));
        System.out.println(gameEvent21.equals(gameEvent22));

        // false
        System.out.println(gameEvent11.equals(gameEvent21));
        System.out.println(gameEvent11.equals(gameEvent22));
        System.out.println(gameEvent12.equals(gameEvent21));
        System.out.println(gameEvent12.equals(gameEvent22));
        System.out.println(gameEvent21.equals(gameEvent11));
        System.out.println(gameEvent21.equals(gameEvent12));
        System.out.println(gameEvent22.equals(gameEvent11));
        System.out.println(gameEvent22.equals(gameEvent12));
    }

    public static void test02() throws IOException, ClassNotFoundException {
        RemoteView<Object> remoteView = new RemoteView<>(null, "SokobanMainFieldViewJfx@6fdeec65");
        GameEvent gameEvent = new GameEventNewGame(5, 5);
        TransportPackageOfServer transportPackageOfServer11 = new TransportPackageOfServer(
                GAME_EVENT,
                Map.of( "viewId", remoteView.getViewId(),
                        "gameEvent", gameEvent)
        );
        encodeExternalizable(transportPackageOfServer11);

        RemoteView<Object> remoteView2 = new RemoteView<>(null, "SokobanMainFieldViewJfx@6fdeec99");
        GameEvent gameEvent2 = new GameEventGameOver(GameStatus.VICTORY);
        TransportPackageOfServer transportPackageOfServer21 = new TransportPackageOfServer(
                GAME_EVENT,
                Map.of( "viewId", remoteView2.getViewId(),
                        "gameEvent", gameEvent2)
        );
        encodeExternalizable(transportPackageOfServer21);

        TransportPackageOfServer transportPackageOfServer12 = (TransportPackageOfServer)decodeExternalizable();
        TransportPackageOfServer transportPackageOfServer22 = (TransportPackageOfServer)decodeExternalizable();

        // true
        System.out.println(transportPackageOfServer11.equals(transportPackageOfServer11));
        System.out.println(transportPackageOfServer12.equals(transportPackageOfServer12));
        System.out.println(transportPackageOfServer11.equals(transportPackageOfServer12));
        System.out.println(transportPackageOfServer12.equals(transportPackageOfServer11));
        System.out.println(transportPackageOfServer21.equals(transportPackageOfServer22));
        System.out.println(transportPackageOfServer22.equals(transportPackageOfServer21));

        // false
        System.out.println(transportPackageOfServer11.equals(transportPackageOfServer21));
        System.out.println(transportPackageOfServer11.equals(transportPackageOfServer22));
        System.out.println(transportPackageOfServer12.equals(transportPackageOfServer21));
        System.out.println(transportPackageOfServer12.equals(transportPackageOfServer22));

        // Здесь будет ждать, т.к. в поток записывали два объекта, а читаем уже третий.
        // TransportPackageOfServer transportPackageOfServer32 = (TransportPackageOfServer)decodeExternalizable();
    }

    public static void encodeExternalizable(Externalizable externalizable) throws IOException {
        System.out.println("encodeExternalizable()");
        System.out.println("externalizable = " + externalizable);

        objectOutput.writeObject(externalizable);
        //objectOutput.flush();
        System.out.println("----------");
    }

    public static Externalizable decodeExternalizable() throws IOException, ClassNotFoundException {
        System.out.println("decodeExternalizable()");
        Object o = objectInput.readObject();
        Externalizable externalizable = (Externalizable) o;
        System.out.println("externalizable = " + externalizable);
        System.out.println("----------");
        return externalizable;
    }
}