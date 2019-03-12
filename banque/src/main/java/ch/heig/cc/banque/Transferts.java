package ch.heig.cc.banque;

import java.util.Random;

public class Transferts {
    static private Random rand = new Random();
    private Banque banque;

    public Transferts(Banque banque) {
        this.banque = banque;
    }

    private static int randInt(int min, int max) {

        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

    public boolean randomTransfert(final int nbTrans) {

        Thread transThread = new Thread(new Runnable() {
            public void run() {

                for (int i = 0; i < nbTrans; i++) {
                    banque.transfert(randInt(0, banque.getNbComptes()), randInt(0, banque.getNbComptes()), rand.nextInt());
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        return true;
    }

    public Banque getBanque() {
        return banque;
    }
}
