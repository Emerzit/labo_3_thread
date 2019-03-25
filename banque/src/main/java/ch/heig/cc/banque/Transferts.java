package ch.heig.cc.banque;

import java.util.Random;
/*
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

    public Thread randomTransfert(final int nbTrans) {

        Thread transThread = new Thread(new Runnable() {
            public void run() {

                for (int i = 0; i < nbTrans; i++) {
                    banque.transfert(randInt(0, banque.getNbComptes()), randInt(0, banque.getNbComptes()), rand.nextInt());
                }
            }
        });
        return transThread;
    }

    public Banque getBanque() {
        return banque;
    }
}
*/

public class Transferts implements Runnable {
    private Banque banque;
    private int nbTransfert;
    private Random random;

    Transferts(Banque banque, int nbTransfert){
        this.banque = banque;
        this.nbTransfert = nbTransfert;
        random = new Random();
    }


    @Override
    public void run() {
        for(int i = 0; i< nbTransfert; i++){
            int debiteur = random.nextInt(banque.getNbComptes());
            int crediteur = random.nextInt(banque.getNbComptes()-1);
            if(crediteur >= debiteur){
                crediteur++;
            }
            int montant = 1 + random.nextInt(4);
            banque.transfert(debiteur,crediteur,montant);
        }
    }
}