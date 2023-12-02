package timmax.SerializableAndDeserializable.p05;

import java.io.*;

public class Test05 {
    private static ObjectOutput ooExt;
    private static ObjectInput oiExt;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        OutputStream outputStream = new FileOutputStream("./contExt3.ser");
        ooExt = new ObjectOutputStream(outputStream);

        InputStream inputStream = new FileInputStream("./contExt3.ser");
        oiExt = new ObjectInputStream(inputStream);

        GameEvent gameEvent11 = new GameEventNewGame(5, 565);
        encodeExternalizable(gameEvent11);
/*
        GameEvent gameEvent21 = new GameEventGameOver(GameStatus.DEFEAT);
        encodeExternalizable(gameEvent21);
*/
        GameEvent gameEvent12 = (GameEvent)decodeExternalizable();
//        GameEvent gameEvent22 = (GameEvent)decodeExternalizable();

        // true
        System.out.println(gameEvent11.equals(gameEvent12));
/*
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
*/
/*
        RemoteView<Object> remoteView = new RemoteView<>(null, "SokobanMainFieldViewJfx@6fdeec65");
        GameEvent gameEvent = new GameEventNewGame(5, 5);
        TransportPackageOfServer transportPackageOfServer11 = new TransportPackageOfServer(
                GAME_EVENT,
                Map.of( "viewId", remoteView.getViewId(),
                        "gameEvent", gameEvent)
        );
        encodeExternalizable(transportPackageOfServer11);

        Externalizable externalizable12 = decodeExternalizable();
        // System.out.println("externalizable12.getClass() = " + externalizable12.getClass());
        TransportPackageOfServer transportPackageOfServer12 = (TransportPackageOfServer)externalizable12;


        RemoteView<Object> remoteView2 = new RemoteView<>(null, "SokobanMainFieldViewJfx@6fdeec65");
        GameEvent gameEvent2 = new GameEventGameOver(GameStatus.VICTORY);
        TransportPackageOfServer transportPackageOfServer21 = new TransportPackageOfServer(
                GAME_EVENT,
                Map.of( "viewId", remoteView2.getViewId(),
                        "gameEvent", gameEvent2)
        );
        encodeExternalizable(transportPackageOfServer21);

        TransportPackageOfServer transportPackageOfServer22 = (TransportPackageOfServer)decodeExternalizable();

        // true
        System.out.println(transportPackageOfServer11.equals(transportPackageOfServer12));
        System.out.println(transportPackageOfServer21.equals(transportPackageOfServer22));

        // false
        System.out.println(transportPackageOfServer11.equals(transportPackageOfServer21));
*/
    }

    public static void encodeExternalizable(Externalizable externalizable) throws IOException {
        System.out.println("public class Test02");
        System.out.println("encodeExternalizable()");
        System.out.println("externalizable = " + externalizable);

        ooExt.writeObject(externalizable);
        ooExt.flush();
        System.out.println("----------");
    }

    public static Externalizable decodeExternalizable() throws IOException, ClassNotFoundException {
        System.out.println("public class Test02");
        System.out.println("decodeExternalizable()");
        Object o = oiExt.readObject();
        Externalizable externalizable = (Externalizable)o;
        System.out.println("externalizable = " + externalizable);
        System.out.println("----------");
        return externalizable;
    }
}