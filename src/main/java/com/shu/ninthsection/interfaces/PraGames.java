package com.shu.ninthsection.interfaces;

/**
 * Created by Administrator on 2017-05-20.
 */
public class PraGames {

    public static void service(ServiceGameFactory sf){
        ServiceGame sg = sf.getServiceGame();
        sg.does();
    }

    public static void main(String[] args) {
        service(new CoinServiceGameFactory());
        service(new ShareServiceGameFactory());
    }
}

interface ServiceGame {
    void does();
}

interface ServiceGameFactory {
    ServiceGame getServiceGame();
}

class Coin implements ServiceGame {
    public void does() {
        System.out.println("Coin.does");
    }
}

class Share implements ServiceGame {
    public void does() {
        System.out.println("Share.does");
    }
}

class CoinServiceGameFactory implements ServiceGameFactory {
    public ServiceGame getServiceGame() {
        return new Coin();
    }
}
class ShareServiceGameFactory implements ServiceGameFactory {
    public ServiceGame getServiceGame() {
        return new Share();
    }
}