package headfirst.designpatterns.timmax.chapter10.timmax.p09.coinreceiver;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.coinreceiver.implement.StateContextOfCoinReceiver;

public class CoinReceiverTestDrive {
    public static void main(String[] args) {
        StateContextOfCoinReceiver coinReceiver = new StateContextOfCoinReceiver();

        System.out.println(coinReceiver);
        System.out.println("----");

        coinReceiver.ejectCoin();
        System.out.println(coinReceiver);
        System.out.println("----");

        coinReceiver.insertCoin();
        System.out.println(coinReceiver);
        coinReceiver.insertCoin();
        System.out.println(coinReceiver);
        coinReceiver.ejectCoin();
        System.out.println(coinReceiver);
        System.out.println("----");

        coinReceiver.insertCoin();
        System.out.println(coinReceiver);
        coinReceiver.acceptCoin();
        System.out.println(coinReceiver);
        System.out.println("----");

        coinReceiver.insertCoin();
        System.out.println(coinReceiver);
        coinReceiver.acceptCoin();
        System.out.println(coinReceiver);
        System.out.println("----");

        coinReceiver.insertCoin();
        System.out.println(coinReceiver);
        coinReceiver.acceptCoin();
        System.out.println(coinReceiver);
        System.out.println("----");

        coinReceiver.insertCoin();
        System.out.println(coinReceiver);
        coinReceiver.acceptCoin();
        System.out.println(coinReceiver);
        System.out.println("----");

        coinReceiver.insertCoin();
        System.out.println(coinReceiver);
        System.out.println("----");

        coinReceiver.pullOutAllCoins();
        System.out.println(coinReceiver);
        System.out.println("----");
    }
}
