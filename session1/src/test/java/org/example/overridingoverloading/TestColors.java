package org.example.overridingoverloading;

import org.junit.jupiter.api.Test;

public class TestColors {

    @Test
    public void testOverridingAndOverloading() {
        Blue b = new Blue();
        b.paint();
        b.paint(1);

        Blue r = new Red();
        r.paint();
        r.paint(1);
    }
}
