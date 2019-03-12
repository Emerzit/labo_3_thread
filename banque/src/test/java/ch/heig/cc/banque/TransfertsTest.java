package ch.heig.cc.banque;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransfertsTest {

    @Test
    void randomTransfert() {
        Transferts tr = new Transferts(new Banque(10));
        for (int i = 0; i < 1000; i++) {
            tr.randomTransfert(1000);
        }
        assertTrue(tr.getBanque().consistent());
    }
}