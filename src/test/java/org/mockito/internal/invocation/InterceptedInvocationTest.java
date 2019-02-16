package org.mockito.internal.invocation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.debugging.LocationImpl;
import org.mockito.internal.invocation.mockref.MockStrongReference;
import org.mockito.invocation.Location;
import org.mockitousage.IMethods;
import org.mockitoutil.TestBase;
import static org.mockito.internal.invocation.InterceptedInvocation.NO_OP;

public class InterceptedInvocationTest extends TestBase {
    
    private String methodName = "simpleMethod";
    private Object mock = Mockito.mock(IMethods.class);
    private Method method;
    private boolean verified;
    private List<Class<?>> argTypes;
    private Location location;
    private Object[] args = new Object[]{};
    
    @Test
    public void testEquals() {
        if (method == null) {
            if (argTypes == null) {
                argTypes = new LinkedList<Class<?>>();
                for (Object arg : args) {
                    if (arg == null) {
                        argTypes.add(Object.class);
                    } else {
                        argTypes.add(arg.getClass());
                    }
                }
            }

            try {
                method = IMethods.class.getMethod(methodName, argTypes.toArray(new Class[argTypes.size()]));
            } catch (Exception e) {
                throw new RuntimeException("builder only creates invocations of IMethods interface", e);
            }
        }
        InterceptedInvocation inv = new InterceptedInvocation(new MockStrongReference<Object>(mock, false),
        new SerializableMethod(method),
        args,
        NO_OP,
        location == null ? new LocationImpl() : location,
        1);
        InterceptedInvocation invcopy = inv;
        boolean eq = inv.equals(null);
        assertEquals(inv.equals(invcopy), true);
        assertEquals(inv.equals(new Integer(1)), false);
    }
}