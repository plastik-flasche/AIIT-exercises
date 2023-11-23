package aiit.steuerrechner;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestRechner {
    @Test
    public void testRechner() throws Exception {
        Rechner rechner = new Rechner(1000000);
        assertEquals(486300, rechner.getSteuerabgaben(), 0.01);
    }

    @Test
    public void testRechnerZero() {
        assertThrows(Exception.class, () -> new Rechner(0));
    }

    @Test
    public void testRechnerMax() throws Exception {
        Rechner rechner = new Rechner(Double.MAX_VALUE);
        assert rechner.getSteuerabgaben() < Double.MAX_VALUE;
    }
}

/*
    * 1. Testfall: Einkommen 100000
    *   - 11E3: 0   : 89E3 --> 0
    *   - 18E3: 0.2 : 71E3 --> 3.6E3
    *   - 31E3: 0.3 : 40E3 --> 9.3E3
    *   - 60E3: 0.4 : 0E3  --> 16E3
    *   - 90E3: 0.48: 0E3
    *   - 1E6 : 0.5 : 0E3
    *   - MAX : 0.55: 0E3
 */