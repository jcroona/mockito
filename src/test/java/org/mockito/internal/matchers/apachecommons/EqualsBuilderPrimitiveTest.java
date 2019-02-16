package org.mockito.internal.matchers.apachecommons;
import static org.junit.Assert.*;
import org.junit.Test;
import org.mockitoutil.TestBase;

public class EqualsBuilderPrimitiveTest extends TestBase {

    //EqualsBuilder will always return false if isEquals is set as false.
    @Test
    public void testIsEqualsStartFalse() {
        EqualsBuilder builder = new EqualsBuilder();
        builder.setEquals(false);
        boolean[] allTrue = {true, true, true};
        assertEquals(false, builder.append(allTrue, allTrue).isEquals());

    }

    @Test
    public void testIsEqualsDifferingLengths() {
        EqualsBuilder builder = new EqualsBuilder();
        boolean[] allTrue = {true, true, true};
        boolean[] oneFalse = {true,true,true, false};
        assertEquals(false, builder.append(allTrue, oneFalse).isEquals());
    }
    
}