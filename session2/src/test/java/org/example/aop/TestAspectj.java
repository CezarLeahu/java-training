package org.example.aop;

import org.junit.jupiter.api.Test;

public class TestAspectj {

    @Test
    public void testLedger() {
        Ledger ledger = new Ledger();
        ledger.put("Black");
        ledger.put("Green");
        ledger.put("Violet");
        ledger.put("Red");
        ledger.put("Blue");
        ledger.put("Orange");

        ledger.trimLedger(3);

        ledger.printLedger();
    }
}
