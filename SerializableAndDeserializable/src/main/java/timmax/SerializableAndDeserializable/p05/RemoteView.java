package timmax.SerializableAndDeserializable.p05;

import java.util.Objects;

// В экземпляре этого класса будет сохранятся идентификатор клиента и строковый идентификатор выборки,
// которой нужно отправить то или иное сообщение об игровом событии.
public class RemoteView<T> {
    private final T clientId;
    private final String viewId;


    public RemoteView(T clientId, String viewId) {
        this.clientId = clientId;
        this.viewId = viewId;
    }

    public T getClientId() {
        return clientId;
    }

    public String getViewId() {
        return viewId;
    }

    @Override
    public String toString() {
        return "RemoteView{" +
                "clientId=" + clientId +
                ", viewId='" + viewId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RemoteView<?> that = (RemoteView<?>) o;

        if (!Objects.equals(clientId, that.clientId)) return false;
        return viewId.equals(that.viewId);
    }

    @Override
    public int hashCode() {
        int result = clientId != null ? clientId.hashCode() : 0;
        result = 31 * result + viewId.hashCode();
        return result;
    }
}