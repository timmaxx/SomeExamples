package headfirst.designpatterns.timmax.chapter10.timmax.p09.coinreceiver;

public interface IStateOfCoinReceiver {
    void insertCoin();
    void ejectCoin();
    void acceptCoin();
    void pullOutAllCoins();
}
