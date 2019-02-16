package org.mockito.internal.debugging;

import org.junit.Test;
import org.mockitoutil.TestBase;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class MockitoDebuggerImplTest extends TestBase {

    @Test
    public void noInvocations() {
        Object obj = mock(Object.class);
        String out = "";
        out += "********************************\n";
        out += "*** Mockito interactions log ***\n";
        out += "********************************\n";
        MockitoDebuggerImpl mockitoDebugger = new MockitoDebuggerImpl();
        assertEquals(out, mockitoDebugger.printInvocations(obj));
    }
}
