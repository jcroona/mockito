package org.mockito.internal.matchers;

import org.junit.Test;
import org.mockitoutil.TestBase;
import static org.junit.Assert.*;

public class ArrayEqualsTest extends TestBase {

    /**
     * Checks that matches method returns false
     * when an object that is not supported is checked.
     */
    @Test
    public void testMatchesNotSupported() {
        ArrayEquals ae = new ArrayEquals(new Integer(1));
        assertFalse(ae.matches(new Integer(1)));
    }
}
