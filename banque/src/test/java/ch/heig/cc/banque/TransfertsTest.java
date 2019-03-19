package ch.heig.cc.banque;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransfertsTest {

    @Test
    void randomTransfert() {
        Transferts tr = new Transferts(new Banque(10));
        int iteration = 1000;
        Thread threadList[] = new Thread[iteration];
        for (int i = 0; i < iteration; i++) {
            threadList[i] = tr.randomTransfert(iteration );
        }

        for(int i = 0; i< iteration; i++){
            try {
                threadList[i].join();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        assertTrue(tr.getBanque().consistent());
    }
}