package org.mockito.internal.util.collections;
import org.junit.Test;
import org.mockitoutil.TestBase;
import static org.junit.Assert.*;
import org.mockito.internal.util.collections.Iterables;
import java.util.ArrayList;


public class IterablesFirstTest extends TestBase {

    @Test
    public void testNull() {
        Iterable list = new ArrayList<Integer>(1);
        try {
            Iterables.firstOf(list);
            fail("IllegalArgumentException missing");
        } catch (Throwable t) {
            assertEquals(IllegalArgumentException.class, t.getClass());
        }
    }
}
