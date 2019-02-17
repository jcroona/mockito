package org.mockito.internal.util.reflection;
import org.junit.Test;
import org.mockitoutil.TestBase;
import static org.junit.Assert.*;

import org.mockito.internal.util.reflection.GenericMetadataSupport.*;



public class TypeVarBoundedTypeTest extends TestBase {

    @Test
    public void equalsTest(){
        TypeVarBoundedType boundedType1 = new TypeVarBoundedType(null);
        String string = "type String should return false";

        assertTrue(boundedType1.equals(boundedType1));
        assertFalse(boundedType1.equals(string));
        assertFalse(boundedType1.equals(null));  //to achieve clause coverage
    }

    @Test
    public void testNull() {
        TypeVarBoundedType boundedType1 = new TypeVarBoundedType(null);
        BoundedType boundedType2 = new TypeVarBoundedType(null);
        try {
            boundedType1.equals(boundedType2);
            fail("NullPointerException missing");
        } catch (Throwable t) {
            assertEquals(NullPointerException.class, t.getClass());
        }
    }
}
